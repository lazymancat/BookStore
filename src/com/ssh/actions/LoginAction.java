package com.ssh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.CustomerDao;
import com.ssh.model.Customer;

public class LoginAction extends ActionSupport{
	private Customer customer;
	private CustomerDao cd;
	
	public LoginAction(){}
	
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		customer = cd.checkCustomerExist(customer.getRegName(), customer.getPassword());
		
		//wch
		ActionContext.getContext().getSession().put("customerId", customer.getId());
		ActionContext.getContext().getSession().put("shopping",null);
		//
		
		session.put("theCustomer",customer);
		return "success";
	}

	public void validate(){
		int flag = 1;
		if(customer.getRegName() == null || customer.getRegName().equals("")){
			flag = 0;
			addFieldError("customer.regName", "用户名不能为空");
		}else if(customer.getRegName().length() < 1 || customer.getRegName().length() > 12){
			flag = 0;
			addFieldError("customer.regName", "用户名长度不在1~12位的有效范围内");
		}else if(checkFormat(customer.getRegName()) == false){
			flag = 0;
			addFieldError("customer.regName", "用户名不能包含除字母数字以外的其他字符");
		}
		
		if(customer.getPassword() == null || customer.getPassword().equals("")){
			flag = 0;
			addFieldError("customer.password", "密码不能为空");
		}else if(customer.getPassword().length() < 6 || customer.getPassword().length() > 10){
			flag = 0;
			addFieldError("customer.password", "密码长度不在6~10位的有效范围内");
		}
		
		if(flag == 1 && cd.checkCustomerExist(customer.getRegName(), customer.getPassword()) == null){
			addFieldError("customer.regName", "用户不存在或密码错误");
		}
	}
	
	public boolean checkFormat(String str){
		for(int i = 0; i < str.length(); i++){
			if(!((str.charAt(i) >= 48 && str.charAt(i) <= 57)
					|| (str.charAt(i) >= 65 && str.charAt(i) <= 90)
					|| (str.charAt(i) >= 97 && str.charAt(i) <= 122))){
				return false;
			}
		}
		return true;
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
}
