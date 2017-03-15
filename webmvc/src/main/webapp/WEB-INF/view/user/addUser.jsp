<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user/addUser.js"></script>
</head>
<body>
  
      <form id="aco-useradd-form">
      <div>用户名:<input type="text" id="aco-userName"><br></div>
      <div>密       码:<input type="text" id="aco-userPassword"><br></div>                                          
          <input type="hidden" id="aco-createtime">
           <input type="submit" id="aco-useradd-form-submit" value="保存">          
      </form>
</body>
</html>