package com.ssh.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookTypeDao;
import com.ssh.model.BookType;

public class GetAllBookTypeAction extends ActionSupport{
	BookTypeDao btd;
	List<BookType> bookTypes;
	int number=0;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BookTypeDao getBtd() {
		return btd;
	}
	public void setBtd(BookTypeDao btd) {
		this.btd = btd;
	}
	public List<BookType> getBookTypes() {
		return bookTypes;
	}
	public void setBookTypes(List<BookType> bookTypes) {
		this.bookTypes = bookTypes;
	}
	
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取所有用户的信息
		System.out.println("这是GetAllBookTypeAction的excute");
		
		bookTypes = btd.getAllBookType();
		request.setAttribute("bookTypes", bookTypes);
		
		System.out.println("BookTypeId:"+bookTypes.get(0).getTypeId());
		System.out.println("BookTypeName:"+bookTypes.get(0).getTypeName());
		
		if(number==1)
			return SUCCESS;
		else
			return INPUT;
	}
}
