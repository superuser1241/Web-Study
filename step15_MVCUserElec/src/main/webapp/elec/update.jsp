<%@ page info="게시판 수정하기" contentType="text/html;charset=UTF-8" %>
<jsp:include page="../common/header.jsp"/>

<HTML>
<HEAD>
<link rel="stylesheet" href="css/style.css">

<SCRIPT >
function checkValid() {
	var f = window.document.updateForm;
	if ( f.modelName.value == "" ) {
		alert( "모델이름을 입력해 주세요." );
		f.modelName.focus();
		return false;
	}
	if ( f.price.value == "" ) {
		alert( "가격을 입력해 주세요." );
		f.price.focus();
		return false;
	}
	if ( f.description.value == "" ) {
        alert( "상품 설명을 입력해 주세요." );
        f.description.focus();
        return false;
    }
	if ( f.password.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.password.focus();
        return false;
    }
	
    
}

</SCRIPT>

</HEAD>

<BODY>


<form name=updateForm method=post action="${path}/front" onSubmit="return checkValid()">
    <input type="hidden" name="key" value="elec" >
    <input type="hidden" name="methodName" value="update" >
    <input type='hidden' name='modelNum' value="${elec.modelNum}">
    <input type='hidden' name='pageNo' value="${pageNo}">
    
	<table align="center" cellpadding="5" cellspacing="1" width="600" border="1">
    <tr>
        <td width="1220" height="20" colspan="2" bgcolor="#00cc00">
            <p align="center"><font color="white" size="3"><b>  게시물 수정하기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">모델이름</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;">
		<input type=text name="modelName" size="30"
		 value="${elec.modelName}"></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20">
            <p align="right"><b><span style="font-size:9pt;">가격</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<input type=text name="price" size="30"
		 value="${elec.price}"></span></b></td>
    </tr>
    
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
        <td width="450" height="20" ><b><span style="font-size:9pt;">
		<textarea name="description" cols="50" rows="10">${elec.description}</textarea></span></b></td>
    </tr>
    <tr>
        <td width="150" height="20" >
            <p align="right"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        <td width="450" height="20"><b><span style="font-size:9pt;"><input type=password name="password" size="12"> 
            (비밀번호가 맞아야 수정이 가능합니다.)</span></b></td>
    </tr>
    <tr>
        <td width="450" height="20" colspan="2" align="center"><b><span style="font-size:9pt;">
		<input type="submit" value="수정하기"> <input type="reset" value="다시쓰기"></span></b></td>
    </tr>
</table>
</form>
<hr>
<div align=right><span style="font-size:9pt;">&lt;<a href="${path}/front">리스트로 돌아가기</a>&gt;</span></div>
<jsp:include page="../common/footer.jsp"/>







