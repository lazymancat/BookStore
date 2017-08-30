package com.ssh.model;

public class OrderItemsV {
	private int id;
	private int ordId;
	private int bookId;
	private String bookName;
	private int quantity;//购买数量
	private float subtotal;//小计价格
	public void setAll(OrderItems o, String bookName){
		this.id = o.getId();
		this.ordId = o.getOrdId();
		this.bookId = o.getBookId();
		this.bookName = bookName;
		this.quantity = o.getQuantity();//购买数量
		this.subtotal = o.getSubtotal();//小计价格
	}
	//重写比较函数
	public boolean equals(Object obj) {
        if (obj instanceof OrderItemsV) {
        	OrderItemsV tmp = (OrderItemsV) obj;
            if(this.getBookId() == tmp.getBookId())
            	return true;
        }
        return false;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
}
