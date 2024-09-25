<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3><%=request.getParameter("name") %> 님 로그인 성공</h3>
	<fieldset>
		<legend>선택한 취미</legend>
		<%
			//취미
			String hobby[] = request.getParameterValues("hobby");
			for(String h : hobby){
				System.out.println(h);//콘솔
				//out.println(h + ",");//브라우저
				out.print("<input type='checkbox' value='"+h+"'>"+h);
				%>
				
				<%
			}
		%>
	</fieldset>
</body>
</html>