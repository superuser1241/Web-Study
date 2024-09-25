<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		//전송된 job이 있으면 select 박스 선택
		//alert("${param.job}")
		if("${param.job}" !== ""){
			$("[name=job]").val("${param.job}");
		}
		
	})
</script>
</head>
<body>
	<h3>&lt;c:choose> TEST</h3>
	
	<form action="ex04_choose.jsp" method="get">
		이름 : <input type="text" name="name" value="${param.name }"><br>
		선택 :
			<select name="job">
				<option value="0">--선택--</option>
				<option value="개발자">개발자</option>
				<option value="디자이너">디자이너</option>
				<option value="DBA">DBA</option>
				<option value="기획자">기획자</option>
			</select>
			
			<input type="submit" value="전송">
	</form>
	
	<!--
		1. 만약 name하고 job이 전송된다면 ~~님 직업은 ~~입니다
		2. job의 종류에 따라 메세지를 출력
			ex)개발자 : 멋진 개발자
		3. 값이 전송되었다면 
			전송된 값으로 폼에 출력한다
	 -->
	 
	 <c:if test="${not empty param.job and not empty param.name}">
        <h4>${param.name}님의 직업은 ${param.job}입니다</h4>
        
        <c:choose>
	 		<c:when test="${param.job=='개발자' }">
	 			<h4>멋진 ${param.job }</h4>
	 		</c:when>
	 		
	 		<c:when test="${param.job=='디자이너' }">
	 			<h4>깔끔한 ${param.job }</h4>
	 		</c:when>
	 		
	 		<c:when test="${param.job=='DBA' }">
	 			<h4>엄청난 ${param.job }</h4>
	 		</c:when>
	 		
	 		<c:when test="${param.job=='기획자' }">
	 			<h4>머리좋은 ${param.job }</h4>
	 		</c:when>
	 		<c:otherwise>--직업없음--</c:otherwise>
	 	</c:choose>
    </c:if>
	 
	 
	 
	 
	 
</body>
</html>