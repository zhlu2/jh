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
	src="${pageContext.request.contextPath}/static/js/policeBasicInfo/editPolice.js"></script>

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
	<form id="aco-police-form">
		<div>
			民警编号:<input type="text" id="aco-policenum"><br>
		</div>
		<div>
			民警姓名:<input type="text" id="aco-policename"><br>
		</div>
		<div>
			民警性别:<input type="text" id="aco-policesex"><br>
		</div>
		<div>
			政治面貌:<input type="text" id="aco-politicaloutlook"><br>
		</div>
		<div>
			证件号码:<input type="text" id="aco-certificatenum"><br>
		</div>
		<input type="submit" id="aco-police-form-submit" value="保存">  
		<input type="hidden" id="aco-police-id" value="${id}" >
	</form>
</body>
</html>