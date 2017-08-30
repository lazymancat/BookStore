package com.ssh.model;

import java.util.ArrayList;
import java.util.List;

public class OrdersV {
	private int id;
	private int cusId;
	private ConsignmentAddress address;
	private String payType;//付款方式	0:货到付款,1:网银支付
	private float price;//订单总金额
	private String createDate;
	private String orderStatus;//订单状态	1:已下单，2:已发货，3:订单完成  -1：申请取消订单 -2：已发货申请取消订单 -3：取消订单
	private List itemList = new ArrayList();
	public void setAll(Orders o,ConsignmentAddress address, List<OrderItemsV> l){
		this.id = o.getId();
		this.cusId = o.getCusId();
		this.address = address;
		if(o.getPayType() == 0)
			this.payType = "货到付款";
		this.price = o.getPrice();
		this.createDate = o.getCreateDate().toString();
		System.out.print("OrderStatus="); 
		switch(o.getOrderStatus()) 
		{ 
		case 1: 
			this.orderStatus = "已下单";
		break; 
		case 2: 
			this.orderStatus = "已发货";
		break;
		case 3: 
			this.orderStatus = "订单完成";
		break;
		case -1: 
			this.orderStatus = "申请取消订单";
		break;
		case -2: 
			this.orderStatus = "已发货申请取消订单";
		break;
		case -3: 
			this.orderStatus = "取消订单";
		break;
		default: 
			System.out.println("default"); 
		break; 
		} 
		this.itemList = l;
	}
	//重写比较函数
	public boolean equals(Object obj) {
        if (obj instanceof OrdersV) {
        	OrdersV tmp = (OrdersV) obj;
            System.out.println("比较的OrdersV_id是"+ tmp.getId());
            if(this.getId() == tmp.getId())
            	return true;
        }
        return false;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public ConsignmentAddress getAddress() {
		return address;
	}
	public void setAddress(ConsignmentAddress address) {
		this.address = address;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List getItemList() {
		return itemList;
	}
	public void setItemList(List itemList) {
		this.itemList = itemList;
	}
}
