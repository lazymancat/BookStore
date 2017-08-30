package com.ssh.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.ConsignmentAddressDao;
import com.ssh.model.ConsignmentAddress;
import com.ssh.model.Customer;

public class JumpToManageConsignmentAddressAction {
	private String locationHref = null;
	private List<ConsignmentAddress> caList;
	private final int quantityLimit = 5;
	private int quantity;
	private ConsignmentAddressDao cad;
	
	public JumpToManageConsignmentAddressAction(){}
	
	public String execute(){
		if(locationHref != null){
			ActionContext.getContext().getSession().put("preLocation", locationHref);
		}else{
			locationHref = "http://localhost:8080/BookStore/HomePage.jsp";
			ActionContext.getContext().getSession().put("preLocation", locationHref);
		}
		caList = cad.getAllConsignmentAddressByCusId(((Customer)ActionContext.getContext().getSession().get("theCustomer")).getId());
		quantity = caList==null?0:caList.size();
		return "success";
	}

	public String getLocationHref() {
		return locationHref;
	}

	public void setLocationHref(String locationHref) {
		this.locationHref = locationHref;
	}

	public List<ConsignmentAddress> getCaList() {
		return caList;
	}

	public void setCaList(List<ConsignmentAddress> caList) {
		this.caList = caList;
	}

	public ConsignmentAddressDao getCad() {
		return cad;
	}

	public void setCad(ConsignmentAddressDao cad) {
		this.cad = cad;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantityLimit() {
		return quantityLimit;
	}
	
	
}
