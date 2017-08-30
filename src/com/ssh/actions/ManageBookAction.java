package com.ssh.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class ManageBookAction extends ActionSupport{
	String bookName;//获取搜索的书籍名称
	BookDao bd;//书籍数据库
	List<Book> manageBooks;//保存书籍列表
	
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
	public List<Book> getManageBooks() {
		return manageBooks;
	}
	public void setManageBooks(List<Book> manageBooks) {
		this.manageBooks = manageBooks;
	}
	
	//获取书籍列表和获取搜索栏内容
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(bookName!=null){
			bookName = new String(bookName.getBytes("iso-8859-1"),"UTF-8");
			System.out.println("-----------bookName：------------"+bookName);
			manageBooks = bd.SerachBook(bookName);
			if(manageBooks.size()<1){
				JOptionPane.showMessageDialog(null, "你搜索的书籍不存在！", "搜索失败", JOptionPane.ERROR_MESSAGE);
				return LOGIN;
			}
			else{
				//根基数据量和每页显示的数据条数来计算总页数
				if(manageBooks.size()%pageSize==0){
					totalPage=manageBooks.size()/pageSize;
				}else{
					totalPage=manageBooks.size()/pageSize+1;
				}
				if(pageNo<=0){
					pageNo=1;
				}else if(pageNo>totalPage){
					pageNo=totalPage;
				}

				//根据当前页查询要在该页上显示的数据
				manageBooks=bd.manageBookByPage(pageNo,pageSize,bookName);
				currentPage=pageNo;
			}
		}else{
			manageBooks = bd.getAllBook();
			
			//根基数据量和每页显示的数据条数来计算总页数
			if(manageBooks.size()%pageSize==0){
				totalPage=manageBooks.size()/pageSize;
			}else{
				totalPage=manageBooks.size()/pageSize+1;
			}
			if(pageNo<=0){
				pageNo=1;
			}else if(pageNo>totalPage){
				pageNo=totalPage;
			}

			//根据当前页查询要在该页上显示的数据
			manageBooks=bd.manageByPage(pageNo,pageSize);
			currentPage=pageNo;
		}
		request.setAttribute("manageBooks", manageBooks);
		return SUCCESS;
		
	}

}
