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
	src="${pageContext.request.contextPath}/static/js/prsArrgInfo/editPrsArrgInfo.js"></script>

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
	<form id="aco-prsArrgInfo-form">
		<div>
			申请民警:<input type="text" id="aco-applypolice"><br>
		</div>
		<div>
			探访人姓名:<input type="text" id="aco-prsfullname"><br>
		</div>
		<div>
			性别:<input type="text" id="aco-sex"><br>
		</div>
		<div>
			年龄:<input type="text" id="aco-age"><br>
		</div>
		<div>
			与被探访人关系:<input type="text" id="aco-prsrelation"><br>
		</div>
		<div>
			申请理由:<input type="text" id="aco-applyreason"><br>
		</div>
		<input type="submit" id="aco-prsArrgInfo-form-submit" value="保存">  
		<input type="hidden" id="aco-prsArrgInfo-id" value="${id}" >
	</form>
</body>
</html>