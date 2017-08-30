<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" type="text/css" href="./css/shopping/default_setting.css?version=4"/>
  <link rel="stylesheet" type="text/css" href="./css/shopping/shopping.css?version=2"/>
   	
<title>我的订单</title>
</head>
<body>
	<div class="center">
	<!--我的订单_(:зゝ∠)_  -->
 	<h2 align="center">我的订单</h2>
	<table class="shopping">
		<s:if test="list==null||list.isEmpty()">                                                                                        
		<tr><td><font>当前订单为空</font></td></tr>
		</s:if> 
		<s:else> 
		<s:iterator value="ordersVListInPage" status="st" var="order">
			<tr>
				<td>
					订单号：<s:property value="#order.id"/><br/>
					联系人：<s:property value="#order.address.consignmentName"/>
					&nbsp;地址：<s:property value="#order.address.address"/>
					&nbsp;邮编：<s:property value="#order.address.postCode"/>
					&nbsp;联系电话：<s:property value="#order.address.phone"/><br/>
					支付方式：<s:property value="#order.payType"/><br/>
					总计：<s:property value="#order.price"/><br/>
					下单时间：<s:property value="#order.createDate"/><br/>
					订单状态：<s:property value="#order.orderStatus"/><br/>
					<s:iterator value="#order.itemList" status="st" var="item">
						书名：<s:property value="#item.bookName"/><br/>
						数量：<s:property value="#item.quantity"/><br/>
						小计：<s:property value="#item.subtotal"/><br/>
					</s:iterator>
				</td>
				<td>	
					<s:if test='#order.orderStatus == "已下单" || #order.orderStatus == "已发货"' >                                                                                      
						<a href="ChangeOrderList?pageNo=1&doneId=${order.id}">完成订单</a>
					</s:if> 
					<s:else>
						完成订单</br>
					</s:else>
					</br>
					<s:if test='#order.orderStatus == "已下单" || #order.orderStatus == "已发货"' >                                                                                      
						<a href="ChangeOrderList?pageNo=1&undoId=${order.id}">取消订单</a>
					</s:if> 
					<s:else>
						取消订单</br>
					</s:else>
				</td>
			</tr>
			
		</s:iterator>
		</s:else>
	</table>
	<p>
	[<a href="OrderListAction?pageNo=1">首页</a>]
	<c:if test="${currentPage>1}">
		[<a href="OrderListAction?pageNo=${currentPage-1}">上一页</a>]
	</c:if>
	<c:if test="${currentPage<totalPage}">
		[<a href="OrderListAction?pageNo=${currentPage+1}">下一页</a>]
	</c:if>
	[<a href="OrderListAction?pageNo=${totalPage}">尾页</a>]
	第${currentPage}页/共${totalPage}页
	</p>
	</div>
	
	
	<center>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
	</center>
</body>
</html>