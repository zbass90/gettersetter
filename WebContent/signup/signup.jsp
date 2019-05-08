<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>회원가입-필수정보</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

<style>
	.container-fluid{max-width:100%}
	#row1{height:100px;border-bottom: 1px solid #D6D8DB ; }
	#profile{position:absolute; right:5%; top:20%;}
	#logo{position:absolute; left:0%; }
	body{font-family:'Montserrat', sans-serif;font-size:1.2em; }
	/* 여기까지가 상단 로고와 프로필 */
	.list-group{width:40%; height:auto; margin-left:30%}
	.list-group label{font-size:0.6em}
	#title, #title2{font-weight:bold ; font-size:45pt;  text-align:center; padding-top:2%  ;}
	#title3{font-size:45pt;  text-align:center; padding-top:2%; margin-left:13%}
	.list-group input{border-style:inset;background:white; border-radius: 13px}
	@media all and (min-width:320px) and (max-width:600px){#login{width:160px; margin-left:0%}#facebook>img, #naver>img, #kakao>img{width:30px; height:30px; margin-bottom:12px;border-radius: 50px}#facebook, #naver, #kakao{width:35px;height:50px;font-size:5px;border-radius: 50px}#title{font-weight:bold ; font-size:20pt;  text-align:center; padding-top:2%;color:#32C634 }}
	@media all and (min-width:601px) and (max-width:800px){#login{width:300px; margin-left:5%}#facebook>img, #naver>img, #kakao>img{width:50px; height:50px; margin-bottom:12px;border-radius: 50px}#facebook, #naver, #kakao{width:60px;height:40px;font-size:15px;border-radius: 50px}#title{font-weight:bold ; font-size:30pt;  text-align:center; padding-top:2%;color:#32C634  }}
	@media all and (min-width:801px){#login{width:100%; margin-top:5%; margin-left:0%}#facebook{background:#3C5A96; width:70px; height:70px; margin-right:4%;cursor:pointer;}#naver{background:#32C634; width:70px;  height:70px;margin-right:4%;cursor:pointer;}#kakao{background:#FEE934; width:70px; height:70px;cursor:pointer; }}
	
	/* 회사정보 */
	#companyInfoDiv{
		margin-top:100px;
		height:200px;	
		margin-bottom:50px;
	}
	#companyInfoDiv>div{		
		text-align:center;
	} 
	#companyInfoDiv img{
		width:210px;
		height:70px;
	}
</style>
<script>

function check(){
	var tel = $("#tel").val();
	var regTel = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
	var telresult =regTel.test(tel);
	//var totalCheck = true; // 최종 결과값 체크 
	if(telresult){
		$("#tellabel").text("Checked");
		$("#tellabel").css("color", "#32C634");
	}else{
		$("#tellabel").text("Check Your Tel Number please");
		$("#tellabel").css("color", "red");
		//totalCheck = false; 
	}
	
	var password = $("#userpwd").val();
	var regPass = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/; // 최소 8~20에 숫자, 문자, 특수문자 각각 1개 이상 포함
	var passresult = regPass.test(password);
	if(passresult){
		$("#pwlabel").text("Checked");
		$("#pwlabel").css("color", "#32C634");
	}else{
		$("#pwlabel").text("Please Insert English + Number + Mixture of Special Characters. Length of Text Must be 8 to 20 Characters." );
		$("#pwlabel").css("color", "red");
	}
	
	var passwordChk = $("#passwordChk").val();
	if(password==passwordChk){
		$("#pwclabel").text("Checked");
		$("#pwclabel").css("color", "#32C634");
	}else{
		$("#pwclabel").text("Please Insert Same Characters.");
		$("#pwclabel").css("color", "red");
	}
	
	var emailname = $("#email").val();
	var regEmail = /^\w{5,12}[@][a-zA-Z0-9]{2,10}[.][a-z]{2,3}([.]+[a-z]{2,3})?$/;
	var emailresult = regEmail.test(emailname);
	if(emailresult){
		$("#emaillabel").text("Checked")
		$("#emaillabel").css("color", "#32C634")
	}else{
		$("#emaillabel").text("Please Check Your E-mail Again")
		$("#emaillabel").css("color", "red")
	}
	
	var id = $("#userid").val();
	var regId = /^[a-zA-z]{1}\w{4,11}$/;
	var idresult = regId.test(id);
	if(idresult){
		$("#idlabel").text("")
	}else{
		$("#idlabel").text("Insert 5 to 11 Characters. Only English or English + Number.")
		$("#idlabel").css("color", "red")
	}
	var idChkresult = $("#idChkStatus").val();
	if(idresult==true && emailresult==true && passresult==true && telresult==true && password==passwordChk && idChkresult=="Y"){
		$("#idlabel").text("Check")
		$("#idlabel").css("color", "#32C634")
		return true;
	}else if($("#idChkStatus").val()=="N"){
		$("#chkModal").modal();
		return false;
	}else{
		return false;
	}
	
}
	
	
	
	function contactus(){
		$("#conModal").modal();
	}
	
	
	
</script>
</head>
<body>
<div class="container-fluid">
	<div class="row" id="row1" >
		<div class="col-sm-12">
			<img src="<%=request.getContextPath()%>/img/logo.jpg" style=width:300px;height:100px;cursor:pointer id="logo" onclick="location.href='<%=request.getContextPath()%>/index.do'">
		</div>
	</div>
	<!--  여기까지가 상단 로고와 프로필  -->
	
	<div class="row">
		<div id="title" class="col-sm-12">Welcome to GetterSetter!</div>
		<div id="title2"class="col-sm-12"><h3>PLEASE INSERT YOUR IMPERATIVE INFO</h3></div>
		<div id="title3"class="col-sm-12"><h5 style="padding-bottom:30px;border-bottom: 1px solid #D6D8DB;width:73% ">GET HELP WITH THIS FORM-<a onclick="contactus()" href="#">Contact Us</a></h5></div>
	</div>
	<div class="modal fade" id="conModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h6 class="modal-title">
						Representative: 010-2200-7646<br/>
						Tel: 02-333-3333<br/>
						E-mail: Gese@gmail.com<br/>
						<button class="btn" style="background:#0069D9;color:white" data-dismiss="modal">Close</button>
					</h6>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="chkModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h6 class="modal-title">
						Please Push Dobule-Check Button and Check your ID is Usable or Not.<br/>
						<button class="btn" style="background:#0069D9;color:white" data-dismiss="modal">Close</button>
					</h6>
				</div>
			</div>
		</div>
	</div>
	

	<form method="post" action="<%=request.getContextPath()%>/signup/signupOk.do" onsubmit="return check()" id="frm"> <!--  onsubmit="return check()" true나 false값을 받아와서 온서브밋은 트루여야 실행됨 -->
	<input type="hidden" name="idChkStatus" id="idChkStatus" value="N"/>
	<div class="list-group" style="margin-top:2%;font-weight:bold">
		<span>ID <input type="button" value="double-check" id="double-check" style="background:#0056B3;color:white;border-style:outset;font-size:15px;cursor:pointer;margin-bottom:5px"/><label id="idlabel" style="color: red; margin: 0; margin-left:50px; text-align: right;"></label></span><input type="text" class="list-group-item-secondary" placeholder="Insert ID" id="userid" name="userid">
		<span>PASSWORD<label id="pwlabel" style="color: red; margin: 0; margin-left:50px; text-align: right;"></label></span><input type="password" class="list-group-item-secondary"  placeholder="Insert Password" id="userpwd" name="userpwd">
		<span>PASSWORD-CHECK<label id="pwclabel" style="color: red; margin: 0; margin-left:50px; text-align: right;"></label></span><input type="password" class="list-group-item-secondary" placeholder="Insert Password Again" id="passwordChk" name="passwordChk">
		<span>E-MAIL<label id="emaillabel" style="color: red; margin: 0; margin-left:50px; text-align: right;"></label></span><input type="text" class="list-group-item-secondary" placeholder="Insert E-mail" id="email" name="email">
		<span>TEL<label id="tellabel" style="color: red; margin: 0; margin-left:50px; text-align: right;"></label></span><input type="text"class="list-group-item-secondary" placeholder="Insert Tel" id="tel" name="tel">
		<button class="btn btn-outline-primary" style="margin-top:20px;padding:20px 0;font-size:20pt;cursor:pointer;border-style:ouset;border-radius:20px;">◎ Next</button>
		 <!--폼안에 있는 버튼은 누르면 자동으로 submit이 된다.  버튼 타입=버튼으로 하면 폼안에 있어도 제출안됨 -->
			<div id="login" class=row>
				<div class="col-sm-12" style="position:relative">
					<a href="https://www.facebook.com/">
					<button type="button" id="facebook" class="btn rounded-circle" style=font-weight:bold; ><img src="<%=request.getContextPath()%>//img/facebook.jpg"/></button></a>
					<a href="https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com">
					<button type="button" id="naver"class="btn rounded-circle"  style=font-weight:bold><img src="<%=request.getContextPath()%>/img/naver.jpg"/></button></a>
					<a href="https://www.kakaocorp.com/service/KakaoTalk">
					<button type="button" id="kakao"class="btn rounded-circle"  style=font-weight:bold><img src="<%=request.getContextPath()%>/img/kakao.jpg"/></button></a>
				</div>
			</div>
	</div>
	</form>
	<!-- 회사 정보 -->
	<div id="footer" class="row align-items-center">
		<div class="col-12 col-md-2"></div>
		<div class="col-12 col-md-8" style="text-align:center;">
			<hr/>
			<b>GetterSetter </b><a style="font-size:9pt">Business No. : 428-34-23442<br/>
			Representative : An.SSam | Phone : 02-6453-5567
			<p><i>33, Siheung-daero 163-gil, Guro-gu, Seoul, Republic of Korea</i></p></a>
			<p><b><a href="#">Employment</a> | <a href="#">Information</a> | <a href="#">Application Download</a></b></p>
		</div>
		<div class="col-12 col-md-2"></div>
	</div>
	
</div>
</body>
<script>
$(function(){
	$("#double-check").on("click",function(){
		var id = $("#userid").val();
		var regId = /^[a-zA-z]{1}\w{4,11}$/;
		var idresult = regId.test(id);
		if(idresult){
			$("#idlabel").text("")
		}else{
			$("#idlabel").text("Insert 5 to 11 Characters. Only English or English + Number.")
			$("#idlabel").css("color", "red")
		}
		if(idresult){
		window.open("<%=request.getContextPath()%>/signup/idCheck.do?userid="+$("#userid").val(),"idCheck","width=500px, height=280px");
		}
	});
});
</script>
</html>

