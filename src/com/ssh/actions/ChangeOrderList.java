package com.ssh.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.OrderDao;
import com.ssh.model.Orders;
import com.ssh.model.OrdersV;

public class ChangeOrderList extends ActionSupport{
	private int cid;
	private List<OrdersV> list = new ArrayList();
	private OrderDao orderDao;
	protected int undoId = 0;//申请取消订单的id
	protected int doneId = 0;//完成订单的id
	protected int id; //界面显示数据的索引
	protected final int pageSize=5; //每页显示记录的个数
	protected int pageNo=1; //计数器,从第1页开始
	protected int currentPage; //当前页
	protected int totalPage; //总页数
	protected List<OrdersV> ordersVListInPage;
	
	public String execute(){
		Map session=ActionContext.getContext().getSession();
		Object cidObj = (Object)session.get("customerId");
		if(cidObj == null){//防返回null错误
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			return INPUT;
		}
		cid = Integer.valueOf(cidObj.toString());
		if(cid == 0){ //用户没登录--后台验证
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!@##$");
			return INPUT;
		}
		list = orderDao.queryOrderByCId(cid);
		//申请取消订单
		System.out.println("要取消的订单ID="+undoId);
		out:if(undoId != 0){
			//只允许状态{已下单，已发货取消订单} 不允许数据库中没有订单修改状态
			Orders orders = orderDao.queryOrderById(undoId);
			if(orders == null || (orders.getOrderStatus() != 1 &&  orders.getOrderStatus() != 2)){
				undoId=0;// *重置id为0，不然会无限进入这里
				break out;
			}
			if(orders.getOrderStatus() == 1)
				orderDao.updateStatusById(undoId, -1);
			if(orders.getOrderStatus() == 2)
				orderDao.updateStatusById(undoId, -2);
			list = orderDao.queryOrderByCId(cid);
			undoId = 0;
		}
		//完成订单
		System.out.println("要完成的订单ID="+doneId);
		outDone:if(doneId != 0){
			//只允许状态{已下单，已发货取消订单}不允许数据库中没有订单修改状态
			Orders orders = orderDao.queryOrderById(doneId);
			if(orders == null || (orders.getOrderStatus() != 1 &&  orders.getOrderStatus() != 2)){
				doneId = 0;// *重置id为0，不然会无限进入这里
				break outDone;
			}
			orderDao.updateStatusById(doneId, 3);
			list = orderDao.queryOrderByCId(cid);
			doneId = 0;
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
		
			return SUCCESS;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public int getUndoId() {
		return undoId;
	}

	public void setUndoId(int undoId) {
		this.undoId = undoId;
	}

	public int getDoneId() {
		return doneId;
	}

	public void setDoneId(int doneId) {
		this.doneId = doneId;
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
