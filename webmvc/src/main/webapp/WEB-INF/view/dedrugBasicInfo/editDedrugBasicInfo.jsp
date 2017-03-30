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
	src="${pageContext.request.contextPath}/static/js/dedrugBasicInfo/editDedrugBasicInfo.js"></script>

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
	<form id="aco-edit-dedrugBasicInfo-form">
		<div>
			姓名:<input type="text" id="aco-fullname"><br>
		</div>
		<div>
			性别:<input type="text" id="aco-sex"><br>
		</div>
		<div>
			证件号码:<input type="text" id="aco-certificatenum"><br>
		</div>
		<div>
			人员编号:<input type="text" id="aco-personid"><br>
		</div>
		<div>
			吸毒方式:<input type="text" id="aco-drugabuse"><br>
		</div>
		<div>
			毒品种类:<input type="text" id="aco-drugtype"><br>
		</div>
		<div>
			办案人员:<input type="text" id="aco-casehandleperson"><br>
		</div>
		<div>
			戒毒期限:<input type="text" id="aco-abandonlimit"><br>
		</div>
		<div>
			戒毒方法:<input type="text" id="aco-abandonmethod"><br>
		</div>
		<div>
			戒毒开始日期:<input type="text" id="aco-abandonstartdate"><br>
		</div>
		<div>
			入所原因:<input type="text" id="aco-entryreason"><br>
		</div>
		<input type="submit" id="aco-dedrugBasicInfo-form-submit" value="保存">  
		<input type="hidden" id="aco-dedrugBasicInfo-id" value="${id}" >
	</form>
</body>
</html>