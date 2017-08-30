package com.ssh.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class NewProductAction extends ActionSupport{
	BookDao bd;
	List<Book> manageBooks;
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public List<Book> getManageBooks() {
		return manageBooks;
	}
	public void setManageBooks(List<Book> manageBooks) {
		this.manageBooks = manageBooks;
	}
	
	public String execute() throws Exception{
		//数据库获取最新的书籍
		HttpServletRequest request = ServletActionContext.getRequest();
		
		manageBooks = bd.getNewProduct();
		request.setAttribute("manageBooks", manageBooks);
		return SUCCESS;
	}
}
