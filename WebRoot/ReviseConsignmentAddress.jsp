<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.ConsignmentAddress"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改收货地址</title>
    <link rel="stylesheet" type="text/css" href="css/customer-handle.css?version=1.0.1">
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
			document.getElementById("consignmentAddress.consignmentName").value = "<%=((ConsignmentAddress)request.getSession().getAttribute("theConsignmentAddress")).getConsignmentName()%>";
			document.getElementById("consignmentAddress.address").value = "<%=((ConsignmentAddress)request.getSession().getAttribute("theConsignmentAddress")).getAddress()%>";
			document.getElementById("consignmentAddress.postCode").value = "<%=((ConsignmentAddress)request.getSession().getAttribute("theConsignmentAddress")).getPostCode()%>";
			document.getElementById("consignmentAddress.phone").value = "<%=((ConsignmentAddress)request.getSession().getAttribute("theConsignmentAddress")).getPhone()%>";
			document.getElementById("consignmentAddress.id").value = "<%=((ConsignmentAddress)request.getSession().getAttribute("theConsignmentAddress")).getId()%>";
			document.getElementById("consignmentAddress.flag").value = "<%=((ConsignmentAddress)request.getSession().getAttribute("theConsignmentAddress")).getFlag()%>";
		
			getInfo();
		}
		window.onpageshow = presetValue;
	-->
	</script>
  </head>
 
  <body>
  	<center>
  		<div id="reviseCApanel">
	  		<br><h2>修改资料</h2>
	  		<br>
	  		<s:form method="post" action="reviseConsignmentAddress">
	  			<s:textfield name="consignmentAddress.consignmentName" id="consignmentAddress.consignmentName" label="收货人" onfocus="this.value=''"/>
	  			<s:textfield name="consignmentAddress.address" id="consignmentAddress.address" label="地址" onfocus="this.value=''"/>
	  			<s:textfield name="consignmentAddress.postCode" id="consignmentAddress.postCode" label="邮编" onfocus="this.value=''"/>
	  			<s:textfield name="consignmentAddress.phone" id="consignmentAddress.phone" label="联系电话" onfocus="this.value=''"/>
	  			<s:hidden name="consignmentAddress.id" id="consignmentAddress.id" />
	  			<s:hidden name="consignmentAddress.flag" id="consignmentAddress.flag" />
	  			<s:submit value="提交"/>
	  		</s:form>
	  		<br><br>
	  	</div>
	  	<br><br><br>
		<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
  	</center>
  </body>
</html>
