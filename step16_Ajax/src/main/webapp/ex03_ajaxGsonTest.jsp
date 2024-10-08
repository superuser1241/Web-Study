<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script type="text/javascript">
  $(function(){
	  $("#ajaxBtn").click(function(){
		  $.ajax({
				url: "${pageContext.request.contextPath}/ajax?key=text", //통신할 서버 주소
				type: "post", //요청방식(GET, POST , PUT, DELETE, PETCH)
				dataType: "text", //서버가 응답해주는 데이터 타입(text, html, xml, json)
				//data: "name=영준&id=Young", //서버에게 전송할 데이터(param정보)
				//data: {name: "나영", id: "king"},
				//data: {name: $("#name").val(), id: $("#id").val() }
				//data: $("#f").serialize(),
				//여기서는 데이터 넘기는게 없기 때문에 data는 필요없음
				success: function(result) {
					console.log(result);
				}, //성공했을 때 콜백함수
				error: function(err) {
					console.log(err);
				}//실패했을 때 콜백함수
			});
	  });//클릭End
	  //////////////////////////////////////
	  $("#jsonBtn").click(function(){
		  $.ajax({
				url: "${pageContext.request.contextPath}/ajax?key=json", //통신할 서버 주소
				type: "post", //요청방식(GET, POST , PUT, DELETE, PETCH)
				dataType: "json", //서버가 응답해주는 데이터 타입(text, html, xml, json)
				//data: "name=영준&id=Young", //서버에게 전송할 데이터(param정보)
				//data: {name: "나영", id: "king"},
				//data: {name: $("#name").val(), id: $("#id").val() }
				//data: $("#f").serialize(),
				//여기서는 데이터 넘기는게 없기 때문에 data는 필요없음
				success: function(result) {
					let str="";
					$.each(result, function(index,menu){
						//console.log(menu);
						str+=`<input type='checkbox' value='${"${index}"}'>${"${menu}"}`;
					});
					
					$("#display").html(str);
					
				}, //성공했을 때 콜백함수
				error: function(err) {
					console.log(err);
				}//실패했을 때 콜백함수
			});
	  });//클릭End
	  ////////////////////////////////////////////////////
	  $("#dtoBtn").click(function(){
		  $.ajax({
				url: "${pageContext.request.contextPath}/ajax?key=dto", //통신할 서버 주소
				type: "post", //요청방식(GET, POST , PUT, DELETE, PETCH)
				dataType: "json", //서버가 응답해주는 데이터 타입(text, html, xml, json)
				//data: "name=영준&id=Young", //서버에게 전송할 데이터(param정보)
				//data: {name: "나영", id: "king"},
				//data: {name: $("#name").val(), id: $("#id").val() }
				//data: $("#f").serialize(),
				//여기서는 데이터 넘기는게 없기 때문에 data는 필요없음
				success: function(result) {
					let str = result.id + " | " +result.name + " | " +result.addr + " | " + result.age;
					$("#display").html(str);
				}, //성공했을 때 콜백함수
				error: function(err) {
					console.log(err);
				}//실패했을 때 콜백함수
			});
	  });//클릭End
	  //////////////////////////////////////////////////////
	  $("#listBtn").click(function(){
		  $.ajax({
				url: "${pageContext.request.contextPath}/ajax?key=list", //통신할 서버 주소
				type: "post", //요청방식(GET, POST , PUT, DELETE, PETCH)
				dataType: "json", //서버가 응답해주는 데이터 타입(text, html, xml, json)
				//data: "name=영준&id=Young", //서버에게 전송할 데이터(param정보)
				//data: {name: "나영", id: "king"},
				//data: {name: $("#name").val(), id: $("#id").val() }
				//data: $("#f").serialize(),
				//여기서는 데이터 넘기는게 없기 때문에 data는 필요없음
				success: function(result) {
					console.log(result);
					$.each(result.memberList, function(index,member){
						console.log(member.name);
					});
				}, //성공했을 때 콜백함수
				error: function(err) {
					console.log(err);
				}//실패했을 때 콜백함수
			});
	  });//클릭End
	  
	  //////////////////////////////////////
	 
	  $("#mapBtn").click(function(){
		  $.ajax({
				url: "${pageContext.request.contextPath}/ajax?key=map", //통신할 서버 주소
				type: "post", //요청방식(GET, POST , PUT, DELETE, PETCH)
				dataType: "json", //서버가 응답해주는 데이터 타입(text, html, xml, json)
				//data: "name=영준&id=Young", //서버에게 전송할 데이터(param정보)
				//data: {name: "나영", id: "king"},
				//data: {name: $("#name").val(), id: $("#id").val() }
				//data: $("#f").serialize(),
				//여기서는 데이터 넘기는게 없기 때문에 data는 필요없음
				success: function(result) {
					console.log(result);
				}, //성공했을 때 콜백함수
				error: function(err) {
					console.log(err);
				}//실패했을 때 콜백함수
			});
	  });//클릭End
	  ///////////////////////////////////////////
	  $("#textJsonBtn").click(function(){
		 
	  });//클릭End
	  
  })//readyEnd
</script>
</head>
<body>


<input type="button" value="text결과" id="ajaxBtn">
<input type="button" value="json결과" id="jsonBtn">

<input type="button" value="DTO결과" id="dtoBtn">
<input type="button" value="List결과" id="listBtn">
<input type="button" value="Map결과" id="mapBtn">

<input type="button" value="textJson결과" id="textJsonBtn">

<hr>
<div id="display"></div>









</body>
</html>













