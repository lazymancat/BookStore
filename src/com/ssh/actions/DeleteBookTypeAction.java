package com.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookTypeDao;

public class DeleteBookTypeAction extends ActionSupport{
	BookTypeDao btd;
	int typeId;
	public BookTypeDao getBtd() {
		return btd;
	}
	public void setBtd(BookTypeDao btd) {
		this.btd = btd;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String execute() throws Exception{
		System.out.println("’‚ «typeId:"+typeId);
		boolean flag = btd.deleteBookType(typeId);
		System.out.println("Flag:"+flag);
		if(flag==true)
			return SUCCESS;
		else
			return INPUT;
	}
}
