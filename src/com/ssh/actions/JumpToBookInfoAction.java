package com.ssh.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.BookCommentDao;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;
import com.ssh.model.BookComment;

public class JumpToBookInfoAction {
	private int bookId;
	private Book book;
	private List<BookComment> bookCommentList;
	private BookDao bd;
	private BookCommentDao bcd;
	private final int pageSize=3;
	private int pageNo=1;
	private int currentPage;
	private int totalPage;

	public JumpToBookInfoAction(){}
	
	public String execute(){
		if(bookId == 0){
			return "error";
		}
		
		Map session = ActionContext.getContext().getSession();
		
		book = bd.getBookByBookId(bookId);
		if(book.equals(null)){
			return "input";
		}
		
		bookCommentList = bcd.getAllBookCommentByBookId(bookId);
		if(bookCommentList.size() % pageSize == 0){
			totalPage = bookCommentList.size() / pageSize;
		}else{
			totalPage = bookCommentList.size() / pageSize + 1;
		}
		if(pageNo <= 0){
			pageNo = 1;
		}else if(pageNo > totalPage){
			pageNo = totalPage;
		}
		
		currentPage=pageNo;
		bookCommentList = bcd.getBookCommentByBookIdAndPageNo(bookId, pageNo, pageSize);
		session.put("theBook", book);

		return "success";
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<BookComment> getBookCommentList() {
		return bookCommentList;
	}

	public void setBookCommentList(List<BookComment> bookCommentList) {
		this.bookCommentList = bookCommentList;
	}

	public BookCommentDao getBcd() {
		return bcd;
	}

	public void setBcd(BookCommentDao bcd) {
		this.bcd = bcd;
	}

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
}
