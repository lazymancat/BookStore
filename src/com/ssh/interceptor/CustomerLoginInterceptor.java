package com.ssh.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ssh.model.Customer;

public class CustomerLoginInterceptor extends AbstractInterceptor{
	@Override //重写父类的intercept方法
	public String intercept(ActionInvocation ai) throws Exception {
		Customer cus = (Customer)ActionContext.getContext().getSession().get("theCustomer");
		if(cus != null){ //已经成功登录

			return ai.invoke();
		}else{//还没登录
			
			return "unlogin";
		}
	}
}
