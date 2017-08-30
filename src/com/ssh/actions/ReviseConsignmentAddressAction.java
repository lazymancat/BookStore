package com.ssh.actions;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.ConsignmentAddressDao;
import com.ssh.model.ConsignmentAddress;
import com.ssh.model.Customer;

public class ReviseConsignmentAddressAction extends ActionSupport{
	private ConsignmentAddress consignmentAddress;
	private ConsignmentAddressDao cad;
	
	public ReviseConsignmentAddressAction(){}
	
	public String execute(){
		consignmentAddress.setCustomer((Customer)ActionContext.getContext().getSession().get("theCustomer"));
		if(cad.reviseConsignmentAddress(consignmentAddress)){
			ActionContext.getContext().getSession().put("theConsignmentAddress", consignmentAddress);
			ActionContext.getContext().getSession().put("info", "修改成功");
			return "success";
		}else{
			ActionContext.getContext().getSession().put("info", "修改失败");
			return "input";
		}
	}
	
	public void validate(){
		if(consignmentAddress.getConsignmentName() == null || consignmentAddress.getConsignmentName().equals("")){
			addFieldError("consignmentAddress.consignmentName", "收货人不能为空");
		}else if(consignmentAddress.getConsignmentName().length() > 20){
			addFieldError("consignmentAddress.consignmentName", "收货人长度不能超过20位");
		}
		
		if(consignmentAddress.getAddress() == null || consignmentAddress.getAddress().equals("")){
			addFieldError("consignmentAddress.address", "地址不能为空");
		}else if(consignmentAddress.getAddress().length() > 100){
			addFieldError("consignmentAddress.address", "地址长度不能大于100位");
		}
		
		if(consignmentAddress.getPostCode() == null || consignmentAddress.getPostCode().equals("")){
			addFieldError("consignmentAddress.postCode", "邮编不能为空");
		}else if(checkNumberOnly(consignmentAddress.getPostCode()) == false){
			addFieldError("consignmentAddress.postCode", "邮编不能包含数字以外的其他字符");
		}else if(consignmentAddress.getPostCode().length() != 6){
			addFieldError("consignmentAddress.postCode", "邮编长度必须为6位");
		}
		
		if(consignmentAddress.getPhone() == null || consignmentAddress.getPhone().equals("")){
			addFieldError("consignmentAddress.phone", "联系电话不能为空");
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

	public ConsignmentAddress getConsignmentAddress() {
		return consignmentAddress;
	}

	public void setConsignmentAddress(ConsignmentAddress consignmentAddress) {
		this.consignmentAddress = consignmentAddress;
	}

	public ConsignmentAddressDao getCad() {
		return cad;
	}

	public void setCad(ConsignmentAddressDao cad) {
		this.cad = cad;
	}
}
