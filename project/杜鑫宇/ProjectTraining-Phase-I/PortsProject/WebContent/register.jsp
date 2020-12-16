<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册界面</title>
</head>
<style type="text/css">
   body{
   	background-image:url(img/1.jpg);
   /*	background-color: purple;*/
   	background-size:100%;
   }
   #firstPage{
	width: 500px;
	height: 500px;
	border-radius: 8px;
	background-color:white;
	filter: alpha(opacity=60);
	-moz-opacity:0.8;
	opacity: 0.8;
	/*overflow: hidden;*/
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
    #name,#pass,#email,#phone{
	width: 400px;
	height: 40px;
	background-color: rgba(0,0,0,0);
	border: 1.5px solid #DCDCDC;
	border-radius: 5px;
	margin-top: 20px;
	position: relative;
	top: 65px;
	left: 40px;
	color: black;
  }
  #in{
	width: 400px;
	height: 40px;
	cursor: pointer;
	background-color: #649BFF;
	border: 1.5px solid #DCDCDC;
	border-radius: 5px;
	margin-top: 20px;
	position: relative;
	top: 80px;
	left: 40px;
  }
 #firstPage a{
 	text-decoration: none;
 	color: 	#6450FF;
	font-size: 13px;
 	float: right;
 	position: relative;
	top: 130px;
	right: 20px;
 }
</style>
<body>
    <div id="firstPage">
	 	<img src="img/8.png">
		<form action="register" method="post">
			<input type="text" name="user" placeholder="  请输入用户名" id="name"><br/>
			<input type="password" name="password" placeholder="  请输入密码" id="pass">
			<input type="text" id="email" name="email" placeholder="  请输入电子邮箱"><br/>
	        <input type="text" id="phone" name="phone" placeholder="  请输入手机号"><br/>
	        <input type="submit" name="submit" id="in" value="注册">
		</form>
		<a href="login.jsp" target ="_top" >已有账号？点此登陆</a>
	</div>
</body>
</html>