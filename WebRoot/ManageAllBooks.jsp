<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/br.js" charset="UTF-8"></script>
    
    <title>图书管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>图书管理</h1>
  
	<s:action name="manageAllBook" executeResult="false"></s:action>
  	<table border="1" width="60%"  border="0" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;">
		<tr>
			<th>图书图片</th>
			<th>图书名称</th>
			<th>图书作者</th>
			<th>图书价格</th>
			<th>图书出版社</th>
			<th>操作</th>
		</tr>
		<s:iterator value="#request.manageBooks">
			<tr align="center" >
				<td><img src="img/books/<s:property value="image"/>" style="height:120px; width:120px;"></td>
				<td><s:property value="name"/></td>
				<td><s:property value="author"/></td>
				<td><s:property value="price"/></td>
				<td><s:property value="publisher"/></td>
				<td style="width:100px;"><a href="javascript:reviseBook('<s:property value="id"/>')"><button value="修改">修改</button></a>
				<a href="javascript:deleteBook('<s:property value="id"/>')"><button value="删除">删除</button></a></td>
			</tr>
		</s:iterator>
	</table>
	
	[<a href="manageAllBook?pageNo=1">首页</a>]
	<c:if test="${currentPage>1}">
		[<a href="manageAllBook?pageNo=${currentPage-1}">上一页</a>]
	</c:if>
	<c:if test="${currentPage<totalPage}">
		[<a href="manageAllBook?pageNo=${currentPage+1}">下一页</a>]
	</c:if>
	[<a href="manageAllBook?pageNo=${totalPage}">尾页</a>]
	第${currentPage}页/共${totalPage}页
  </body>
</html>
