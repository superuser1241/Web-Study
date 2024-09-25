<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<h3>&lt;c:set > and &lt;c:out> 테스트</h3>

<c:set var="id" value="young"></c:set>
<c:set var="addr" value="서울" scope="session"></c:set>
<c:set var="info" value="<h5>배고파요</h5>" scope="application"></c:set>

<!-- 출력해보자 -->
${id }/${addr }/${info }<br>
<c:out value="점심메뉴는?"></c:out><br>
<c:out value="${id }"></c:out><br>
<c:out value="${addr }"></c:out><br>

<c:out value="${info }"></c:out><br>
<c:out value="${info }" escapeXml="false"></c:out><br>

<a href="ex02_result.jsp">이동</a>
</body>
</html>