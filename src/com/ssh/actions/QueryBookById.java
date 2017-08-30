package com.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class QueryBookById extends ActionSupport{
	int bookId;
	BookDao bd;
	Book book;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
		book = bd.queryBookById(bookId);
		System.out.println("bookId:"+bookId);
		System.out.println("bookPrice:"+book.getPrice());
		System.out.println("booktype:"+book.getTypeId());
		if(book!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
