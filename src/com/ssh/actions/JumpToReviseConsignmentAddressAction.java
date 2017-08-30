package com.ssh.actions;

import com.opensymphony.xwork2.ActionContext;
import com.ssh.dao.ConsignmentAddressDao;
import com.ssh.model.ConsignmentAddress;

public class JumpToReviseConsignmentAddressAction {
	private String locationHref;
	private int consignmentAddressId;
	private ConsignmentAddressDao cad;
	
	public JumpToReviseConsignmentAddressAction(){}
	
	public String execute(){
		ActionContext.getContext().getSession().put("preLocation", locationHref);
		ActionContext.getContext().getSession().put("theConsignmentAddress", cad.getConsignmentAddressById(consignmentAddressId));
		
		return "success";
	}

	public String getLocationHref() {
		return locationHref;
	}

	public void setLocationHref(String locationHref) {
		this.locationHref = locationHref;
	}

	public int getConsignmentAddressId() {
		return consignmentAddressId;
	}

	public void setConsignmentAddressId(int consignmentAddressId) {
		this.consignmentAddressId = consignmentAddressId;
	}

	public ConsignmentAddressDao getCad() {
		return cad;
	}

	public void setCad(ConsignmentAddressDao cad) {
		this.cad = cad;
	}
}
