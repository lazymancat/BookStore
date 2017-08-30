package com.ssh.actions;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.CustomerDao;
import com.ssh.model.Customer;

public class JumpToReviseCustomerAction {
	private String locationHref;
	private int cusId;
	private Customer customer;
	private CustomerDao cd;
	
	public JumpToReviseCustomerAction(){}

	public String execute(){
		customer = cd.getCustomerById(cusId);
		ActionContext.getContext().getSession().put("manage_theCustomer", customer);
		ActionContext.getContext().getSession().put("preLocation", locationHref);
		return "success";
	}
	
	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
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

	public String getLocationHref() {
		return locationHref;
	}

	public void setLocationHref(String locationHref) {
		this.locationHref = locationHref;
	}
	
	
}
