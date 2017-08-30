package com.ssh.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.dao.OrderItemVDao;
import com.ssh.model.Book;
import com.ssh.model.OrderItemV;

public class AddShoppingAction extends ActionSupport { 
	private List<OrderItemV> shopping;
	private int bookId;
	private int cid;
	private int quantity;
	private OrderItemVDao oivd;

	public void output(String str){
		if(shopping == null)return ;
		System.out.println("----------------------------------------");
		System.out.println(str);
		System.out.println("shopping.size=:"+shopping.size());
		for(Iterator it = shopping.iterator();it.hasNext();){
			OrderItemV tmp = (OrderItemV)it.next();
			System.out.println("bookId:"+ tmp.getBookid());
			System.out.println("bookName:"+tmp.getName());
			System.out.println("Quantity:"+tmp.getQuantity());
		}
		System.out.println("----------------------------------------");
	}
	
	public String execute(){
		Map session=ActionContext.getContext().getSession();
		shopping = (List)session.get("shopping");
		Object cidObj = (Object)session.get("customerId");
		if(cidObj == null)//防返回null错误
			return INPUT;
		int cidTmp = Integer.valueOf(cidObj.toString());//customerIdTmp
		if(cidTmp == 0) //防返回null错误--后台验证，用户没登录
			return INPUT;
		System.out.println("----------------------------------------");
		System.out.println("bookId="+bookId);
		System.out.println("cidTmp="+cidTmp);
		System.out.println("quantity="+quantity);
		System.out.println("cid="+cid);
		System.out.println("----------------------------------------");
		
		if(cid == 0){
			cid = cidTmp;
		}
		if(cidTmp == 0){
			System.out.println("INTPUT");
			return INPUT;
		}
		if(shopping == null){
			shopping = new ArrayList<OrderItemV>();
		}else if(shopping.size()!=0 && cid != cidTmp){
			cid = cidTmp;
			shopping.clear();
			shopping = new ArrayList<OrderItemV>();
		}
		
		OrderItemV tmp = oivd.getBookByBookId(bookId);
		if(tmp == null)
			return INPUT;
		int index = shopping.indexOf(tmp);
		output("增加前");
		if(index == -1){
			tmp.setQuantity(quantity);
			shopping.add(tmp);
		}else{
			tmp.setQuantity(((OrderItemV)shopping.get(index)).getQuantity() + quantity);
			shopping.set(index, tmp);
		}
		output("增加后");
		session.put("shopping", shopping);

		return SUCCESS;
	}

	public List<OrderItemV> getShopping() {
		return shopping;
	}

	public void setShopping(List<OrderItemV> shopping) {
		this.shopping = shopping;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderItemVDao getOivd() {
		return oivd;
	}

	public void setOivd(OrderItemVDao oivd) {
		this.oivd = oivd;
	}
}
