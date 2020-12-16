<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>接口测试平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='css/aqua.min.css'>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		pageContext.setAttribute("textContent", request.getAttribute("res_result"));
		pageContext.setAttribute("textParam", request.getAttribute("input_text"));
		pageContext.setAttribute("url_param", request.getAttribute("url_params"));
	%>
	<div class="container flex flex-wrap justify-between">
		<div class="dark-mode mx-8 my-4 h-full bg-primary flex flex-col justify-between px-6 py-12 rounded overflow-hidden">

			<ul class="menu mt-6">
				<li class="menu-item active">
					<a href="resInfo.jsp">
						<img src="img/zhuye.png"class="icon fas mr-5">
						测试接口
					</a>
				</li>
				
				<li class="menu-item">
					<a href="list">
						<img src="img/shujuku.png"class="icon fas mr-5">
						数据库用例
					</a>
				</li>
				<li class="divider"></li>
				<li class="menu-item">
					<a href="">
						<img src="img/shezhi.png"class="icon fas mr-5">
						设置
					</a>
				</li>
				<li class="menu-item">
					<a href="login.jsp">
						<img src="img/exit.png"class="icon fas mr-5">
						退出
					</a>
				</li>
			</ul>

		</div>
	</div>
	<div class="right">
		<form action="jumpPage.jsp">
			<div class="sel">
				<select class="sct" name="methodname">
					<option value="选择方法" selected>选择方法</option>
					<option value="post">POST</option>
					<option value="get">GET</option>
				</select> <input type="text" name="urlname"
					style="height: 36px; border: 1px #bfbfbf solid; width: 300px; position: relative; bottom: 2px; right: 4px; background-color: #dbdbdb; border-top-right-radius: 10px; border-bottom-right-radius: 10px;" />
				<input
					style="width: 80px; height: 40px; position: relative; left: 30px; background-color: #dbdbdb; border: 1px #bfbfbf solid; font-size: 18px; border-radius: 9px;"
					type="submit" value="Send" />
			</div>

			<div class="textbody" style="padding-top: 5px">
				<p>Request</p>
				<textarea name="textparam" rows="10" cols="85">${textParam}</textarea>
			</div>
			<div class="textbody">
				<p>Response</p>
				<textarea rows="10" cols="85">${textContent}</textarea>
			</div>

		</form>
		<span class="request-url">请求地址：</span> <span class="request-url">${url_param}</span>

	</div>
	<script src="js/script.js"></script>
</body>
</html>