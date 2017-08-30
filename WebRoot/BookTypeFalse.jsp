<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="refresh" content ="3;url=<%=basePath%>HomePage.jsp">
	<link rel="stylesheet" type="text/css" href="css/btdf-style.css?version=1.0.0">
	<title>页面跳转</title>
    
    <script type="text/javascript"> 
		var i = 4; 
		function shownum(){ 
			i=i-1; 
			document.getElementById("time").innerHTML=i+"秒后自动跳转分类修改界面";
			setTimeout('shownum()',1000); 
		} 
	</script>

  </head>
  
   
  <body onload="shownum()">
    	<div class="webPagejump_title">404出错啦！</div>
		<div class="webPagejump_img">
			<img style="height:490px;width:400px;" src="img/manage/webPageJump_img.jpg">
		</div>
		<div class="webPagejump_border">
			<div class="webPagejump_border_title">此分类还没有书，3秒后自动跳转！</div>
			<a href="HomePage.jsp"><div class="webPagejump_border_subtitle">如果长时间没反应，请点这里！</div></a>
		</div>
  </body>
</html>
