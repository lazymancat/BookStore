package com.ssh.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ssh.model.Book;
import com.ssh.model.ConsignmentAddress;
import com.ssh.model.OrderItemV;
import com.ssh.model.OrderItems;
import com.ssh.model.Orders;
import com.ssh.model.OrdersV;

public class OrderDao {
	private BookDao bookDao;
	private OrderItemsDao orderItemsDao;
	private ConsignmentAddressDao consignmentAddressDao;
	private SessionFactory sessionFactory;
	//输出：成功-订单表所有（视图用）类list 失败 NULL
	public List<OrdersV> queryOrder(){
		Session session=null;
		List<OrdersV> list = new ArrayList();
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from Orders ORDER BY id DESC";
			Query query=session.createQuery(queryString);
			List ordersList= query.list();
			if(ordersList == null || ordersList.size() == 0){
				System.out.println("queryOrder查询结果为空");
				return null;
			}
			for(Iterator it = ordersList.iterator(); it.hasNext();){
				Orders orders = (Orders)it.next();
				ConsignmentAddress  consignmentAddress = 
		consignmentAddressDao.getConsignmentAddressById(orders.getAddressId());
				List orderItemsVList = 
		orderItemsDao.getOrderItemsDaoByOrdId(orders.getId());
				OrdersV ordersV = new OrdersV();
				ordersV.setAll(orders, consignmentAddress, orderItemsVList);
				list.add(ordersV);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	//操作：查询订单 ,条件：订单Id,结果：成功返回订单对象，失败返回null;
	public Orders queryOrderById(int id){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from Orders where Id=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			List list = query.list();
			if(list == null || list.size() == 0){
				System.out.println("queryOrderById查询结果集为空,id为"+ id);
				return null;
			}
			return (Orders)list.get(0);
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	//操作：更新订单表中订单状态,条件 ：订单id 订单操作符 ,返回结果 成功：1 ,失败：0
	public int updateStatusById(int oId,int status){
		Session session=null;
		List<OrdersV> list = new ArrayList();
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			
			Transaction	trans=session.beginTransaction();
			String sql = "update Orders t set t.orderStatus='"
				+ status
				+ "' where id="
				+ oId;
			System.out.println("updateStatusById_sql:"+ sql);
	        Query query = session.createQuery(sql);  
	        query.executeUpdate();  
	        trans.commit(); 
			
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}finally{
			//关闭session
			session.close();
		}
	}
	//输出：该用户所有订单  输入： 用户id 
	public List<OrdersV> queryOrderByCId (int cid){
		Session session=null;
		List<OrdersV> list = new ArrayList();
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from Orders where cusId=? ORDER BY id DESC";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cid);
			List ordersList= query.list();
			for(Iterator it = ordersList.iterator(); it.hasNext();){
				Orders orders = (Orders)it.next();
				ConsignmentAddress  consignmentAddress = 
		consignmentAddressDao.getConsignmentAddressById(orders.getAddressId());
				List orderItemsVList = 
		orderItemsDao.getOrderItemsDaoByOrdId(orders.getId());
				OrdersV ordersV = new OrdersV();
				ordersV.setAll(orders, consignmentAddress, orderItemsVList);
				list.add(ordersV);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	//submitOrder函数的测试输出
	public void output(String str,List<OrderItems> list){
		System.out.println("---------------"+str+"------------------");
		if(list == null || list.size()==0)return ;
		System.out.println("size:" + list.size());
		for(Iterator it = list.iterator(); it.hasNext();){
			OrderItems tmp = (OrderItems)it.next();
			System.out.println(tmp.getBookId());
			System.out.println(tmp.getQuantity());
			System.out.println(tmp.getSubtotal());
			System.out.println("-------");
		}
		System.out.println("---------------------------");
	}
	//输出：异常：-1  成功：0  库存不足或不存在这本书：BOOKID 输入：购物车list
	public List<String> checkstockStatus(List<OrderItemV> shopping){
		List list = new ArrayList();
		try{
			//订单列表对象list return 条件：库存不足 输出：库存不足书ID
			for(Iterator it = shopping.iterator(); it.hasNext();){
				OrderItemV tmp = (OrderItemV)it.next();
				Book book = bookDao.getBookByBookIdWCH(tmp.getBookid());
				if(book== null){
					list.add(tmp.getName()+"图书不存在");
				}
				if(book.getStockStatus() < tmp.getQuantity()){
					list.add(book.getName()+"库存余量不足，当前库存量为"+book.getStockStatus());
				}
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public int submitOrder(List<OrderItemV> shopping, int cusId,
			int addressId){
		Session session=null;
		
		List<OrderItems> list = new ArrayList();//订单细明组合
		float subtotal = 0;//小计
		float cnt = 0;//总计
		Orders orders = new Orders();//订单对象
		int orderId = 0;
		int num = -1;//数据插入后返回主键
		String sql = null;
		Transaction trans = null;
		List stockStatus = new ArrayList();//书库存量
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			//订单列表对象list return 条件：库存不足 输出：库存不足书ID
			for(Iterator it = shopping.iterator(); it.hasNext();){
				OrderItemV tmp = (OrderItemV)it.next();
				Book book = bookDao.getBookByBookIdWCH(tmp.getBookid());
				stockStatus.add(book);
				//库存不足
				if(book.getStockStatus() < tmp.getQuantity()){
					return tmp.getBookid();
				}
				subtotal = book.getPrice()* tmp.getQuantity();
				cnt += subtotal;
				//list加入对象是引用，所以每次必须new新对象
				OrderItems orderItems = new OrderItems();//订单细明对象
				orderItems.setAll(tmp.getBookid(), tmp.getQuantity(), subtotal);
				list.add(orderItems);
			}
			output("add", list);
			//订单对象下单
			//打开一个事务
			trans=session.beginTransaction();
			//保存数据，返回主键
			orders.setAll(cusId, addressId, 0, cnt, 
					new Timestamp((new java.util.Date()).getTime()), 1);
			//orders.setAll(cusId, addressId, payType, price, createDate, orderStatus)
			sql =session.save(orders).toString();
			orderId=Integer.parseInt(sql); //存到缓冲区里,并未真正写入数据库
			//提交事物
			trans.commit();	
			System.out.println("orderId="+orderId);
			//插入失败
			if(orderId < 1){
				System.out.println("订单插入失败");
				return -2;
			}
			//加入订单
			for(Iterator it = list.iterator(); it.hasNext();){
				OrderItems orderItems = (OrderItems)it.next();
				orderItems.setOrdId(orderId);
				trans=session.beginTransaction();
				//保存数据，返回受影响的行数
				sql = session.save(orderItems).toString();
				num = Integer.parseInt(sql); //存到缓冲区里,并未真正写入数据库
				System.out.println("num1=" + num + "BookId:" +orderItems.getBookId());
				//提交事物
				trans.commit();	
				if(num < 0){
					System.out.println("submitOrder_return_ERR");
					return -3;
				}
			}
			//减少库存
			for(int i = 0; i < list.size(); i++){
				OrderItems orderItems = (OrderItems)list.get(i);
				Book book = (Book)stockStatus.get(i);
				int newStockStatus = book.getStockStatus() - orderItems.getQuantity();
				trans=session.beginTransaction();
				sql = "update Book t set t.stockStatus='"
						+ newStockStatus
						+ "' where id="
						+ orderItems.getBookId();
				System.out.println("StockStatus_sql:"+ sql);
		        Query query = session.createQuery(sql);  
		        query.executeUpdate();  
		        trans.commit(); 
			}
			return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return -1;
		}finally{
			//关闭session
			session.close();
		}
	}
/*	//查询省份id，查询不到就插入省份并返回省份id--f=force强制
	public int getProvinceByNameF(String province){
		Session session=null;
		try{
			//获得session
			int index = -1;
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from Province where name=?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, province);
			List list = query.list();
			if(list == null || list.size() == 0){
				Transaction trans = session.beginTransaction();
				Province tmp = new Province();
				tmp.setName(province);
				int num=Integer.parseInt(session.save(tmp).toString()); //存到缓冲区里,并未真正写入数据库
				System.out.println("getProvinceByNameF.num:"+num);
				trans.commit();
				//再执行
				list = query.list();
			}
			index = ((Province)list.get(0)).getId();
			
			return index;
		}catch(Exception ex){
			ex.printStackTrace();
			return -2;
		}finally{
			//关闭session
			session.close();
		}
	}*/
	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public OrderItemsDao getOrderItemsDao() {
		return orderItemsDao;
	}
	public void setOrderItemsDao(OrderItemsDao orderItemsDao) {
		this.orderItemsDao = orderItemsDao;
	}
	public ConsignmentAddressDao getConsignmentAddressDao() {
		return consignmentAddressDao;
	}
	public void setConsignmentAddressDao(ConsignmentAddressDao consignmentAddressDao) {
		this.consignmentAddressDao = consignmentAddressDao;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
