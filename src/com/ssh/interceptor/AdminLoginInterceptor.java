package com.ssh.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ssh.model.Administrator;
import com.ssh.model.Customer;

public class AdminLoginInterceptor extends AbstractInterceptor {
	@Override //重写父类的intercept方法
	public String intercept(ActionInvocation ai) throws Exception {
		Administrator admin = (Administrator)ActionContext.getContext().getSession().get("theAdministrator");
		if(admin != null){ //已经成功登录

			return ai.invoke();
		}else{//还没登录
			
			return "unlogin";
		}
	}
}
