<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ include file="/jspf/SearchbarHeader.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Getter Setter Payment</title>

<style>
	/* body{font-size:0.9em; margin:8px 8px} */
/* 	#nameTag{width:100%}
	#nameTag>a>img{width:300px; height:100px}/* logo */ 
	#myInfo img{width:50px; height:50px;}
	/* .nav-link{color:black; font-family: 'Montserrat', sans-serif;}
	.nav-link:hover{font-weight:bolder;} */
	
	#acorn{width:100%; height:430px; background:#eee; padding:20px 20px}
	#purchase{width:100%; background:lightgray; padding:10px 0px; font-family: 'Montserrat', sans-serif;}
	#purchase>div:first-child{margin-left:20px;}
	#purchase>div>b>input[type=radio]{margin:3px 3px 3px 20px}
	#purchase>div>b>input[type=radio]:nth-child(6){display:none}
	#acornTxt{width:50px; margin-left:20px}
	#preview{position:relative; margin:0px auto; left:10px; color:white}
	
	#payment{font-family: 'Montserrat', sans-serif;}
	#payment>b>input[type="radio"]{margin:13px 3px 3px 20px}
	
	#total{width:420px; background:white; height:140px; margin:20px 0px 10px 10px;}
	#total>div:first-child{border-bottom:1px solid lightgray; padding:5px 10px 0px 10px}
	#total>div:nth-child(2){text-align:center}
	#buyAcorn{font-size:40px; width:150px; height:50px; line-height:50px; margin-top:20px; border:none; text-align:center;}
	#buyBtn{height:40px; position:relative; left:10px; top:120px}
	
	#aCorns img{
		width:20px;
		height:20px;
	}
</style>
<script>
	
	$(function(){
	/* 	$("#acornTxt").on("click focus",function(){
			$("#purchase>div>input[type=radio]:nth-child(6)").first().trigger("click");
		}); */
		$("#purchase>div>b>input[type=radio]:first-child").click(function(){
			$("#preview").html("5acorns x 3dollor = 15dollors");
			$("#buyAcorn").val("15");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(2)").click(function(){
			$("#preview").html("10acorns x 3dollor = 30dollors");
			$("#buyAcorn").val("30");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(3)").click(function(){
			$("#preview").html("30acorns x 3dollor = 90dollors");
			$("#buyAcorn").val("90");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(4)").click(function(){
			$("#preview").html("50acorns x 3dollor = 150dollors");
			$("#buyAcorn").val("150");
		});
		$("#purchase>div>b>input[type=radio]:nth-child(5)").click(function(){
			$("#preview").html("100acorns x 3dollor = 300dollors");
			$("#buyAcorn").val("300");
		});
		$("#acornTxt").keyup(function(){
			var num = $("#acornTxt").val();
			$("#preview").html(num+"acorns x 3dollor = "+num*3+"dollors");
			$("#buyAcorn").val(""+num*3);
			
			var reg = /[0-9]{1,5}/;
			var result = reg.test(num);
			if (!result){
				$("#acornTxt").val('');
				//$("#total>div:nth-child(2)").html("<input type=label name='buyAcron' id='buyAcorn' value='0'>");
			}
			
			
		});
		//아콘숫자
		var aCornsNum =0;
		$("#buyBtn").on("click",function(){			
			var t1 = $("#acornNum").text();
			var t2 = t1.substring(1);
			aCornsNum += parseInt(t2); 
			localStorage.setItem("acornNum",aCornsNum);
			$("#aCorns p").html(localStorage.getItem("acornNum"));
		});
	});	

</script>
</head>
<body>

	<!-- 로그인기능모달 -->
	<!-- login form  -->
	<form action="<%=request.getContextPath()%>/loginOk.do" method="post">
			
	<div id="loginModal" class="modal fade" role="dialog">
				<!-- 가운데로옴 -->
		<div class="modal-dialog" role="document">
						<!-- modal이 흰색바탕됨 -->
						
			<div class="modal-content">
				<!-- header -->
				<div class="modal-header">
					<h4 class="modal-title">welcome</h4>
					<button class="close" data-dismiss="modal">&times;</button>
				</div>
				
				<div class="modal-body">
					<div class="row m-2">
						<p class="col-4"><b>ID</b></p>
						<input type="text" name="userid" class="col-8" id="id"/>
					</div>
					<div class="row m-2">
						<p class="col-4"><b>Password</b></p>
						<input type="password" name="userpwd" class="col-8" id="pw"/>
					</div>
					<div class="row m-2">
					</div>						
				</div>				
				<div class="modal-footer">
					<input type="submit" value="login" class="close" id="loginBtn"></button>
				</div>				
			</div>
		</div>
	</div>
	</form>	

	
		<div class="row">
			<div class="col-xl-2"></div>
			<div class="col-xl-8">
				<div id="acorn" class="container"> 
					<div><h3><b>Purchase</b></h3></div>
					<div id="purchase">
						<div><h4><b>acorn</b></h4></div>
						<div><b>
							<input type="radio" name="acorn" clicked>5acorns
							<input type="radio" name="acorn">10acorns
							<input type="radio" name="acorn">30acorns
							<input type="radio" name="acorn">50acorns
							<input type="radio" name="acorn">100acorns
							
							<input type="text" maxlength="5" name="acorn" id="acornTxt" value=0> acorns  
							<label id="preview">5acorns x 3dollor = 15dollors</label>
						</b></div>
					</div>
					<div>
						<hr/>
						<div><h5><b>payment</b></h5></div>
						<div id="payment"><b>
							<input type="radio" name="payment" checked> Credit Card
							<input type="radio" name="payment"> Phone
							<input type="radio" name="payment"> kakao Bank
							<input type="radio" name="payment"> Toss
						</b></div>
					</div>
					<form method="get" action="paymentOk.do" >
						<div class="row">
							<div id="total" class="col-lg-6">
								<div><h5>TOTAL</h5></div>
								<div>
									<input type="label" id="buyAcorn" name="buyAcorn" value="15"/>
									<span style="font-size:20pt">$</span>									
								</div>
								
							</div>
							<!--  <a href="paymentOk.html" class="btn btn-primary col-lg-1 btn-sm" id="buyBtn">BUY</a>-->
							<input type="submit" value="BUY" class="btn btn-primary col-lg-1 btn-sm" id="buyBtn"/>
						</div>
					</form>	
					
				</div>
			</div>
			<div class="col-xl-2"></div>
		</div>

	
	
</body>
<!-- 회사 정보 -->
<%@ include file="/jspf/footer.jspf" %>

</html>