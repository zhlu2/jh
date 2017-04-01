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
	src="${pageContext.request.contextPath}/static/js/conversationRecord/addConversationRecord.js"></script>

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
	<form id="aco-conversationRecord-form">
		<div>
			谈话民警:<input type="text" id="aco-talkPolice"><br>
		</div>
		<div>
			谈话类型:<input type="text" id="aco-talktype"><br>
		</div>
		<div>
			谈话地点:<input type="text" id="aco-talkplace"><br>
		</div>
		<div>
			提问:<input type="text" id="aco-ask"><br>
		</div>
		<div>
			回答:<input type="text" id="aco-answer"><br>
		</div>
		<div>内容:<textarea id="aco-talkcontent" rows="3"></textarea></div>
		<input type="submit" id="aco-conversationRecord-form-submit" value="保存">
	</form>
</body>
</html>