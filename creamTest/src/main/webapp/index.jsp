<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<blockquote>
  <h1>KOSTA My Sevlet & Jsp Final !!!!</h1>
  <h4>Sevlet&Jsp Final <cite title="Source Title">Wow!</cite></h4>
  <h4>
    1. 주요기능 <p>
      &nbsp;&nbsp; 1) 회원관리(로그인 / 로그아웃) - MEMBER Table <br>
      &nbsp;&nbsp; 2) 자료실 형태의 게시판관리 (등록, 수정, 삭제, 검색, 다운로드) - Electronics Table<P>
      
    2. 주요 기술 및 환경<p>
      &nbsp;&nbsp;1) Refactoring MVC구조  <br>
      &nbsp;&nbsp;2) Filter  - Session유무 체크 <br>
      &nbsp;&nbsp;&nbsp;&nbsp; : Board에 대한 접근은  인증된 사용자만 가능<br>
	  &nbsp;&nbsp;3) ServletContextListener - 사전 초기화 작업 <br>
	  &nbsp;&nbsp;4) Servlet Upload + DownLoad <br>
	  &nbsp;&nbsp;5) 사용자 정의 Exception - AuthenticationException<br>
      &nbsp;&nbsp;6) Action Tag include - Layout Template  <br>
      &nbsp;&nbsp;7) Bootscrap UI <br>
      &nbsp;&nbsp;8) Oracle 21c <br>
      &nbsp;&nbsp;9) ApacheTomcat 10.1<br>
      
  </h4>
  
</blockquote>
</body>
</html>

 <jsp:include page="common/footer.jsp"/>