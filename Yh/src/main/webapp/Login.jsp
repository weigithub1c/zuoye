<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆界面</title>
</head>
<body>
	<form action="loginServlet.do" method="post">
		用户名：<input type="text" name="uname"/> </br>
		密码：<input type="password" name="upwd"/></br>
		<input type="submit" value="登陆"/>
		<input type="reset" value="重置"/>
	</form>
</body>
</html>