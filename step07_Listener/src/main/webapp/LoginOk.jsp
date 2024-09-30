<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    		${userId }<br>
    		${userName }님 로그인중<br>
    		접속 시간: ${time}<br>
    		<h3>현재 접속자수 : ${applicationScope.nowCounter }</h3><br>
    		
    		<img src="https://picsum.photos/250/250"/><br>
    		
    		<form action="LogoutServlet" method="post">
                <input type="submit" value="로그아웃" />
            </form>
            
</body>
</html>