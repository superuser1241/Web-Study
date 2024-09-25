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
	<h3>&lt;c:if> and &lt;c:choose> TEST</h3>
	<!-- 
		http://localhost:8000/step04_JSP/EL_JSTL/ex03_if_choose.jsp?age=10
		
		만약 age의 값이 있으면 당신의 나이는 ~살입니다 출력
	 -->
	 <c:if test="${not empty param.age}">
	 	<h4 style="color : blue">당신의 나이는 ${param.age }살 입니다.</h4>
	 </c:if>
	 
	 <!-- 
	 	age가 있다면
	 	age값이 18보다 크면 많은 이용 부탁드립니다 - blue
	 	아니면 미성년자는 접근할 수 없습니다 - red
	  -->
	  
	  <c:if test="${param.age !=null }">
	  	<c:choose>
	  		<c:when test="${param.age>18 }">
	  			<h4 style="color : blue">많은 이용 부탁드립니다</h4>
	  		</c:when>
	  		
	  		<c:otherwise>
	  			<h4 style="color : red">미성년자는 접근할 수 없습니다</h4>
	  		</c:otherwise>
	  	</c:choose>
	  </c:if>
</body>
</html>