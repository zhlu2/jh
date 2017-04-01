<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap分页实例</title>
<link
	href="<%=request.getContextPath()%>/static/js/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="<%=request.getContextPath()%>/static/js/jQuery/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/socialRelations/addSocialRelations.js"></script>

<style type="text/css">
#queryDiv {
	margin-right: auto;
	margin-left: auto;
	width: 600px;
}

#textInput {
	margin-top: 10px;
}

#tableResult {
	margin-right: auto;
	margin-left: auto;
	width: 600px;
}

td {
	width: 150px
}
</style>
</head>
<body>
	<form id="aco-socialRelations-form">
		<div>
			关系人姓名:<input type="text" id="aco-relationname"><br>
		</div>
		<div>
			关系人性别:<input type="text" id="aco-relationsex"><br>
		</div>
		<div>
			关系人电话:<input type="text" id="aco-relationphone"><br>
		</div>
		<div>
			关系人证件号:<input type="text" id="aco-relationcertificatenum"><br>
		</div>
		<div>
			现住址:<input type="text" id="aco-address"><br>
		</div>
		<div>
			关系:<input type="text" id="aco-relationship"><br>
		</div>
		<input type="submit" id="aco-socialRelations-form-submit" value="保存">
	</form>
</body>
</html>