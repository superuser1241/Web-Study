<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<h3>&lt;c:forEach> TEST</h3>
<c:forEach begin="1" end="10" var="i" step="2">
	${i},
</c:forEach>

<hr>
<jsp:useBean id="bean" class="ex0925_el.ForEachBean"></jsp:useBean>
${bean.names}<br>
${bean.menus}<br>
${bean.boardList}<br>
${bean.map}<hr>

<!-- 이름은 checkbox 출력-->
<fieldset>
<legend>이름</legend>
	<c:forEach items="${bean.names }" var="name" varStatus="state">
		<input type="checkbox" name="name" value="${state.index }">${name }
	</c:forEach>
</fieldset>

<!-- 메뉴는 select 출력 -->
<fieldset>
<legend>메뉴</legend>
<select>
		<c:forEach items="${bean.menus }" var="menu" varStatus="state">
			<option>${menu}</option>
		</c:forEach>
	</select>
</fieldset>

<!-- 보드는 테이블 -->
<fieldset>
<table>
	<c:forEach items="${bean.boardList}" var="board" varStatus="state">
		<tr>
			<td>${board.no }</td>
			<td>${board.subject }</td>
			<td>${board.content }</td>
		</tr>
	</c:forEach>
</table>
</fieldset>

<!-- map radio 출력 -->
<fieldset>
<legend>map</legend>
	<c:forEach items="${bean.map }" var="nation" varStatus="state">
		<input type="radio" value="${nation.value }">${nation.key }
	</c:forEach>
</fieldset>

<hr>
가격 : 1567879456원 /
<fmt:formatNumber value="1567879456"/>원
</body>
</html>