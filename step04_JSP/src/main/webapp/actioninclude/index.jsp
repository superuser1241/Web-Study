<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<%
	String addr ="서울시 강남구";
%>
	<!-- 외부의 top.jsp 연결 -->
	<jsp:include page="top.jsp"></jsp:include>
	<h1>여기는 index.jsp메인 영역입니다</h1>
	
	<!-- include 되는 문서쪽으로 param 정보 설정 -->
	<jsp:include page="footer.jsp">
		<jsp:param value="<%=addr %>" name="addr"/>
		<jsp:param value="Young" name="id"/>
	</jsp:include>
</body>
</html>