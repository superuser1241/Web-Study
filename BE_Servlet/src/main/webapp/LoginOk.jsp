<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3><%=request.getParameter("name") %> �� �α��� ����</h3>
	<fieldset>
		<legend>������ ���</legend>
		<%
			//���
			String hobby[] = request.getParameterValues("hobby");
			for(String h : hobby){
				System.out.println(h);//�ܼ�
				//out.println(h + ",");//������
				out.print("<input type='checkbox' value='"+h+"'>"+h);
				%>
				
				<%
			}
		%>
	</fieldset>
</body>
</html>