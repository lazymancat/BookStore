package com.ssh.dao;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.model.Book;
import com.ssh.model.OrderItemV;
import com.ssh.model.OrderItems;
import com.ssh.model.OrderItemsV;

public class OrderItemsDao {
	private BookDao bookDao;
	private SessionFactory sessionFactory;
	//条件：结果：
	public List<OrderItemsV> getOrderItemsDaoAllStatistics(String s, String e, int order){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象   
			Timestamp sDate = Timestamp.valueOf(s + " 00:00:00");   
			Timestamp eDate = Timestamp.valueOf(e + " 00:00:00"); 
			if(sDate == null || eDate == null){
				return null;
			}
			System.out.println("sDate"+sDate);
			System.out.println("eDate"+eDate);
			String queryString=
	"from OrderItems where ordId in(select id from Orders where createDate >= ? and createDate <= ?)";
			System.out.println("queryString" + queryString);
			Query query=session.createQuery(queryString);
			query.setDate(0, sDate);
			query.setDate(1, eDate);
			
			List<OrderItemsV> res = new ArrayList();
			List<OrderItems> list = query.list();
			System.out.println("size"+list.size());
			for(Iterator it = list.iterator(); it.hasNext();){
				OrderItems orderItems = (OrderItems)it.next();
				OrderItemsV orderItemsV = new OrderItemsV();
				Book book = bookDao.getBookByBookIdWCH(orderItems.getBookId());
				orderItemsV.setAll(orderItems, book.getName());
				int index = res.indexOf(orderItemsV);
				if(index == -1){
					res.add(orderItemsV);
				}else{
					orderItemsV.setQuantity(orderItemsV.getQuantity() + ((OrderItemsV)res.get(index)).getQuantity());
					orderItemsV.setSubtotal(orderItemsV.getSubtotal() + ((OrderItemsV)res.get(index)).getSubtotal());
					res.set(index, orderItemsV);
				}
			}
//			((OrderItemsV)res.get(0)).setSubtotal(-1);
			if(order == 1){
				Collections.sort(res, new Comparator<OrderItemsV>(){  
					  
		            /*  
		             * int compare(o1, o2) 返回一个基本类型的整型，  
		             * 返回负数表示：o1 小于o2，  
		             * 返回0 表示：o1和o2相等，  
		             * 返回正数表示：o1大于o2。  
		             */  
		            public int compare(OrderItemsV o1, OrderItemsV o2) {  
		            	
		                if(o1.getQuantity() > o2.getQuantity()){  
		                    return 1;  
		                }  
		                if(o1.getQuantity() == o2.getQuantity()){  
		                    return 0;  
		                }  
		                return -1;  
		            }  
		        });
			}else if(order==2){
				Collections.sort(res, new Comparator<OrderItemsV>(){  
					  
		            /*  
		             * int compare(o1, o2) 返回一个基本类型的整型，  
		             * 返回负数表示：o1 小于o2，  
		             * 返回0 表示：o1和o2相等，  
		             * 返回正数表示：o1大于o2。  
		             */  
		            public int compare(OrderItemsV o1, OrderItemsV o2) {  
		            	
		                if(o1.getSubtotal() > o2.getSubtotal()){  
		                    return 1;  
		                }  
		                if(o1.getSubtotal() == o2.getSubtotal()){  
		                    return 0;  
		                }  
		                return -1;  
		            }  
		        });
			}
			for(Iterator it = res.iterator(); it.hasNext();){
				OrderItemsV orderItemsV = (OrderItemsV) it.next();
				System.out.println(orderItemsV.getBookName());
				System.out.println(orderItemsV.getQuantity());
				System.out.println(orderItemsV.getSubtotal());
			}
			return res;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	//条件：地址id 结果：返回地址对象
	public List<OrderItemsV> getOrderItemsDaoByOrdId(int OrdId){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from OrderItems where OrdId = ?";
			Query query=session.createQuery(queryString);
			query.setParameter(0, OrdId);
			List<OrderItemsV> res = new ArrayList();
			List<OrderItems> list = query.list();
			for(Iterator it = list.iterator(); it.hasNext();){
				OrderItems orderItems = (OrderItems)it.next();
				OrderItemsV orderItemsV = new OrderItemsV();
				Book book = bookDao.getBookByBookIdWCH(orderItems.getBookId());
				orderItemsV.setAll(orderItems, book.getName());
				res.add(orderItemsV);
			}
			return res;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
