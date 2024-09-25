<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    //1. 기존 count 값을 읽어온다. (application영역에 저장된...)
    Integer count = (Integer)application.getAttribute("count");
	Boolean visit = (Boolean)session.getAttribute("visit");
   
    //2. 만약 1의 값이 null이라면 기본 0으로 세팅(저장)!!!
    if(count==null){
	    count=0;
    }
   
    //3. 읽어온 데이터에 +1을 해서 다시 저장하고 화면에 출력한다.
    if(visit==null || !visit){//java.lang.NullPointerException: Cannot invoke "java.lang.Boolean.booleanValue()" because "visit" is null
    	count += 1;
        application.setAttribute("count", count);
        session.setAttribute("visit", true);
    }
    
    
 %>


<h3>방문자 수 : <%= count%> 명</h3>


</body>
</html>