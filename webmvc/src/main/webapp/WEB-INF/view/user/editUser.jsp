<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script
	src="<%=request.getContextPath()%>/static/js/jQuery/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/user/editUser.js"></script>
</head>
<body>
	<form id="aco-useredit-form">
		<div>
			用户名:<input type="text" id="aco-userName"><br>
		</div>
		<div>
			密 码:<input type="text" id="aco-userPassword"><br>
		</div>

     <input type="submit" id="aco-useredit-form-submit" value="保存">  
     <input type="hidden" id="aco-user-idedit" value="${id}"> 
	</form>
</body>
</html>