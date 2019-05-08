<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>회원가입-추가정보</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<style>
	.container-fluid{max-width:100%}
	#row1{height:100px;border-bottom: 1px solid #D6D8DB  }
	#logo{position:absolute; left:0%; }
	body{font-family:'Montserrat', sans-serif;font-size:1.2em; }
	
	.list-group{width:70%; height:auto; margin-left:30%}
	
	.proFrm{
		position:relative;
		width:100%;
	}
	#proImgUpload{
		position: absolute;
		left:-9999px;
	}
	.proImg{
		width:130px;
		height:130px;
		cursor:pointer;
	}
	#proImgBtn{
		position: relative;
		width:70px;
		height:35px;
		line-height:1;
		margin-top:5px;
		cursor:pointer;
		font-size:0.9em;
		margin-left:30px;
	}
	#title{margin-top:5%;  }
	#sport, #arts, #humanities{margin-top:2%;}
	#div1{float:left;background:white; width:35%; text-align:center; height:200px; padding:2% 0px 3% 0px; border-radius: 10px; margin-top:10px;cursor:pointer;background:#eee}
	#div2{float:left;background:white; width:35%; text-align:center; height:200px; padding:2% 0px 3% 0px; border-radius: 10px; margin-top:10px;margin-left:20px;cursor:pointer;background:#eee}
	#div2 li{padding:9px}
	div[class*="dropdown-menu btn"]{background:#BEDFFA}
	#div2 li div:nth-of-type(2n+1){color:white}
	#list1, #list2, #list3{display:none}
	#join{margin-top:3%; margin-left:30%; width:120px; padding:20px 10px 20px 10px; font-size:0.9em; }
	#warning img{width:30px; margin-top:2%;margin-right:5%}
	.result{font-size:10pt}
	/* 회사정보 */
	#companyInfoDiv{
		margin-top:100px;
		height:200px;
		margin-bottom:50px		
	}
	#companyInfoDiv>div{		
		text-align:center;		
	} 
	#companyInfoDiv img{
		width:210px;
		height:70px;
	}
	#badge{font-size:10pt;color:gray}
	
</style>

</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/signup/signup2Ok.do" enctype="multipart/form-data" class="form-horizontal">
<input type="file" id="proImgUpload" name="userImage" class="text-enter center-block file-upload hidden"/>
<div class="container-fluid">
	<div class="row" id="row1" >
		<div class="col-sm-12">
		<img src="<%=request.getContextPath()%>/img/logo.jpg" style=width:300px;height:100px;cursor:pointer id="logo" onclick="location.href='<%=request.getContextPath()%>/index.do'">
		</div>
	</div>
	<div class="list-group" style="margin-top:2%;font-weight:bold;">
		<div id="text"><h3 style="font-weight:bold;font-style:Consolas">PLEASE INSERT YOUR ADDITIONAL INFO</h3><br/><h6 style="padding-bottom:30px;border-bottom: 1px solid #D6D8DB;width:73% ;font-style:Consolas;font-weight:bold">Need help?<a onclick="contactus()" href="#" style="font-weight:bold;"> Contact Us</a></h6></div>
		<!-- 모달페이지 -->
		<div id="conModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h6 class="modal-title">
						Representative: 010-2200-7646<br/>
						Tel: 02-333-3333<br/>
						E-mail: Gese@gmail.com<br/>
						<button type="button" class="btn" style="background:#0069D9;color:white" data-dismiss="modal">Close</button>
						</h6>
						</div>
						
					</div>
				</div>
		</div>	
		<div id="ageModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h5 class="modal-title">
						Insert Your Age Please<br/>
						<button type="button" class="btn" style="background:#0069D9;color:white" data-dismiss="modal">Close</button>
						</h5>
						</div>
						
					</div>
				</div>
		</div>	
		<div id="ageModal2" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h5 class="modal-title">
						Please Insert Number(0~120)Only<br/>
						<button type="button" class="btn" style="background:#0069D9;color:white" data-dismiss="modal">Close</button>
						</h5>
						</div>
						
					</div>
				</div>
		</div>	
		<div id="overlapModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h5 class="modal-title">
						Please Select Different Interest <br/>
						<button type="button" class="btn" style="background:#0069D9;color:white" data-dismiss="modal">Close</button>
						</h5>
						</div>
						
					</div>
				</div>
		</div>	
		<div id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
						<h4 class="modal-title">Come In! Let's Start! We Expect Your Fantastic Activities!</h4>
						</div>
						<div class="modal-body" style="background:#0069D9;color:white;cursor:pointer" onclick="location.href='<%=request.getContextPath()%>/index.do'">Go to Main</div>
						<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>	
		<!-- 모달페이지끝 -->
		
		<div class="row">
			<div class="col-sm-12">
				<input type="radio" name="gender" value="남" id="radio1" checked/><span>Male</span>
				<input type="radio" name="gender" value="여" id="radio2"/><span>Female</span>
			</div>
		</div>
		<div style="margin-top:50px">Age<input type="text" id="age" name="age" class="list-group-item-secondary" placeholder=" Insert Age" style=margin-left:30px;border:inset;border-radius:13px;background:white></div>
		

		<div style="margin-top:50px">Profile Picture</div>
			<div class="text-center proFrm" id="formDiv">
				<div id=malpung style="max-width:100%">
				<img src="<%=request.getContextPath()%>/img/profile.jpg" class="proImg img-thumbnail img-fluid rounded-circle file-upload avatar" alt="avatar"style="float:left;max-width:130px;max-height:"/>
				<div id="badge"  style="float:left;width:40%;height:130px;background:#EEE;text-align:center;margin-left:30px" ><br/><a style="color:red">Warning!</a><br/>If you upload improper photo,<br/> you may be restricted in your activities.<br/><div id=warning><img src="<%=request.getContextPath()%>/img/sexual.png" class="rounded-circle"><img src="<%=request.getContextPath()%>/img/violence.png" class="rounded-circle"><img src="<%=request.getContextPath()%>/img/horrible.png" class="rounded-circle"></div> </div>
				</div>
				 
			</div>
				<button type=button id="proImgBtn"class="proImg btn btn-primary" data-toggle="tooltip" data-placement="bottom" title="Photo Size=170*170">Add</button>
			
			<div id=title>Select your main area of Interest up to 3</div> 
			
			<div id=divtotal><!-- 관심분야설정 start-->
				<div id=div1 > <!-- 관심분야 선택영역 -->
					<div class="btn-group" id="sport"> <!-- 관심분야설정 -->
						<div class="btn dropdown-toggle result" data-toggle="dropdown" style="background:#00069C;color:white">SPORTS</div>
						<div class="dropdown-menu btn" style="background:#4EA8D8">
						<a class="dropdown-item" id="bodybuild1" >BODYBUILD</a>
						<a class="dropdown-item" id="soccer1">SOCCER</a>
						<a href="#" class="dropdown-item" id="climbing1">CLIMBING</a>
						</div>
					</div><br/>
					<div class="btn-group" id="arts"><!-- 관심분야설정 -->
						<div class="btn dropdown-toggle result" data-toggle="dropdown"style="background:#00764B;color:white" >ARTS</div>
							<div class="dropdown-menu btn" style="background:#91D94F">
							<a href="#" class="dropdown-item" id="acting2">ACTING</a>
							<a href="#" class="dropdown-item" id="dancing2">DANCING</a>
							<a href="#" class="dropdown-item" id="art2">ART</a>
							</div>
					</div><br/>	
					<div class="btn-group" id="humanities"><!-- 관심분야설정 -->
						<div class="btn dropdown-toggle result" data-toggle="dropdown"style="background:#2F2F2F;color:white" >HUMANITIES</div>
							<div class="dropdown-menu btn" style="background:#D6D8DB">
							<a href="#" class="dropdown-item" id="economy3">ECONOMY</a>
							<a href="#" class="dropdown-item" id="philosophy3">PHILOSOPHY</a>
							<a href="#" class="dropdown-item" id="history3">HISTORY</a>
							</div>
					</div>	
				</div>	
				<div id="div2"> <!-- 관심분야 결과영역 -->
					<ul>

						<li id=list1><div id ="list1btn1" class="btn result" ></div><div class="btn result" id="list1btn2" name="list1btn2" style="background:white;"></div><button type="button" class="btn btn-danger dbutton result" id="delete1">X</button></li>
						<li id=list2><div id ="list2btn1" class="btn result" ></div><div class="btn result" id="list2btn2" name="list2btn2" style="background:white;"></div><button type="button" class="btn btn-danger dbutton result" id="delete2">X</button></li>
						<li id=list3><div id ="list3btn1" class="btn result" ></div><div class="btn result" id="list3btn2" name="list3btn2"style="background:white;"></div><button type="button" class="btn btn-danger dbutton result" id="delete3">X</button></li>

						
					</ul>
				</div>
				
				
			</div><!-- 관심분야설정 end -->
			
			<input type="submit" class="btn btn-outline-primary" id="join" value="◎JOIN US" />

	</div><!-- list-group end -->
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
	

</body>
<script>
var interestArr = [];

$(function(){
    sessionStorage.setItem("profile",$('.avatar').attr('src')); // 기본이미지를 세션에 저장 (변경 안할경우 x박스 방지를 위해서)
	// var readURL = function(input) //프로필 이미지 input 경로 변경
	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.readAsDataURL(input.files[0]); // 파일을 DataURL형식으로 변환 -> onload 동작인듯 input.files[0]이function (e) e로
            
            reader.onload = function (e) { // 파일이 load되야 동작하는 함수 부분인듯 load된 파일정보를 e에 담아서 사용  
                $('.avatar').attr('src', e.target.result);
                var sessionImg = e.target.result; // 객체 통째로 
                //alert(JSON.stringify(sessionImg));
                sessionStorage.setItem("profile", sessionImg); // 세션에 profile이라는 이름으로 sessionImg 저장 (profile = sessionImg)
            }
        }	
    }
	$(".file-upload").on('change', function(){ // 파일 change 동작시  
        readURL(this);
    });
	$('.proImg').on('click', function() {
        $('#proImgUpload').click(); // 파일 탐색기 실행 
    });

	
	$(".dropdown-item").on('click', function(){
		var id = $(this).attr("id");
		var type = id.substr(id.length-1,1); // id가 soccer1 => '1'
		id = id.substr(0, id.length-1); // id가 soccer1 => 'soccer'
		var big;
		var bc;
		var list1val;
		var list2val;
		var list3val;
		if($("#list1").css("display")=="block"){
			list1val = $("#list1btn2").text();
		}
		if($("#list2").css("display")=="block"){
			list2val = $("#list2btn2").text();
		}
		if($("#list3").css("display")=="block"){
			list3val = $("#list3btn2").text();
		}
		
		if((list1val == id.toUpperCase()|| list2val == id.toUpperCase()|| list3val == id.toUpperCase())){
			$("#overlapModal").modal();
			return; // 중복체크 이 시점에서 함수 종료  $(".dropdown-item").on('click', function(){}) 에 해당하는 함수부분. 이 아래 함수부분은 실행 안됨.
		}
		
		
		if(type == '1'){
			big = "SPORTS";
			bc = "#00069C";
		}else if(type == '2'){
			big = "ARTS";
			bc = "#00764B";
		}
		else if(type == '3'){
			big = "HUMANITIES";
			bc = "#2F2F2F";
		}
		
		
		interestArr.push(id);
		
		if($("#list1").css("display")=="none"){
			
			$("#list1btn1").text(big);
			$("#list1btn1").css("background",bc);
			$("#list1btn2").text(id.toUpperCase());
			$("#list1").css("display", "block")
			
		}else if($("#list2").css("display")=="none"){
			$("#list2btn1").text(big);
			$("#list2btn1").css("background",bc);
			$("#list2btn2").text(id.toUpperCase());
			$("#list2").css("display", "block");
			}
		else if($("#list3").css("display")=="none"){
			$("#list3btn1").text(big);
			$("#list3btn1").css("background",bc);
			$("#list3btn2").text(id.toUpperCase());
			$("#list3").css("display", "block");
			}
		
		
		});
});
	$(".dbutton").on('click', function(){
		var id = $(this).attr("id");
		var type = id.substr(id.length-1,1); // id가 delete2 => '2'		
		id = id.substr(0, id.length-1); //soccer1->soccer
		
		var index = interestArr.indexOf(id);
		interestArr.splice(index,1);
		
		if(type == '1'){
			$("#list1").css("display","none");
			
		}else if(type == '2'){			
			$("#list2").css("display","none");
		}
		else if(type == '3'){
			$("#list3").css("display","none");
		}
		
	}); 
	
	
	//관심사 선택end
	
	$("#join").on('click', function(){
		
		//배열값으로 파라미터 전송
		var str ="";
		$.map(interestArr,function(a){
			str += "<input type='hidden' name='interest' value='"+a+"'/>"
		});
		document.getElementById("formDiv").innerHTML += str;	
		
	
	var age= $("#age").val();
	var regAge = /^(?:\b|-)([1-9]{1,2}[0]?|100)\b$/; //숫자 1~100 만 넣을 수 있음
	
	var list1btn1 = $("#list1btn1").text()
	var list1btn2 = $("#list1btn2").text()
	sessionStorage.setItem("concern1",  list1btn1+"-"+list1btn2);
	var list2btn1 = $("#list2btn1").text()
	var list2btn2 = $("#list2btn2").text()
	sessionStorage.setItem("concern2", list2btn1+"-"+list2btn2);
	var list3btn1 = $("#list3btn1").text()
	var list3btn2 = $("#list3btn2").text()
	sessionStorage.setItem("concern3", list3btn1+"-"+list3btn2);
	sessionStorage.setItem("age", $("#age").val());
	
	});
	function contactus(){
		$("#conModal").modal();
	}
	
	function main(){
		$("#myModal").modal();
	}
	

</script>

<style>
	@media all and (min-width:300px) and (max-width:600px){#badge{font-size:1pt;}.avatar{width:90px;height:auto;}#text{color:#32C634}#text h3{font-size:15pt}#text h5{font-size:10pt}.dropdown-toggle{font-size:8pt}.result{font-size:8pt}#div1{width:100%}#div2{width:100%;margin-left:0px}}
	@media all and (min-width:601px) and (max-width:900px){#badge{font-size:6pt;}.avatar{width:120px;height:auto;}#text{color:#32C634}#text h3{font-size:17pt}#text h5{font-size:12pt}.dropdown-toggle{font-size:10pt}.result{font-size:10pt}#div1{width:100%}#div2{width:100%;margin-left:0px}}
	@media all and (min-width:901px) and (max-width:1300px){#div1{width:100%;margin-left:0px}#div2{width:100%;margin-left:0px}}
</style>
</html>
<c:if test="${cnt>0}">
	<script>
		$("#myModal").modal();
		
	</script>
</c:if>	
