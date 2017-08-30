package com.ssh.actions;

import java.util.List;

import com.ssh.dao.CustomerDao;
import com.ssh.model.Customer;

public class JumpToManageCustomerAction {
	private CustomerDao cd;
	private List<Customer> cusList;
	private String nameKeyWord = null;
	
	public JumpToManageCustomerAction(){}

	public String execute(){
		cusList = cd.getCustomerListByNameKeyWord(nameKeyWord);
		return "success";
	}
	
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public List<Customer> getCusList() {
		return cusList;
	}

	public void setCusList(List<Customer> cusList) {
		this.cusList = cusList;
	}

	public String getNameKeyWord() {
		return nameKeyWord;
	}

	public void setNameKeyWord(String nameKeyWord) {
		this.nameKeyWord = nameKeyWord;
	}
	
	
}
