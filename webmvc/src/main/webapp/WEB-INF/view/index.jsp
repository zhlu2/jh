<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath }/demoController/index">用户</a>
<a href="${pageContext.request.contextPath }/rolePermission/list">角色</a>
<a href="${pageContext.request.contextPath }/permission/list">权限</a>
<a href="${pageContext.request.contextPath }/policeBasicInfo/list">民警基本信息</a>
<a href="${pageContext.request.contextPath }/dedrugBasicInfo/list">戒毒人员基本信息</a>
<a href="${pageContext.request.contextPath }/conversationRecord/list">谈话教育</a>
<a href="${pageContext.request.contextPath }/juryRegis/list">伤情登记</a>
<a href="${pageContext.request.contextPath }/prsArrgInfo/list">临时探访</a>
<a href="${pageContext.request.contextPath }/socialRelations/list">社会关系</a>
</body>
</html>
