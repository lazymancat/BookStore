package com.ssh.actions;

import java.util.List;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class HomePageSearchAction extends ActionSupport{
	String bookName;//获取搜索的书籍名称
	BookDao bd;//书籍数据库
	List<Book> searchBooks;//保存书籍列表

	private final int pageSize=5; //每页显示记录的个数
	private int pageNo=1; //计数器,从第1页开始
	private int currentPage; //当前页
	private int totalPage; //总页数
	
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
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	public List<Book> getSearchBooks() {
		return searchBooks;
	}
	public void setSearchBooks(List<Book> searchBooks) {
		this.searchBooks = searchBooks;
	}
	
	public String execute()throws Exception{
		bookName = new String(bookName.getBytes("iso-8859-1"),"UTF-8");
		System.out.println("-----------bookName：------------"+bookName);
		searchBooks = bd.SerachBook(bookName);
		if(searchBooks.size()<1){
			JOptionPane.showMessageDialog(null, "你搜索的商品我们没有！", "搜索失败", JOptionPane.ERROR_MESSAGE);
			return INPUT;
		}
		else{
			//根基数据量和每页显示的数据条数来计算总页数
			if(searchBooks.size()%pageSize==0){
				totalPage=searchBooks.size()/pageSize;
			}else{
				totalPage=searchBooks.size()/pageSize+1;
			}
			if(pageNo<=0){
				pageNo=1;
			}else if(pageNo>totalPage){
				pageNo=totalPage;
			}

			//根据当前页查询要在该页上显示的数据
			searchBooks=bd.manageBookByPage(pageNo,pageSize,bookName);
			currentPage=pageNo;
		}
		return SUCCESS;
	}
}
