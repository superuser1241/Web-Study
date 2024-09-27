<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	alert("${requestScope.errMsg}");
	location.href="${pageContext.request.contextPath}/LoginForm.html";
	
</script>
</body>
</html>