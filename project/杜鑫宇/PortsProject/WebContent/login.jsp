<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录界面</title>
</head>
<style type="text/css">
  body{
  	background-color:black;
   	/*background-image:url(img/0.jpg);*/
   	background-size:100%;
   }
   #firstPage{
	width: 500px;
	height: 400px;
	border-radius: 8px;
	background-color:white;
	filter: alpha(opacity=60);
	-moz-opacity:0.8;
	opacity: 0.8;
	position: absolute;
	top: 100px;
	right: 200px;
   }
   img{
   	width: 50px;
   	height: 50px;
   	position: absolute;
   	top:20px;
   	left:230px;
   }
   #user,#password{
		width: 400px;
		height: 40px;
		background-color: rgba(0,0,0,0);
		border: 1.5px solid #DCDCDC;
		border-radius: 5px;
		margin-top: 20px;
		position: relative;
		top: 70px;
		left: 40px;
		color: black;
   }
   #submit{
	width: 400px;
	height: 40px;
	cursor: pointer;
	background-color: #649BFF;
	border: 1.5px solid #DCDCDC;
	border-radius: 5px;
	margin-top: 20px;
	position: relative;
	top: 90px;
	left: 40px;
  }
  #firstPage a{
 	text-decoration: none;
 	color: 	#6450FF;
	font-size: 13px;
 	float: right;
 	position: relative;
	top: 120px;
	right: 20px;
 }
</style>
<body>
  <div id="firstPage">
  <img src="img/8.png">
  <form action="LoginServlet" method="post" name="formtext" id="form1">
	   <input type="text" id="user" name="user" placeholder="  请输入用户名"><br/>
	   <input type="password" id="password" name="password" placeholder="  请输入密码"><br/>
	   <input type="submit" name="submit" value="登录" id="submit" onclick="mysubmit()">
	   <a href="register.jsp" target ="_top" >没有账号？点击注册</a>
  </form>
</div>
</body>
</html>