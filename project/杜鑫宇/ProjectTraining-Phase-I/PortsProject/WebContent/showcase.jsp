<%@page import="Usecase.service.CaseServiceImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html" charset="utf-8"> -->
<title>用例展示</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' href='./css/aqua.min.css'>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div class="container flex flex-wrap justify-between">
		<div
			class="dark-mode mx-8 my-4 h-full bg-primary flex flex-col justify-between px-6 py-12 rounded overflow-hidden">

			<ul class="menu mt-6">
				<li class="menu-item"><a href="./resInfo.jsp"> <img
						src="./img/zhuye.png" class="icon fas mr-5"> 测试接口
				</a></li>

				<li class="menu-item  active"><a href="list"> <img
						src="./img/shujuku.png" class="icon fas mr-5"> 数据库用例
				</a></li>
				<li class="divider"></li>
				<li class="menu-item"><a href=""> <img
						src="./img/shezhi.png" class="icon fas mr-5"> 设置
				</a></li>
				<li class="menu-item"><a href="./login.jsp"> <img
						src="./img/exit.png" class="icon fas mr-5"> 退出
				</a></li>
			</ul>

		</div>
	</div>
	
	<div class="right">
		<h2>测试用例维护</h2>
		<div class="save-up">
			<form action="add" method="post">
				<h3>Add UseCase</h3>
				<ul class="in">
					<li>&nbsp<span>URL:</span><input type="text" name="url2"
						class="url2" />
					</li>
					<li><span>METHOD:</span><input type="text" name="method2"
						class="method2" /></li>
					<li >&nbsp<span class="bb" >BODY:</span><textarea name="body2" class="body2"  rows="5" cols="40"></textarea>
					</li>
				</ul>
				<input type="submit" value="Save" class="save" />
			</form>
		</div>
		<div class="usecase-table">
			<h3>UseCase Show</h3>
			<table border="1px" cellspacing="0">
				<tr>
					<th class="colid">ID</th>
					<th class="colurl">URL</th>
					<th class="colmethod">METHOD</th>
					<th class="colbody">BODY</th>
					<th >DELETE</th>
					<th >RUN</th>


				</tr>
				<c:forEach items="${cases}" var="user">
					<tr>
						<td align="center">${user.id}</td>
						<td align="center">${user.url}</td>
						<td align="center">${user.method}</td>
						<td align="center">${user.body}</td>
						<td align="center"><a href='delete?id=${user.id}'><img src="./img/delete.png" class="icon fas mr-5" >delete</a></td>
						<td align="center"><a href='run?id=${user.id}'><img src="./img/run.png" class="icon fas mr-5" >Press to
								run</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<script src="./js/script.js"></script>
</body>
</html>