<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" type="text/css" href="./css/shopping/default_setting.css?version=3"/>
  <link rel="stylesheet" type="text/css" href="./css/shopping/shopping.css?version=2"/>
<title>订单统计</title>
</head>
<body>
	<div class="center">
		<form method="post" action="BookStatisticsAction">
				格式为（从2016-01-10）从<input type="text" name="sdate" />
				到（不包含）<input type="text" name="edate" />
				<input type="submit" value="提交订单"/>
		</form>
		<table class="shopping">
			<th>书名</th>
			<th><a href="BookStatisticsAction?pageNo=1&oper=1">销量</a></th>
			<th><a href="BookStatisticsAction?pageNo=1&oper=2">销售总计</a></th>
			<s:if test="list==null||list.isEmpty()">                                                                                        
			<tr><td colspan="3"><font>当前订单为空 <s:property value="err"/></font></td></tr>
			</s:if> 
			<s:else>
				<s:iterator value="orderItemsVListInPage" status="st" var="item">
					<tr>
						<td>	
							<s:property value="#item.bookName"/><br/>
						</td>
						<td>
							<s:property value="#item.quantity"/><br/>
						</td>
						<td>
							<s:property value="#item.subtotal"/><br/>
						</td>
					</tr>
				</s:iterator>
			 </s:else>
		</table>
		<p>
		[<a href="BookStatisticsAction?pageNo=1">首页</a>]
		<c:if test="${currentPage>1}">
			[<a href="BookStatisticsAction?pageNo=${currentPage-1}">上一页</a>]
		</c:if>
		<c:if test="${currentPage<totalPage}">
			[<a href="BookStatisticsAction?pageNo=${currentPage+1}">下一页</a>]
		</c:if>
		[<a href="BookStatisticsAction?pageNo=${totalPage}">尾页</a>]
		第${currentPage}页/共${totalPage}页
		</p>
	</div>
	
	<center>
		<br>
			<a class="btn-back" href="management_Main.jsp">返回首页</a>
	</center>
</body>
</html>