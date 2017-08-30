<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改资料</title>
    <link rel="stylesheet" type="text/css" href="css/customer-handle.css?version=1.0.0">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
    <script>
	<!--		
		function presetValue(){			
			document.getElementById("customer.email").value = "<%=((Customer)request.getSession().getAttribute("theCustomer")).getEmail()%>";
			document.getElementById("customer.mobile").value = "<%=((Customer)request.getSession().getAttribute("theCustomer")).getMobile()%>";
			document.getElementById("customer.id").value = "<%=((Customer)request.getSession().getAttribute("theCustomer")).getId()%>";
			document.getElementById("customer.regName").value = "<%=((Customer)request.getSession().getAttribute("theCustomer")).getRegName()%>";
			document.getElementById("customer.password").value = "<%=((Customer)request.getSession().getAttribute("theCustomer")).getPassword()%>";
			document.getElementById("customer.flag").value = "<%=((Customer)request.getSession().getAttribute("theCustomer")).getFlag()%>";
		}
		window.onpageshow = presetValue;
	-->
	</script>
  </head>
 
  <body>
  	<center>
  		<div id="revisedatapanel">
	  		<h2>修改资料</h2><br>
	  		<s:form method="post" action="reviseData">
	  			<s:textfield name="customer.email" id="customer.email" label="邮箱" onfocus="this.value=''"/>
	  			<s:textfield name="customer.mobile" id="customer.mobile" label="手机" onfocus="this.value=''"/>
	  			<s:hidden name="customer.id" id="customer.id"/>
	  			<s:hidden name="customer.regName" id="customer.regName"/>
	  			<s:hidden name="customer.password" id="customer.password"/>
	  			<s:hidden name="customer.flag" id="customer.flag"/>
	  			<s:submit value="提交"/>
	  		</s:form>
	  		<br>
  		</div>
  		
	  	<br><br><br>
		<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
  	</center>
  </body>
</html>
