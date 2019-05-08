<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<script>
	$(function(){
		$("#USETHISID").on("click",function(){
			//회원가입 폼에 아이디 셋팅   window.open()하는 창은 부모창 opener.documetn.getElementById("")는 자식창으로 부모창의 변수를 불러온다.
			opener.document.getElementById("userid").value = $("#chkId").text(); //signup.jsp 의 밸류값변경
			opener.document.getElementById("idChkStatus").value = "Y";
			//현재창 닫기
			self.close(); //window.close();   
		});
	
		
	});

	function check(){
	var id = $("#userid").val();
	var regId = /^[a-zA-z]{1}\w{4,11}$/;
	var idresult = regId.test(id);
		if(idresult){
			
			return true;
		}else{
			$("#usable").css("display", "none");
			$("#unusable").css("display", "none");
			$("#label").css("display", "block");
			$("#label").text("[" +id+ "] is not usable. Insert 5 to 11 Characters. Only English or English + Number.");
			return false;
		}
	}
</script>
</head>
<body style="font-size:20px;font-weight:bold">
	<div class="container">
		<div class="col-sm-12">
			<img src="<%=request.getContextPath()%>/img/logobig.png" style=width:110px;height:50px;cursor:pointer;margin-left:155px id="logo" onclick="location.href='<%=request.getContextPath()%>/index.do'">
		</div>
		<hr/>
		Insert ID and Push double-check Button.<br/>
		<form method="post" action="<%=request.getContextPath()%>/signup/idCheck.do" >
			ID: <input type="text" name="userid" id="userid" style="border-radius:15px"/>
			    <input type="submit" value="Double-Check" id="doublechk" onclick="return check();" style="background:#0056B3;color:white;border-style:outset;border-radius:15px;font-size:20px;cursor:pointer;margin-top:15px"/> <!-- 서브밋버튼 -->
		</form>
		<hr/>
		<c:if test="${cnt>0}"><!-- 사용 불가능한 아이디 일때 -->
		<div id=unusable><span style="color:red;font-size:25px;" id="chkId"><del>${userid}</del></span> has already been Taken.</div>
			
		</c:if>
		
		<c:if test="${cnt<=0}"><!-- 사용 가능한 아이디 일때 -->
			<div id=usable><span style="color:blue;font-size:25px" id="chkId">${userid}</span> is Usable ID
			<input type="button" value="USE THIS ID" id="USETHISID" style="background:#0056B3;color:white;border-style:outset;border-radius:15px;font-size:20px;cursor:pointer"/>
			</div>
		</c:if>
		
		<lable id=label style="display:none; color:red"></lable>
		
		<hr/>
	</div>
</body>
</html>
