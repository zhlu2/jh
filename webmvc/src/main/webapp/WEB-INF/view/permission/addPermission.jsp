<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap分页实例</title>
<link href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/static/js/jQuery/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/permission/addPermission.js"></script>

<style type="text/css">
#queryDiv {
 margin-right: auto;
 margin-left: auto;
 width:600px;
}
#textInput {
 margin-top: 10px;
}
#tableResult {
 margin-right: auto;
 margin-left: auto;
 width:600px;
}
td {
 width:150px
}
</style>
</head>
<body>
	<form id="aco-useredit-form">
		<div>
			权限名:<input type="text" id="aco-permissionName"><br>
		</div>
		<div>
			权限标识:<input type="text" id="aco-permissionSign"><br>
		</div>
		<div>
			权限描述:<input type="text" id="aco-description"><br>
		</div>
		<input type="submit" id="aco-permission-form-submit" value="保存">  
	</form>
</body>
</html>