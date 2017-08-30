package com.ssh.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ConsignmentAddressDao;
import com.ssh.dao.OrderDao;
import com.ssh.model.Book;
import com.ssh.model.OrderItemV;

public class OrderAction extends ActionSupport{
	private List<OrderItemV> shopping;
	private int addressId;
	private int cid;
	private OrderDao orderDao;

	public String execute(){
		Map session=ActionContext.getContext().getSession();
		Object cidObj = (Object)session.get("customerId");
		if(cidObj == null)//防返回null错误
			return INPUT;
		cid = Integer.valueOf(cidObj.toString());
		if(cid == 0) //防返回null错误--后台验证，用户没登录
			return INPUT;
		shopping = (List)session.get("shopping");
		if(shopping == null || shopping.size() == 0)//防返回null错误--后台验证
			return INPUT;
		if(addressId == 0)
			return INPUT;
		int check = orderDao.submitOrder(shopping, cid, addressId);
		System.out.println("check="+check);
		if(check > 0){
			return INPUT;//库存不足，交给购物车去重新验证库存
		}else if(check < 0){//数据库插入失败
			return INPUT;
		}else{
			//订单下单成功
			shopping = null;
			session.put("shopping", shopping);
		}
		return SUCCESS;
	}

	public List<OrderItemV> getShopping() {
		return shopping;
	}

	public void setShopping(List<OrderItemV> shopping) {
		this.shopping = shopping;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
//	private String province;
//	private String city;
//	private String area;
//	private String address;
}
