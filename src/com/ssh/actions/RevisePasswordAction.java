package com.ssh.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.CustomerDao;
import com.ssh.model.Customer;

public class RevisePasswordAction extends ActionSupport{
	private Customer customer;
	private CustomerDao cd;
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirm; 
	
	public RevisePasswordAction(){}

	public String execute(){
		customer = (Customer)ActionContext.getContext().getSession().get("theCustomer");
		customer.setPassword(newPassword);
		if(cd.reviseCustomerPassword(customer) == true){
			ActionContext.getContext().getSession().put("theCustomer", customer);
			addFieldError("oldPassword", "修改密码成功");
			return "success";
		}else{
			addFieldError("oldPassword", "修改密码失败");
			return "input";
		}
	}
	
	public void validate(){
		customer = (Customer)ActionContext.getContext().getSession().get("theCustomer");
		if(customer == null){
			addFieldError("oldPassword", "登录已过期，请重新登录");
		}
		if(oldPassword == null || oldPassword.equals("")){
			addFieldError("oldPassword", "旧密码不能为空");
		}else if(!oldPassword.equals(customer.getPassword())){
			addFieldError("oldPassword", "旧密码不正确");
		}
		
		if(newPassword == null || newPassword.equals("")){
			addFieldError("newPassword", "新密码不能为空");
		}else if(newPassword.length() < 6 || newPassword.length() > 10){
			addFieldError("newPassword", "新密码长度不在6~10位的有效范围内");
		}
		
		if(newPasswordConfirm == null || newPasswordConfirm.equals("")){
	    	addFieldError("newPasswordConfirm", "确认密码不能为空");
	    }else if(newPassword == null || !newPasswordConfirm.equals(newPassword)){
	    	addFieldError("newPasswordConfirm", "前后密码不一致");
	    }
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}

	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}
}
