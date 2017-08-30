<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>购物车</title>
  <base href="<%=basePath%>">
<%--   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="text/javascript" src="js/jsAddress.js"></script>  --%>
  <link rel="stylesheet" type="text/css" href="./css/shopping/default_setting.css?version=4"/>
  <link rel="stylesheet" type="text/css" href="./css/shopping/shopping.css?version=2"/>
  <script type="text/javascript" src="js/jump.js"></script>
</head>
  
<body >
	<div class="center">
	<!--购物车_(:зゝ∠)_  -->
 	<h2 align="center">购物车</h2>
	<table class="shopping">
		<th>书名</th><th>数量</th><th>操作</th>
		<%--直接判断总集合因为后台总集合为空直接return --%>
		<s:if test="shopping==null||shopping.isEmpty()">                                                                                        
		<tr><td colspan="3"><font>当前购物车为空</font></td></tr>
		</s:if>
		<s:else>
		<s:iterator value="bookListInPage" status="st" var="book">
			<tr>
				<td><s:property value="#book.name"/></td>
				<td><s:property value="#book.quantity"/></td>
				<td>
					<a href="ChangeShoppingAction?subID=${book.bookid}">减少一本</a>
					<br/>
					<a href="ChangeShoppingAction?addID=${book.bookid}">增加一本</a>
				</td>
			</tr>
		</s:iterator>
		</s:else>
	</table>
	<table>
	<s:if test="orderERR!=null"> 
		<s:iterator value="orderERR" status="st" var="ERR">
			<tr><td>
				<font class='ERR'><s:property value="#ERR"/></font>
			</td></tr>
		</s:iterator>
	</s:if>
	</table>
	<p>
	[<a href="ShowShoppingAction?pageNo=1">首页</a>]
	<c:if test="${currentPage>1}">
		[<a href="ShowShoppingAction?pageNo=${currentPage-1}">上一页</a>]
	</c:if>
	<c:if test="${currentPage<totalPage}">
		[<a href="ShowShoppingAction?pageNo=${currentPage+1}">下一页</a>]
	</c:if>
	[<a href="ShowShoppingAction?pageNo=${totalPage}">尾页</a>]
	第${currentPage}页/共${totalPage}页
	</p>
	<%--找不到action可能是表单和action类的数据类型不一致 --%>
	<s:form method="post" action="OrderAction">
		<!--默认地址_(:зゝ∠)_  -->
		<s:if test="addressList==null||addressList.isEmpty()">                                                                                        
			<font>无收货地址，</font>
			<a href="javascript:jumpToManageConsignmentAddress()">去添加收货地址</a>
		</s:if> 
		<s:else>
			<s:iterator value="addressList" status="st" var="address">
				<p>
					<input name="addressId" type="radio" value="<s:property value="#address.id"/>"
						<s:if test="#st.First">checked="checked"</s:if>/>
					&nbsp;联系人：<s:property value="#address.consignmentName"/>
					&nbsp;地址：<s:property value="#address.address"/>
					&nbsp;邮编：<s:property value="#address.postCode"/>
					&nbsp;联系电话：<s:property value="#address.phone"/>
				</p>
			</s:iterator>
			<s:submit value="提交订单"/>
			
		</s:else>
	</s:form>

	<center>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
	</center>

	<!--自定义地址_(:зゝ∠)_  -->
	<%-- <s:form method="post" action="orderAction">
	    <select id="cmbProvince" name="province"></select>  
		<select id="cmbCity" name="city"></select>  
		<select id="cmbArea" name="area"></select>
		<br/>
		<font>详细地址：</font><input type="text" name="address"/>
		<s:submit value="登录"/>
	</s:form>
	<script type="text/javascript">  
	     addressInit('cmbProvince', 'cmbCity', 'cmbArea');  
	</script>   --%>
	 </div>
</body>
</html>
