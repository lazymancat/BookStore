package com.ssh.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class CheapBookAction extends ActionSupport{
	BookDao bd;
	List<Book> cheapBooks;
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public List<Book> getCheapBooks() {
		return cheapBooks;
	}
	public void setCheapBooks(List<Book> cheapBooks) {
		this.cheapBooks = cheapBooks;
	}
	
	public String execute() throws Exception{

		HttpServletRequest request = ServletActionContext.getRequest();
		//执行按价格排序
		cheapBooks = bd.cheapBook();
		request.setAttribute("cheapBooks", cheapBooks);
		return SUCCESS;
		
	}
	
}
