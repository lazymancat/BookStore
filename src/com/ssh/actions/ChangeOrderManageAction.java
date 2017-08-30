package com.ssh.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.OrderDao;
import com.ssh.model.Orders;
import com.ssh.model.OrdersV;

public class ChangeOrderManageAction extends ActionSupport{
	private List<OrdersV> list = new ArrayList();
	private OrderDao orderDao;
	protected int operateNum = 0;//操作数 0：默认 1：发货  2：同意取消 3：不同意取消返回原状态 
	protected int operateId = 0;//完成订单的id
	protected int id; //界面显示数据的索引
	protected final int pageSize=5; //每页显示记录的个数
	protected int pageNo=1; //计数器,从第1页开始
	protected int currentPage; //当前页
	protected int totalPage; //总页数
	protected List<OrdersV> ordersVListInPage;
	
	public String execute(){
		list = orderDao.queryOrder();
		System.out.println("list"+list);
		System.out.println("操作数"+operateNum+"操作ID"+operateId);
		//发货
		out:if(operateNum == 1 && operateId != 0){
			//只允许状态{已下单} 不允许数据库中没有订单修改状态
			Orders orders = orderDao.queryOrderById(operateId);
			if(orders == null || orders.getOrderStatus() != 1 ){
				operateNum = 0;// *重置id为0，不然会无限进入这里
				operateId = 0;
				break out;
			}
			orderDao.updateStatusById(operateId, 2);
			list = orderDao.queryOrder();
			operateNum = 0;
			operateId = 0;
		}
		//同意取消订单
		outA:if(operateNum == 2 && operateId != 0){
			//只允许状态{取消订单，申请取消订单} 不允许数据库中没有订单修改状态
			Orders orders = orderDao.queryOrderById(operateId);
			if(orders == null || (orders.getOrderStatus() != -1 &&  orders.getOrderStatus() != -2)){
				operateNum = 0;// *重置id为0，不然会无限进入这里
				operateId = 0;
				break outA;
			}
			orderDao.updateStatusById(operateId, -3);
			list = orderDao.queryOrder();
			operateNum = 0;
			operateId = 0;
		}
		//3：不同意取消返回原状态 
		outB:if(operateNum == 3 && operateId != 0){
			//只允许状态{取消订单，申请取消订单} 不允许数据库中没有订单修改状态
			Orders orders = orderDao.queryOrderById(operateId);
			if(orders == null || (orders.getOrderStatus() != -1 &&  orders.getOrderStatus() != -2)){
				operateNum = 0;// *重置id为0，不然会无限进入这里
				operateId = 0;
				break outB;
			}
			System.out.println("期待结果："+orders.getOrderStatus()*-1);
			orderDao.updateStatusById(operateId, orders.getOrderStatus()*-1);
			list = orderDao.queryOrder();
			operateNum = 0;
			operateId = 0;
		}
		//分页功能
		if(list == null){
			return SUCCESS;
		}else if(list.size()%pageSize==0){
			totalPage=list.size()/pageSize;
		}else{
			totalPage=list.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=1;
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		//根据当前页查询要在该页上显示的数据
		List tmp;
		if(list.size() == 0){
			ordersVListInPage = null;
			return SUCCESS;
		}else if(list.size() < pageNo*pageSize){
			tmp= list.subList((pageNo-1)*pageSize,list.size());
		}else{
			tmp= list.subList((pageNo-1)*pageSize,pageNo*pageSize);
		}
		ordersVListInPage = tmp;
		
		currentPage=pageNo;
		
		if(list == null)
			return INPUT;
		else
			return SUCCESS;
	}

	public List<OrdersV> getList() {
		return list;
	}

	public void setList(List<OrdersV> list) {
		this.list = list;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public int getOperateNum() {
		return operateNum;
	}

	public void setOperateNum(int operateNum) {
		this.operateNum = operateNum;
	}

	public int getOperateId() {
		return operateId;
	}

	public void setOperateId(int operateId) {
		this.operateId = operateId;
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

	public List<OrdersV> getOrdersVListInPage() {
		return ordersVListInPage;
	}

	public void setOrdersVListInPage(List<OrdersV> ordersVListInPage) {
		this.ordersVListInPage = ordersVListInPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	
}
