<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>图书管理</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>  
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <!-- Bootstrap -->
	<link rel="stylesheet" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"/> 
	<!-- 导入自己的css -->
	<link rel="stylesheet" type="text/css" href="css/bm-style.css?version=1.0.0">
	<!-- 导入自己的js -->
	<script type="text/javascript" src="js/bm.js?version=1.0.0" charset="UTF-8"></script> 
  </head>
  
  <body>
  <!-- 整体轮廓 -->
	<div class="bookManagement">
		<!-- 退出图片 -->
		<div class="bookManagement_backImg" title="退出">
			<a href="management_Main.jsp"><img style="height:86px; width:78px" src="img/manage/backToManagement.png"></a>
		</div>
		<!-- 顶部图片 -->
		<div class="bookManagement_headImg">
			<img style="height:128px; width:128px" src="img/manage/bookManagement.png">
		</div>
		<!-- 添加新书图片 -->
		<a href="AddNewBook.jsp"> 
			<div class="bookManagement_addNewBookImg">
				<img style="height:108px; width:108px" src="img/manage/addNewBook.png">
				<span>添加新书</span>
			</div>
		</a>
		<!-- 顶部标题 -->
		<div class="bookManagement_headTitle">
			<strong>书&nbsp籍&nbsp管&nbsp理</strong>
		</div>
		<!-- 顶部搜索 -->
		<s:form method="get" action="manageBook">
			<div class="bookManagement_headSerach">
				<input type="text" name="bookName" placeholder="请输入你要查找的书籍名称">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
			</div>
		</s:form>
			<!-- 数据库遍历书籍 -->
			<s:action name="manageBook" executeResult="false"></s:action>
			<!-- 书籍列表 -->
			<div class="bookManagement_bookList">
				<table class="table table-striped">
					<thead>
						<tr>	
							<th>图书图片</th>
							<th>图书名称</th>
							<th>图书作者</th>
							<th>图书价格</th>
							<th>图书出版社</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#request.manageBooks">
					        <tr>
						        <td><img src="img/books/<s:property value="image"/>" style="height:120px; width:120px;"></td>
								<td><s:property value="name"/></td>
								<td><s:property value="author"/></td>
								<td><s:property value="price"/></td>
								<td><s:property value="publisher"/></td>
								<td>
									<a href="queryBook?bookId=<s:property value="id"/>"><button value="修改">修改</button></a>
									<a href="javascript:deleteBook('<s:property value="id"/>')"><button value="删除">删除</button></a>
								</td>
					        </tr>
						</s:iterator>
		      		</tbody>
				</table>
				
				[<a href="manageBook?pageNo=1&bookName=${bookName}">首页</a>]
				<c:if test="${currentPage>1}">
					[<a href="manageBook?pageNo=${currentPage-1}&bookName=${bookName}">上一页</a>]
				</c:if>
				<c:if test="${currentPage<totalPage}">
					[<a href="manageBook?pageNo=${currentPage+1}&bookName=${bookName}">下一页</a>]
				</c:if>
				[<a href="manageBook?pageNo=${totalPage}&bookName=${bookName}">尾页</a>]
				第${currentPage}页/共${totalPage}页
			</div>
	</div>
  </body>
</html>
