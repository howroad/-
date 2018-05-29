<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<base href="/YJBZXT/" />
</head>
<body>
	<h1>网络错误哦！~</h1>
	<h4>
		<a href='index'>【<span id="span1">3</span>秒后自动返回登录页面，如果没返回请点击此处】
		</a>
	</h4>
	<script type="text/javascript" src="js/jQuery-2.2.2-min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script>
		var num = 3;
		var ospan = document.getElementById("span1");
		window.setInterval(function() {
			ospan.innerHTML = --num;
			if (num <= 0) {
				location.href = "jsp/index.jsp";
			}
		}, 1000);
	</script>
</body>
</html>