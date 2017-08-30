package com.ssh.model;

public class Orders {
	private int id;
	private int cusId;
	private int addressId;
	private int payType;//付款方式	0:货到付款,1:网银支付
	private float price;//订单总金额
	private java.sql.Timestamp createDate;
	private int orderStatus;//订单状态	1:已下单，2:已发货，3:订单完成  -1：申请取消订单 -2：已发货申请取消订单 -3：取消订单
	//设置所有属性
	public void setAll(int cusId, int addressId,int payType,float price
			,java.sql.Timestamp createDate,int orderStatus){
		this.cusId = cusId;
		this.addressId = addressId;
		this.payType = payType;
		this.price = price;
		this.createDate = createDate;
		this.orderStatus = orderStatus;
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
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
}
