<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  a{ text-decoration: none}
</style>
</head>
<body>
<h3> 다운로드 가능한 파일 정보 </h3>
<ul>
  <c:forEach items="${fileNames}" var="fileName">
      <li><a href="downLoad?fname=${fileName}">${fileName}</a></li>
  </c:forEach>
</ul>



</body>
</html>