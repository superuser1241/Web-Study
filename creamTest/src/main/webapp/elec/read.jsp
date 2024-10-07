<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<jsp:include page="../common/header.jsp"/>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT language=javascript>
function sendUpdate(){
	document.requestForm.methodName.value ="updateForm";
	document.requestForm.submit();
}



function sendDelete(){
	if(document.requestForm.password.value==""){
		alert("비밀번호 입력하세요.");
		document.requestForm.password.focus();
		return;
	}
	
	document.requestForm.methodName.value ="delete";
	document.requestForm.submit();
}
</script>


</HEAD>

<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>
             게시물 자세히보기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">모델번호</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${elec.modelNum}</b></span>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="right"><b><span style="font-size:9pt;">등록일</span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${requestScope.elec.writeday}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="right"><b><span style="font-size:9pt;">조회수</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${requestScope.elec.readnum}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">모델이름</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${requestScope.elec.modelName}</b></span>
        </td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p align="right"><b><span style="font-size:9pt;">설명</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span style="font-size:9pt;"><b><pre>${requestScope.elec.description}</pre></b></span></td>
    </tr>
    
      <c:if test="${elec.fname!=null}">
       <tr>
        <td width="100" height="20">
            <p align="right"><b><span style="font-size:9pt;">다운로드</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='${path}/downLoad?fname=${elec.fname}'>
    			${elec.fname} 
      		</a>
      		  ( <fmt:formatNumber value="${elec.fsize}"/> byte)
        </b></span>
        </td> 
    </tr>
    </c:if>
    
    <tr>
    <td width="100" height="20">
           <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        
    <form name="requestForm" method=post action="${path}/front">
        <td height="20" colspan="3" align="left" valign="middle">
				<input type=password name="password" value="">		
		</td>
    </tr>
    
    
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="modelNum" value="${elec.modelNum}">
				<input type=hidden name="key" value="elec">
				<input type=hidden name="methodName" >
				<input type=hidden name="pageNo" value="${pageNo}" >
				
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
    </form>
			
		</td>
    </tr>
</table>
<hr>
 <h4> 댓글정보 LIST </h4>
 <c:choose>
   <c:when test="${empty elec.repliesList}">
        댓글정보가 없습니다.
   </c:when>
   <c:otherwise>
       <c:forEach items="${elec.repliesList}" var="reply">
          ${reply.replyNum} / ${reply.replyContent} / ${reply.replyRegdate}<br>
       </c:forEach>
   </c:otherwise>
 </c:choose>



<div align=right>
<span style="font-size:9pt;">
	<a href="${path}/front">리스트로 돌아가기-첫번째</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${path}/front?pageNo=${pageNo}">리스트로 돌아가기-원래위치</a>
</span>
</div>

<jsp:include page="../common/footer.jsp"/>






