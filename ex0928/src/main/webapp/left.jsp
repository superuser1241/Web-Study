<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.userId ==null }">
			<form action="LoginServlet" method="post">
				아이디: <input type="text" name="userId"><br>
				비번 : <input type="password" name="userPwd"><br>
				<input type="submit" value="로그인">
			</form>
		</c:when>
		
		<c:otherwise>
			<p>
                이름: ${sessionScope.userId} <br>
                접속 시간: <fmt:formatDate value="${sessionScope.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </p>
            <form action="LogoutServlet" method="get">
                <input type="submit" value="로그아웃">
            </form>
		</c:otherwise>
	</c:choose>
		
	
</body>
</html>