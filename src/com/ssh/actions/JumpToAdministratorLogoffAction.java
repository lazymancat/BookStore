package com.ssh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class JumpToAdministratorLogoffAction {
	
	public JumpToAdministratorLogoffAction(){}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		session.remove("theAdministrator");
		return "success";
	}
}
