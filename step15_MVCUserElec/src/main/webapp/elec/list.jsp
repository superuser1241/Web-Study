
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

\${pageContext.request.contextPath} = ${pageContext.request.contextPath} <br>
\${path} : ${path}





<link rel="stylesheet" href="${path}/css/style.css">
<style>
@import url("https://fonts.googleapis.com/css?family=Roboto:400,300");

body {
	color: #2c3e50;
	font-family: 'Roboto', sans-serif;
	font-weight: 400;
}

h1 {
	text-align: center;
	font-size: 2.5rem;
	font-weight: 300;
}

.pagination-container {
	margin: 100px auto;
	text-align: center;
}

.pagination {
	position: relative;
}

.pagination a {
	position: relative;
	display: inline-block;
	color: #2c3e50;
	text-decoration: none;
	font-size: 1.2rem;
	padding: 8px 16px 10px;
}

.pagination a:before {
	z-index: -1;
	position: absolute;
	height: 100%;
	width: 100%;
	content: "";
	top: 0;
	left: 0;
	background-color: #2c3e50;
	border-radius: 24px;
	-webkit-transform: scale(0);
	transform: scale(0);
	transition: all 0.2s;
}

.pagination a:hover, .pagination a .pagination-active {
	color: #fff;
}

.pagination a:hover:before, .pagination a .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination .pagination-active {
	color: #fff;
}

.pagination .pagination-active:before {
	-webkit-transform: scale(1);
	transform: scale(1);
}

.pagination-newer {
	margin-right: 50px;
}

.pagination-older {
	margin-left: 50px;
}

img {
	width: 200px;
	height: 350px
}

table td {
	text-align: center;
}
img{width:200px; height:350px}
</style>

<jsp:include page="../common/header.jsp"/>



<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption><h2 align="center">상품(Electronic) LIST</h2></caption>
	<colgroup>
		<col width="15%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">모델번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">모델이름</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">가격</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">날짜</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">첨부파일</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">파일용량</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">조 회 수</span></b></font></p>
        </td>
    </tr>
    
    <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="elecDto">
		    <tr onmouseover="this.style.background='#eaeaea'"
		        onmouseout="this.style.background='white'">
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${elecDto.modelNum}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="${path}/front?key=elec&methodName=selectByModelNum&modelNum=${elecDto.modelNum}&pageNo=${pageNo}">
					  ${elecDto.modelName}
					</a>
					</span></p>
		        </td>
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${elecDto.price}"/></span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${elecDto.writeday}</span></p>
		        </td>
		         
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${elecDto.fname}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            <fmt:formatNumber value="${elecDto.fsize}"/> byte</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${elecDto.readnum}</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="${path}/elec/write.jsp">글쓰기</a>&gt;</span>
</div>
<hr color="red">

  <%--  <jsp:useBean class="web.mvc.paging.PageCnt" id="p"/> 
   
   \${p.pageCnt} = ${p.pageCnt} / \${p.blockcount}   = ${p.blockcount}  <p> --%>

 
 
 <!--  블럭당  -->
 <%-- <nav class="pagination-container">
		<div class="pagination">
		<c:set var="doneLoop" value="false"/>
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2   , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
		
	\${pageNo} = ${pageNo} , 	\${temp}=${temp}  ,   \${startPage}=${startPage}  , <br>
		 
		  <c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
		      <a class="pagination-newer" href="${path}/front?key=elec&methodName=select&pageNo=${startPage-1}">PREV</a>
		  </c:if>
		
				<span class="pagination-inner"> 
				  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
					  <c:if test="${(i-1)>=p.pageCnt}">
					       <c:set var="doneLoop" value="true"/>
					    </c:if> 
					  <c:if test="${not doneLoop}" >
					         <a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=elec&methodName=select&pageNo=${i}">${i}</a> 
					  </c:if>
				</c:forEach>
				</span> 
				
				 <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
				     <a class="pagination-older" href="${path}/front?key=elec&methodName=select&pageNo=${startPage+p.blockcount}">NEXT</a>
				 </c:if>
		
		</div>
	</nav>  --%>

 
<jsp:include page="../common/footer.jsp"/>






























