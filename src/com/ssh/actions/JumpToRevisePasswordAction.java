package com.ssh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class JumpToRevisePasswordAction {
	private String locationHref;
	
	public JumpToRevisePasswordAction(){}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		session.put("preLocation", locationHref);
		return "success";
	}

	public String getLocationHref() {
		return locationHref;
	}

	public void setLocationHref(String locationHref) {
		this.locationHref = locationHref;
	}
}
