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
	src="${pageContext.request.contextPath}/static/js/juryRegis/editJuryRegis.js"></script>

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
	<form id="aco-juryRegis-form">
		<div>
			受伤情况:<input type="text" id="aco-injurysitu"><br>
		</div>
		<div>
			自述受伤情况:<textarea id="aco-selfinjuryreason" rows="3"></textarea><br>
		</div>
		<div>
			病史情况:<input type="text" id="aco-medicalhistorysitu"><br>
		</div>
		<div>
			民警陈述原因:<textarea id="aco-policestatementreason" rows="3"></textarea><br>
		</div>
		<div>
			登记人:<input type="text" id="aco-detainedpolice"><br>
		</div>
		<div>
			送押民警:<input type="text" id="aco-scpolice"><br>
		</div>
		<div>
		             备注：<textarea id="aco-remark" rows="3"></textarea>
		</div>
		<input type="submit" id="aco-juryRegis-form-submit" value="保存">  
		<input type="hidden" id="aco-juryRegis-id" value="${id}" >
	</form>
</body>
</html>