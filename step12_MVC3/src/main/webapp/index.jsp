<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>MVC Refactoring & Reflection TEST </h2>
 
 <h3>
    회원관리 - UserController <p>
    <a href="${path}/front?key=user&methodName=login">로그인하기</a><p>
    <a href="${path}/front?key=user&methodName=update">회원정보수정</a><p>
 </h3>
 
 <hr>
  <h3>
    상품관리 - GoodsController <p>
    <a href="${path}/front?key=goods&methodName=list">상품LIST</a><p>
    <a href="${path}/front?key=goods&methodName=insert">상품등록</a><p>
 </h3>
 
 <hr>
 
 <h3>
    게시판관리 - BoardController <p>
    <a href="${path}/front?key=board&methodName=list">게시판 LIST</a><p>
    <a href="${path}/front?key=board&methodName=read">상세보기</a><p>
 </h3>


</body>
</html>