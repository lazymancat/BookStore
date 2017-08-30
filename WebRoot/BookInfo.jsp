<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Book"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	Book book = (Book)request.getSession().getAttribute("theBook");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  	
    <title><%=book.getName() %></title>
    <link rel="stylesheet" type="text/css" href="css/bookinfopage.css?version=1.0.0">
    <script type="text/javascript" src="js/dropdownmenu.js?version=1.0.1"></script>
    <script type="text/javascript" src="js/numbercontrol.js?version=1.0.2"></script>
    <script type="text/javascript" src="js/jump.js?version=1.0.4"></script>
  </head>
  
  <body>
  	<div>
	  	<div id="topbar">
	  		<c:if test="${session.theCustomer != null}">
		  		<ul id="topbar-ddm">
					<li><a href="javascript:jumpToSelf()" onmouseover="menuOpen('menu')" onmouseout="menuClose()"><%=((Customer)session.getAttribute("theCustomer")).getRegName()%></a>
						<div id="menu" onmouseover="menuOpen('menu')" onmouseout="menuClose()">
							<a href="OrderListAction?pageNo=1">我的订单</a>
							<a href="javascript:jumpToRevisePassword()">修改密码</a>
							<a href="javascript:jumpToReviseData()">修改资料</a>
							<a href="javascript:jumpToManageConsignmentAddress()">管理收货地址</a>
							<a href="javascript:jumpToLogoff()">注销</a>
						</div>
					</li>
				</ul>
			</c:if>
			<c:if test="${session.theCustomer == null}">
				<div id="topbar-unlogin">
					<a href="javascript:jumpToLogin()">登录</a>&nbsp;&nbsp;/&nbsp;
					<a href="javascript:jumpToRegister()">注册</a>
				</div>
			</c:if>
	  	</div>
	  	
	  	<div id="fixeddiv-mycart">
	  		<a href="ShowShoppingAction?pageNo=1">我<br>的<br>购<br>物<br>车</a>
	  	</div>
	  	<div id="fixeddiv-gotop">
	  		<a href="#">返回顶部</a>
	  		<hr>
	  		<a href="HomePage.jsp">回到首页</a>
	  	</div>
	  	
	  	<div id="pagebox">
	  		<table>
	  			<tr>
	  				<td class="subbox"><img src="img/books/<%=book.getImage() %>" style="width:100%"/></td>
	  				<td class="subbox">
						<ul id="ul-bookinfo">
							<li>
								<p style="font-size:36px; font-weight:500"><%=book.getName()%></p>
								<p style="font-size:18px; font-weight:300"><%=book.getAuthor()%>  著</p>
							</li>
							<li>
								<p style="font-size:24px; font-weight:300; display:inline">单价: </p>
								<p style="font-size:32px; font-weight:300; color: #FF0000; display:inline">￥<%=book.getPrice()%></p>
							</li>
							<li>
								<p style="font-size:24px; font-weight:300">库存: <%=book.getStockStatus()%>件</p>
							</li>
							<li>
								<table style="margin:auto">
									<tr>
										<td><p style="font-size:24px; font-weight:300; display:inline">购买数量：</p></td>
										<td><button id="reducebtn" onclick="reduce('number')">-</button></td>
										<td><textarea id="number" rows="1"  onkeyup="this.value = check(this.value)">1</textarea></td>
										<td><button id="addbtn" onclick="add('number')">+</button></td>
									</tr>
								</table>
							</li>
							<li>
								<div>
									<a href="javascript:jumpToAddShopping('<%=book.getId() %>')"><img src="img/bookinfo/cart.png"/></a>
								</div>
							</li>
						</ul>
					</td>
	  			</tr>

	  			<tr>
	  				<td class="subbox">
	  					<div id="box-detail">
		  					<div id="box-detail-title">
		  						<h3>书籍信息</h3>
		  						<hr>
		  					</div>
		  					<div id="box-detail-main">
		  						<table id="table-detail">
		  							<tr>
		  								<td>出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;版&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;社：<%=book.getPublisher()%></td>
		  							</tr>
		  							<tr>
		  								<td>国际标准书号：<%=book.getIsbn() %></td>
		  							</tr>
		  							<tr>
		  								<td>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：<%=book.getPageCount() %></td>
		  							</tr>
		  							<tr>
		  								<td>字&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数：<%=book.getWordCount() %></td>
		  							</tr>
		  							<tr>
		  								<td colspan="2">
		  									<p style="display:inline">简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介： </p>
		  									<p id="p-introduction"><%=book.getIntroduction() %></p>
		  								</td>
		  							</tr>
		  						</table>
		  					</div>
		  				</div>
	  				</td>
	  				
	  				<td class="subbox">
	  					<div id="box-comment">
	  						<div id="box-comment-title">
		  						<h3>书籍点评</h3>
		  						<hr>
		  					</div>
		  					<div id="box-comment-main">
		  						<ul>
			  						<s:iterator value="bookCommentList" var="bookComment">
			  							<li id="box-comment-main-commentitem">
			  								<p style="display:inline">评论者：</p>
			  								<p style="color:#FF0000; display:inline"><s:property value="#bookComment.customer.regName"/></p>
			  								<p style="display:inline">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	打分：</p>
			  								<p style="color:#FF0000; display:inline"><s:property value="#bookComment.star"/></p>
			  								<p style="display:inline">	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论日期：</p>
			  								<p style="color:#FF0000; display:inline"><s:property value="#bookComment.contentDate"/></p>
			  								
			  								<p>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="#bookComment.content"/></p>
			  							</li>
			  						</s:iterator>
		  						
			  						<li id="box-comment-main-controlbar">
			  							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  						[<a href="jumpToBookInfo?bookId=${bookId}&pageNo=1">首页</a>]
										<c:if test="${currentPage>1}">
											[<a href="jumpToBookInfo?bookId=${bookId}&pageNo=${currentPage-1}">上一页</a>]
										</c:if>
										<c:if test="${currentPage<totalPage}">
											[<a href="jumpToBookInfo?bookId=${bookId}&pageNo=${currentPage+1}">下一页</a>]
										</c:if>
										[<a href="jumpToBookInfo?bookId=${bookId}&pageNo=${totalPage}">尾页</a>]
										第${currentPage}页/共${totalPage}页
									</li>
								</ul>
		  					</div>
	  					</div>
	  				</td>
	  			</tr>
	  		</table>
	  	</div>
	  </div>
  </body>
</html>
