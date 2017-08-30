package com.ssh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ConsignmentAddressDao;
import com.ssh.model.ConsignmentAddress;
import com.ssh.model.Customer;

public class AddConsignmentAddressAction extends ActionSupport{
	private ConsignmentAddressDao cad;
	private ConsignmentAddress consignmentAddress;
	private Customer customer;
	private final int quantityLimit = 5;
	
	public AddConsignmentAddressAction(){}
	
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		customer = (Customer)session.get("theCustomer");
		if(customer == null){
			session.put("info", "添加失败，登录信息已过期，请刷新页面并重试！");
			return "input";
		}else if(cad.checkAboveTheLimit(customer.getId(), quantityLimit)){
			session.put("info", "添加失败，收货地址数量已达上限！");
			return "input";
		}else{
			consignmentAddress.setCustomer(customer);
			if(cad.addConsignmentAddress(consignmentAddress)){
				session.put("info", "添加成功!");
				return "success";
			}else{
				session.put("info", "添加失败！");
				return "input";
			}
		}
	}
	
	public void validate(){
		if(consignmentAddress.getConsignmentName() == null || consignmentAddress.getConsignmentName().equals("")){
			addFieldError("consignmentAddress.consignmentName", "收货人不能为空");
		}else if(consignmentAddress.getConsignmentName().length() > 20){
			addFieldError("consignmentAddress.consignmentName", "收货人长度不能超过20位");
		}
		
		if(consignmentAddress.getAddress() == null || consignmentAddress.getAddress().equals("")){
			addFieldError("consignmentAddress.address", "详细地址不能为空");
		}else if(consignmentAddress.getAddress().length() > 100){
			addFieldError("consignmentAddress.address", "地址长度不能大于100位");
		}
		
		if(consignmentAddress.getPostCode() == null || consignmentAddress.getPostCode().equals("")){
			addFieldError("consignmentAddress.postCode", "邮政编码不能为空");
		}else if(checkNumberOnly(consignmentAddress.getPostCode()) == false){
			addFieldError("consignmentAddress.postCode", "邮编不能包含数字以外的其他字符");
		}else if(consignmentAddress.getPostCode().length() != 6){
			addFieldError("consignmentAddress.postCode", "邮编长度必须为6位");
		}
		
		if(consignmentAddress.getPhone() == null || consignmentAddress.getPhone().equals("")){
			addFieldError("consignmentAddress.phone", "联系方式不能为空");
		}else if(checkNumberOnly(consignmentAddress.getPhone()) == false){
			addFieldError("consignmentAddress.phone", "联系电话不能包含数字以外的字符");
		}else if(consignmentAddress.getPhone().length() > 11){
			addFieldError("consignmentAddress.phone", "联系电话长度不能超过11位");
		}
	}
	
	public boolean checkNumberOnly(String str){
		for(int i = 0; i < str.length(); i++){
			if(!(str.charAt(i) >= 48 && str.charAt(i) <= 57)){
				return false;
			}
		}
		return true;
	}
	
	public ConsignmentAddressDao getCad() {
		return cad;
	}

	public void setCad(ConsignmentAddressDao cad) {
		this.cad = cad;
	}

	public ConsignmentAddress getConsignmentAddress() {
		return consignmentAddress;
	}

	public void setConsignmentAddress(ConsignmentAddress consignmentAddress) {
		this.consignmentAddress = consignmentAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
