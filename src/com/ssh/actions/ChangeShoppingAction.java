package com.ssh.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.dao.ConsignmentAddressDao;
import com.ssh.dao.OrderDao;
import com.ssh.dao.OrderItemVDao;
import com.ssh.model.ConsignmentAddress;
import com.ssh.model.OrderItemV;

public class ChangeShoppingAction extends ActionSupport{
	private List<OrderItemV> shopping;
	private List<OrderItemV> bookListInPage;
	private List<ConsignmentAddress> addressList;
	private BookDao bookDao;
	private ConsignmentAddressDao consignmentAddressDao;
	private OrderDao orderDao;
	private OrderItemVDao oivd;
	private int customerId;
	private int subID = -1;//要减少的id
	private int addID = -1;//要增加的id
	private int id; //界面显示数据的索引
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始
	private int currentPage; //当前页
	private int totalPage; //总页数
	private List<String> orderERR;
	//测试输出
	public void output(){
		if(shopping == null)return ;
		System.out.println("----------------------------------------");
		System.out.println("shopping.size=:"+shopping.size());
		for(Iterator it = shopping.iterator();it.hasNext();){
			OrderItemV tmp = (OrderItemV)it.next();
			System.out.println("bookId:"+ tmp.getBookid());
			System.out.println("bookName:"+tmp.getName());
			System.out.println("quantity:"+tmp.getQuantity());
		}
		System.out.println("----------------------------------------");
	}
	public String execute(){
		//获得所有数据
		Map session=ActionContext.getContext().getSession();
		Object cidObj = (Object)session.get("customerId");
		if(cidObj == null)//防返回null错误
			return INPUT;
		customerId = Integer.valueOf(cidObj.toString());
		if(customerId == 0) //用户没登录--后台验证
			return INPUT;
		//获取地址
		addressList = consignmentAddressDao.getConsignmentAddressbyCusId(customerId);
		if(addressList == null)//防返回null错误
			return SUCCESS;
		shopping = (List)session.get("shopping");
		if(shopping == null){//如果购物车为空直接跳出
			return SUCCESS;
		}
		output();
		//减少功能
		System.out.println("subID="+subID);
		out:if(subID != -1){
			OrderItemV tmp = oivd.getBookByBookId(subID);
			if(tmp == null){//书库中不存在这本书
				subID = -1;
				break out;
			}
			//使用List.indexOf()必须经过重写比较类的equals()函数
			//否则，将通过比较内存地址来鉴别两个类是否相等而不是参数是否相等
			int rmIndex= shopping.indexOf(tmp);
			if(rmIndex == -1){//地址栏输入了购物车不存在的删除数目
				subID = -1;
				break out;
			}
			int targetNum = ((OrderItemV)shopping.get(rmIndex)).getQuantity();
			System.out.println("----------------------------------------");
			System.out.println("tmp.id="+tmp.getBookid());
			System.out.println("rmIndex="+rmIndex);
			System.out.println("targetNum="+targetNum);
			System.out.println("----------------------------------------");
			if(targetNum == 1){
				shopping.remove(rmIndex);
			}else{
				tmp.setQuantity(targetNum - 1);
				shopping.set(rmIndex, tmp);
			}
			if(shopping.size() == 0){//购物车被清空时
				session.put("shopping", null);
			}else{
				session.put("shopping", shopping);
			}
			subID = -1;
		}
		//增加功能
		System.out.println("addID="+addID);
		out_add:if(addID != -1){
			OrderItemV tmp = oivd.getBookByBookId(addID);
			if(tmp == null){//书库中不存在这本书
				addID = -1;
				break out_add;
			}
			//使用List.indexOf()必须经过重写比较类的equals()函数
			//否则，将通过比较内存地址来鉴别两个类是否相等而不是参数是否相等
			int addIndex= shopping.indexOf(tmp);
			int targetNum = ((OrderItemV)shopping.get(addIndex)).getQuantity();
			System.out.println("----------------------------------------");
			System.out.println("tmp.id="+tmp.getBookid());
			System.out.println("addIndex="+addIndex);
			System.out.println("targetNum="+targetNum);
			System.out.println("----------------------------------------");
			tmp.setQuantity(targetNum + 1);
			if(addIndex == -1){//地址栏输入了购物车不存在的删除数目
				addID = -1;
				shopping.add(tmp);
				session.put("shopping", shopping);
				break out_add;
			}
			shopping.set(addIndex, tmp);
			if(shopping.size() == 0){//购物车被清空时
				session.put("shopping", null);
			}else{
				session.put("shopping", shopping);
			}
			addID = -1;
		}
		//验证库存 记录库存不足信息
		orderERR = orderDao.checkstockStatus(shopping);
		//分页功能
		if(shopping.size()%pageSize==0){
			totalPage=shopping.size()/pageSize;
		}else{
			totalPage=shopping.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		List tmp;
		if(shopping.size() == 0){
			bookListInPage = null;
			return SUCCESS;
		}else if(shopping.size() < pageNo*pageSize){
			tmp= shopping.subList((pageNo-1)*pageSize,shopping.size());
		}else{
			tmp= shopping.subList((pageNo-1)*pageSize,pageNo*pageSize);
		}
		bookListInPage = tmp;
		//bookListInPage=bookDao.queryByPage(tmp);//购物车存入数据库做法
		currentPage=pageNo;

		return SUCCESS;
	}
	public List<OrderItemV> getShopping() {
		return shopping;
	}
	public void setShopping(List<OrderItemV> shopping) {
		this.shopping = shopping;
	}
	public List<OrderItemV> getBookListInPage() {
		return bookListInPage;
	}
	public void setBookListInPage(List<OrderItemV> bookListInPage) {
		this.bookListInPage = bookListInPage;
	}
	public List<ConsignmentAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<ConsignmentAddress> addressList) {
		this.addressList = addressList;
	}
	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public ConsignmentAddressDao getConsignmentAddressDao() {
		return consignmentAddressDao;
	}
	public void setConsignmentAddressDao(ConsignmentAddressDao consignmentAddressDao) {
		this.consignmentAddressDao = consignmentAddressDao;
	}
	public OrderItemVDao getOivd() {
		return oivd;
	}
	public void setOivd(OrderItemVDao oivd) {
		this.oivd = oivd;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSubID() {
		return subID;
	}
	public void setSubID(int subID) {
		this.subID = subID;
	}
	public int getAddID() {
		return addID;
	}
	public void setAddID(int addID) {
		this.addID = addID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public List<String> getOrderERR() {
		return orderERR;
	}
	public void setOrderERR(List<String> orderERR) {
		this.orderERR = orderERR;
	}
}
