<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<%--
	session.setMaxInactiveInterval(30); //30초
--%>

	<h1>HttpSession 관련 메소드</h1>
	<h3>
		getId = <%= session.getId()%><br>
		isNew = <%= session.isNew()%><br>
		getMaxInactiveInterval = <%= session.getMaxInactiveInterval()%><br>
		getCreationTime = <%= session.getCreationTime()%><br>
		getLastAccessedTime = <%= session.getLastAccessedTime()%>
	</h3>
	
	<%
		//세션 영역에 정보를 저장해보자(서버측에 저장)
		session.setAttribute("name", "영준");
		session.setAttribute("id", "young");
		session.setAttribute("hobby",new String[]{"등산","수영","낚시"});
	%>
	
	<h3>session에 저장된 정보 조회해보자</h3>
	이름: <%=session.getAttribute("name") %>
	아이디: <%=session.getAttribute("id") %>
	취미: <%=session.getAttribute("hobby") %><br>
	
	<a href="sessionGet.jsp">jsp 이동</a><br>
	<a href="sessionServlet">servlet 이동</a><br>
	<a href="/sessionServlet">/servlet 이동</a><br>
	<a href="../sessionServlet">../servlet 이동</a><br>
	
	<%=request.getContextPath()%>/${pageContext.request.contextPath }<p>
	
	<a href="<%=request.getContextPath() %>/sessionServlet">servlet 이동</a><br>
	<a href="${pageContext.request.contextPath}/sessionServlet">servlet 이동</a><br>
	
	
</body>
</html>





