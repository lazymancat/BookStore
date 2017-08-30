package com.ssh.actions;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class JumpToAddConsignmentAddressAction {
	private String locationHref;
	
	public JumpToAddConsignmentAddressAction(){}

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
