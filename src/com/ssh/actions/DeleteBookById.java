package com.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class DeleteBookById extends ActionSupport{
	int id;
	BookDao bd;
	Book book;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String execute(){
		System.out.println("这里是要删除的book的ID:"+id);
		if(bd.deleteBookById(id)){
			return LOGIN;
		}else{
			return INPUT;
		}
	}

}
