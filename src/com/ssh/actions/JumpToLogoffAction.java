package com.ssh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class JumpToLogoffAction {
	private String locationHref;
	
	public JumpToLogoffAction(){}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		session.remove("theCustomer");
		session.put("preLocation", locationHref);
		//wch
		session.put("customerId", locationHref);
		return "success";
	}
	
	public String getLocationHref() {
		return locationHref;
	}

	public void setLocationHref(String locationHref) {
		this.locationHref = locationHref;
	}
}
