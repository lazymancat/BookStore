package com.ssh.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.AdministratorDao;
import com.ssh.model.Administrator;

public class AdministratorLoginAction extends ActionSupport{
	private Administrator ad;
	private AdministratorDao add;
	
	public AdministratorLoginAction(){}

	public String execute(){
		ad = add.checkAdminExist(ad);
		Map session = ActionContext.getContext().getSession();
		session.put("theAdministrator", ad);
		return "success";
	}
	
	public void validate(){
		int flag = 1;
		if(ad.getName() == null || ad.getName().equals("")){
			flag = 0;
			addFieldError("ad.name", "用户名不能为空");
		}
		
		if(ad.getPassword() == null || ad.getPassword().equals("")){
			flag = 0;
			addFieldError("ad.password", "密码不能为空");
		}
		
		if(flag == 1 && add.checkAdminExist(ad) == null){
			addFieldError("ad.name", "账号不存在或密码错误");
		}
	}
	
	public Administrator getAd() {
		return ad;
	}

	public void setAd(Administrator ad) {
		this.ad = ad;
	}

	public AdministratorDao getAdd() {
		return add;
	}

	public void setAdd(AdministratorDao add) {
		this.add = add;
	}
	
}
