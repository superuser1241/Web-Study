<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>내용</th>
		</tr>
			
		<c:forEach items="${applicationScope.boardList}" var="board">
			<tr>
				<td>${board.no}</td>
				<td>${board.subject}</td>
				<td>${board.content}</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	<c:if test="${not empty sessionScope.userId }">
		<form action="BoardServlet" method="post">
			제목: <input type="text" name="subject"><br>
			내용: <textarea name="content"></textarea><br>
			<input type="submit" value="등록">
		</form>	
	</c:if>
</body>
</html>