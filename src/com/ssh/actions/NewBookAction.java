package com.ssh.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class NewBookAction extends ActionSupport{
	BookDao bd;
	List<Book> books;
	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始
	private int currentPage; //当前页
	private int totalPage; //总页数
	private int bookType;


	public int getBookType() {
		return bookType;
	}

	public void setBookType(int bookType) {
		this.bookType = bookType;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public BookDao getBd() {
		return bd;
	}

	public void setBd(BookDao bd) {
		this.bd = bd;
	}

	
	public String execute() throws Exception{
		//获取所有用户的信息
		System.out.println("这是excute");
		System.out.println(bookType);
		books = bd.getNewBooks(bookType);
		
		if(books.size()<=0)
			return INPUT;

		//根基数据量和每页显示的数据条数来计算总页数
		if(books.size()%pageSize==0){
			totalPage=books.size()/pageSize;
		}else{
			totalPage=books.size()/pageSize+1;
		}
		if(pageNo<=0){
			pageNo=totalPage;
		}else if(pageNo>totalPage){
			pageNo=1;
		}

		//根据当前页查询要在该页上显示的数据
		books=bd.queryByPage(pageNo,pageSize,bookType);
		currentPage=pageNo;
		
		System.out.println("当前页："+currentPage);
		System.out.println("总页数："+totalPage);
		
		System.out.println(books.get(0).getImage());
		return SUCCESS;
	}
	
	
}
