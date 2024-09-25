<%@page import="ex0925_el.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL(Expression Language) =  표현언어</h3>
\${5} = ${5}<br>
\${5+2} = ${5+2}<br>
\${5*2} = ${5*2}<br>
\${5 lt 2} = ${5 lt 2}<br>

\${"안녕"} = ${"안녕"}<br>
\${'안녕'} = ${'안녕'}<br>

\${5 gt 3 and 10 eq 10} = ${5 gt 3 and 10 eq 10}<br>
\${5 > 3 && 10 == 10} = ${5 > 3 && 10 == 10}<br>

<!-- 삼항 연산자 -->
\${5 gt 3 ? "크다" : "작다"} = ${5 gt 3 ? "크다" : "작다"}<br>

<!-- 
	만약
	http://localhost:8000/step04_JSP/EL_JSTL/ex01_elTest.jsp?age=10
	
	$(param.age)
 -->
${param.age>18 ? "성인" : "미성년자"}<br>

<!-- 
	만약
	http://localhost:8000/step04_JSP/EL_JSTL/ex01_elTest.jsp?age=10&id=값
	
	$(param.age)
 -->
 
 <!-- EL에서 문자열 연결방법 -->
 ${param.id !=null ? param.id.concat("님") : "Guest"} <br>
 ${param.id !=null ? param.id += "님" : "Guest"} <hr>
 
 <%
 	//xxx Scope영역에 정보 저장해보자
 	request.setAttribute("id", "young");
 
 	session.setAttribute("name", "young jun");
 	session.setAttribute("addr", "오리역");
 	
 	application.setAttribute("addr", "서울");
 	application.setAttribute("message", "EL학습중");
 %>
 <h3>scope정보 조회하기</h3>
 아이디 : ${id}<br>
 이름 : ${name}<br>
 주소(session) : ${sessionScope.addr}<br>
 주소(application) : ${applicationScope.addr} <br>
 메세지 : ${message}<br>
 
 <h3>Product 정보 조회</h3>
 <%--
 	Product p = new Product();
 --%>
 
 <jsp:useBean id="p" class="ex0925_el.Product"></jsp:useBean>
 
 상품코드 : <%=p.getCode() %> / ${p.code }<br>
 이름 : ${p.name }<br>
 수량 : ${p.qty }<br>
 가격 : ${p.price }<br>
 총 금액(수량*가격) : ${p.qty*p.price }<br>
</body>
</html>






