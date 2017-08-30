<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户资料</title>
    <link rel="stylesheet" type="text/css" href="css/customer-manage.css?version=1.0.1">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
    <script>
	<!--		
		function getInfo(){
			var info = "<%=(String)ActionContext.getContext().getSession().get("info")%>";
			
			if(info != "null"){
				alert(info);
			}
			<%ActionContext.getContext().getSession().put("info", null);%>
		}
		
		function presetValue(){			
			document.getElementById("customer.email").value = "<%=((Customer)request.getSession().getAttribute("manage_theCustomer")).getEmail()%>";
			document.getElementById("customer.mobile").value = "<%=((Customer)request.getSession().getAttribute("manage_theCustomer")).getMobile()%>";
			document.getElementById("customer.id").value = "<%=((Customer)request.getSession().getAttribute("manage_theCustomer")).getId()%>";
			document.getElementById("customer.regName").value = "<%=((Customer)request.getSession().getAttribute("manage_theCustomer")).getRegName()%>";
			document.getElementById("customer.password").value = "<%=((Customer)request.getSession().getAttribute("manage_theCustomer")).getPassword()%>";
			document.getElementById("customer.flag").value = "<%=((Customer)request.getSession().getAttribute("manage_theCustomer")).getFlag()%>";
		
			getInfo();
		}
		window.onpageshow = presetValue;
	-->
	</script>
  </head>
 
  <body>
  	<center>
	  	<div id="reviseCuspanel">
	  		<br>
	  		<h2>修改用户资料</h2>
	  		<br>
	  		<s:form method="post" action="reviseCustomer">
	  			<s:textfield name="customer.regName" id="customer.regName" label="用户名" onfocus="this.value=''"/>
	  			<s:textfield name="customer.password" id="customer.password" label="密码" onfocus="this.value=''"/>
	  			<s:textfield name="customer.email" id="customer.email" label="邮箱" onfocus="this.value=''"/>
	  			<s:textfield name="customer.mobile" id="customer.mobile" label="手机" onfocus="this.value=''"/>
	  			<s:hidden name="customer.id" id="customer.id"/>
	  			<s:hidden name="customer.flag" id="customer.flag"/>
	  			<s:submit value="提交"/>
	  		</s:form>
	  		<br>
	  	</div>
	  	<br><br><br>
		<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
		<br>
		<a class="btn-back" href="management_Main.jsp">返回首页</a>
  	</center>
  </body>
</html>
