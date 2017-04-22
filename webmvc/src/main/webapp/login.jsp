<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>戒毒管理信息系统</title>
<link
	href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/style.css"
	rel="stylesheet">
<script
	src="<%=request.getContextPath()%>/static/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="<%=request.getContextPath()%>/static/images/avtar.png" />
		</div>
		<form action="${pageContext.request.contextPath }/user/login"
			method="post">
			<input type="text" class="text" name="username" placeholder="请输入账户名" />
			<div class="key">
				<input type="password" name="password" placeholder="请输入密码" />
			</div>
			<div class="signin">
			<input type="submit" value="登录">${error }
		</div>
		</form>

	</div>
</body>
</html>