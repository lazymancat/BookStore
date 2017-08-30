<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");	
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网上购书系统</title>
	
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/hp-style.css?version=1.0.1">
	<link rel="stylesheet" type="text/css" href="css/normal.css">
    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>  
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
	<script type="text/javascript" src="js/hp.js"></script>
    <!-- Bootstrap -->
	<link rel="stylesheet" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"/>  
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		
    <script type="text/javascript" src="js/bookinfopage.js?version=2.0.1"></script>
	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  
  </head>
  
  <body>
  	<div style="margin :0 auto;width:1300px; height:100%; ">
    	<!-- 网站顶部 -->
	  	<div id="topbar">
	  		<c:if test="${session.theCustomer != null}">
		  		<ul id="topbar-ddm">
					<li><a href="javascript:jumpToSelf()" onmouseover="menuOpen('menu')" onmouseout="menuClose()"><%=((Customer)session.getAttribute("theCustomer")).getRegName()%></a>
						<div id="menu" onmouseover="menuOpen('menu')" onmouseout="menuClose()">
							<a href="ShowShoppingAction?pageNo=1">我的购物车</a>
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
	  	
		<!-- 顶部搜索 -->
		<div class="homePage_headSerach_subTitle">搜索商品</div>
		<s:form method="get" action="homePageSearch">
			<div class="homePage_headSerach">
				<input type="text" name="bookName" placeholder="请输入你要查找的书籍名称">
			</div>
		</s:form>
		
		<!-- 图书分类 -->
		<div class="panel-decorate">
			<div class="panel-top">图书分类</div>
			<ul style="padding:10px;" class="panel-list">
				<s:action name="getAllBookType" executeResult="false"></s:action>
				<s:iterator value="#request.bookTypes">
		    		<li style="line-height:30px;">
		    			<a style="text-decoration:none;" class="panel-word" href="newBook?bookType=<s:property value="typeId"/>"><s:property value="typeName"/></a>
		    		</li>
				</s:iterator>
			</ul>
		</div>

		<!-- 滑动广告窗口 -->
		<div class="scroll-advertisement">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"></li>
				</ol>
				<!-- 插入广告图片 -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img style="height:100%;" src="http://img61.ddimg.cn/upload_img/00570/tongshu/750315_djj_0508.jpg" alt="">
					</div>

					<div class="item">
						<img style="height:100%;" src="http://img61.ddimg.cn/upload_img/00570/tongshu/750x315_djj_0510.jpg" alt="">
						<div class="carousel-caption"></div>
					</div>

					<div class="item">
						<img style="height:100%;" src="http://img63.ddimg.cn/upload_img/00655/ddswe/jglz750315.jpg" alt="">
						<div class="carousel-caption">
						</div>
					</div>

					<div class="item">
						<img style="height:100%;" src="http://img62.ddimg.cn/upload_img/00087/hw/750x315_dl_20170511.jpg" alt="">
						<div class="carousel-caption">
						</div>
					</div>

					<div class="item">
						<img style="height:100%;" src="http://img60.ddimg.cn/ddreader/Feature/0511c.750-315.jpg" alt="">
						<div class="carousel-caption">
						</div>
					</div>
				</div>
				<!-- 插入上一个广告按钮 -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevorn-left">&lsaquo;</span>
					<span class="sr-only">Previous</span>
				</a>
				<!-- 插入下一个广告按钮 -->
				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevorn-right">&rsaquo;</span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>

		<!-- 推荐商品 -->
		<div class="tab-decorate">
			<!-- 选项卡组件（菜单项nav-pills）-->
			<ul id="myTab" class="nav nav-pills" role="tablist">
			    <li class="active"><a href="#bulletin" role="tab" data-toggle="pill">新品推荐</a></li>
			    <li><a href="#rule" role="tab" >便宜书籍</a></li>
			    <li><a href="#security" role="tab" >精选推荐</a></li>
			</ul>
			<!-- 选项卡面板 -->
			<div id="myTabContent" class="tab-content">
				<!--新品推荐Action -->
				<s:action name="newProduct" executeResult="false"></s:action>
			    <div class="tab-pane fade in active" id="bulletin">
					<!--遍历 -->
					<s:iterator value="#request.manageBooks">
				    	<div class="book-decorate">
				    		 <div class="book-img-decorate">
				    		 	<a href="jumpToBookInfo?bookId=<s:property value="id"/>"><img src="img/books/<s:property value="image"/>" style="height:110px; width:110px; "></a>
				    		 </div>
				    		 <div class="book-title-decorate" style="height:20px;overflow:hidden;text-overflow:ellipsis;-o-text-overflow:ellipsis;white-space:nowrap;font-weight: 700;"><s:property value="name"/></div>
				    		 <div class="book-price-decorate">￥<s:property value="price"/></div>
				    	</div>
			    	</s:iterator>
			    </div>
			   
				<!--便宜推荐Action -->
				<s:action name="cheapBook" executeResult="false"></s:action>
			    <div class="tab-pane fade" id="rule">
					<!--遍历 -->
					<s:iterator value="#request.cheapBooks">
				    	<div class="book-decorate">
				    		 <div class="book-img-decorate">
				    		 	<a href="jumpToBookInfo?bookId=<s:property value="id"/>"><img src="img/books/<s:property value="image"/>" style="height:110px; width:110px; "></a>
				    		 </div>
				    		 <div class="book-title-decorate" style="height:20px;overflow:hidden;text-overflow:ellipsis;-o-text-overflow:ellipsis;white-space:nowrap;font-weight: 700;"><s:property value="name"/></div>
				    		 <div class="book-price-decorate">￥<s:property value="price"/></div>
				    	</div>
			    	</s:iterator>
				</div>
				
				<!--精选推荐Action -->
				<s:action name="randomBook" executeResult="false"><s:param name="bookSum">10</s:param></s:action>
			    <div class="tab-pane fade" id="security">
					<!--遍历 -->
					<s:iterator value="#request.randomBooks">
				    	<div class="book-decorate">
				    		 <div class="book-img-decorate">
				    		 	<a href="jumpToBookInfo?bookId=<s:property value="id"/>"><img src="img/books/<s:property value="image"/>" style="height:110px; width:110px; "></a>
				    		 </div>
				    		 <div class="book-title-decorate" style="height:20px;overflow:hidden;text-overflow:ellipsis;-o-text-overflow:ellipsis;white-space:nowrap;font-weight: 700;"><s:property value="name"/></div>
				    		 <div class="book-price-decorate">￥<s:property value="price"/></div>
				    	</div>
					</s:iterator>
			    </div>
			</div>
		</div>

		<!-- 右边框 -->
		<div class="right-block">
			<div class="block-title">猜你喜欢</div>
			<s:action name="randomBook" executeResult="false"><s:param name="bookSum">3</s:param></s:action>
			<s:iterator value="#request.randomBooks">
				<div class="block-book-decorate">
		    		 <div class="block-img-decorate">
		    		 	<a href="jumpToBookInfo?bookId=<s:property value="id"/>"><img src="img/books/<s:property value="image"/>" style="height:120px; width:120px;"></a>
		    		 </div>
		    		 <div class="block-title-decorate" style="height:30px;overflow:hidden;text-overflow:ellipsis;-o-text-overflow:ellipsis;white-space:nowrap;font-weight: 700;"><s:property value="name"/></div>
		    		 <div class="block-price-decorate">￥<s:property value="price"/></div>
				</div>
			</s:iterator>
		</div>
    </div>
  </body>
</html>
