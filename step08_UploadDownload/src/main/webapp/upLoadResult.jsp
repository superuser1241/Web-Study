<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> 파일 첨부 결과 </h3>
<h4>
name : ${requestScope.name} <br>
subject : ${requestScope.subject} <br>
fileName : ${fileName} <br>
fileSize : <fmt:formatNumber value="${fileSize}"/>byte <br>
saveDir : ${requestScope.saveDir} <br>
</h4>


</body>
</html>