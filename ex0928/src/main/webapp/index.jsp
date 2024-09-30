<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table {width: 800px; height: 600px; border:1px solid gray; border-collapse: collapse; }
  td{border: 1px gray solid; text-align: center;}
  table tr:first-child { height: 100px}
  table tr:last-child{ height: 70px}
  iframe {width: 100%; height: 430px; border: none}
  h3{background-color: orange}
  
  table tr:nth-child(2) > td:nth-child(1){
   width:200px;
}
</style>
</head>
<body>

<table>
  <tr>
    <td colspan="2"><jsp:include page="top.jsp"/> </td>
  </tr>
  <tr>
    <td><iframe src="left.jsp" name="left"></iframe> </td>
    <td><iframe src="center.jsp" name="center"></iframe> </td>
  </tr>
  <tr>
    <td colspan="2"><jsp:include page="footer.jsp"/></td>
  </tr>
</table>


</body>
</html>