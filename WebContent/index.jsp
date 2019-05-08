<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file ="jspf/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Getter Setter</title>
<link rel="stylesheet" href="main.css"/>

</head>
<body>

<script>
	var recommendedData =[] ;
<c:forEach var ="i" items="${list}">
	
recommendedData.push(
				["${i.introNo}",
		"${i.userid}",
		"${i.filename}",
		"${i.interestStr}",
		"${i.description}",
		"${i.introdate}",
		"${i.thumbnail}",
		"${i.title}",
		"${i.follower}",
		"${i.price}"		
		])
	
</c:forEach>
</script>


<!-- 로그인 회원가입 ,로고 등등 들어갈 메뉴nav -->
	
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
					<h4 class="modal-title">welcome </h4>
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
	 <!-- 검색 기능이 들어갈 div -->
	<header>
		<div id="searchDiv" >
				<!-- padding용 -->
				<div></div>
				<!-- 검색창DIV -->
				<form method="get" action="<%=request.getContextPath()%>/content/content.do">
					<div id="searchInput">
						<input type="text" placeholder=" Input Keyword" id="searchBar" name="search"/>
						<input id="searchButton" type="submit" value="GET" class="btn btn-primary btn-sm"/>
					</div>
			</form>
			<!-- 컨텐츠 카테고리 div -->
			<div>
				<div id="categoryDiv" class="row justify-content-center">
					<!-- script에서 9개 카테고리 버튼생성 -->
				</div>
			</div>
		</div>
	</header>
	
	
	
	<!-- 추천콘텐츠 div  -->
	<div id="recomendedContentsDiv">
		<div><h4><b>Recomended Contents </b></h4></div>
		<hr/>
		<div id="recommendContents" class="row justify-content-around">
			
			
		</div>
	</div><!-- 추천콘텐츠 -->
	<!-- teacher모집 -->
	<div id="hireTeacherDiv">
		<h4><b>We HIRE Setters</b></h4>
		<hr/>
		<div class='row justify-content-around'>
			<div class='col-12 col-md-4 text-center h-100'>
				<div>
					<p>You can change to Setter mode on MyInfo. then you are the Setter!
				</div>
				<div>
				
				<a href="<%=request.getContextPath()%>/upload/setter.do" class="btn btn-outline-primary btn-sm">Change to Setter mode</a>
				
				</div>
			</div>
			
			<div class='col-12 col-md-4 text-center h-100'>
				<div>
					<p>Upload your valuable content! 
				</div>
				<div>
					<a href="upload/upload.jsp" class="btn btn-outline-primary btn-sm">Go to upload file</a>
				</div>
			</div>
			
			<div class='col-12 col-md-4 text-center h-100'>
				<div>
					<p>Setter can earn Acorn by purchaser. use your talent on GetterSetter! 
				</div>
				<div>
					<a href="<%=request.getContextPath()%>/signup/payment.do" class="btn btn-outline-primary btn-sm">Check my Acorn</a>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- manual -->
	<div id="manualDiv">
		<h4><b>How to use GetterSetter</b></h4>
		<hr/>
		<div class='row justify-content-around text-center'>
			<div class='col-11 col-md-4'>
				<div>
					<p>Easily you can search the contents what you want to watch via search bar and category and recommended contents
				</div>
				<div>
					<a href="#" class="btn btn-outline-primary btn-sm">Search</a>
				</div>
			</div>
			
			<div class='col-11 col-md-4'>
				<div>
					<p>You need to buy Acorn for watch contents. Before purchasing, you can check reviews from other users.
				</div>
				<div>
					<a href="<%=request.getContextPath()%>/signup/payment.do" class="btn btn-outline-primary btn-sm">Buy Acorn</a>
				</div>
			</div>
			
			<div class='col-11 col-md-4'>
				<div>
					<p>you can easily find content you Bought on My Info. <br/>Enjoy GetterSetter! 
				</div>
				<div>
					<a href="<%=request.getContextPath()%>/intro/intro.jsp" class="btn btn-outline-primary btn-sm">Go to My Info</a>
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- 회사 정보 -->
	<div id="footer" class="row align-items-center">
		<div class="col-12 col-md-2"></div>
		<div class="col-12 col-md-8" style="text-align:center">
			<hr/>
			<b>GetterSetter</b> Business No. : 428-34-23442<br/>
			Representative : An.SSam | Phone : 02-6453-5567
			<p><i>33, Siheung-daero 163-gil, Guro-gu, Seoul, Republic of Korea</i></p>
			<p><b><a href="#">Employment</a> | <a href="#">Information</a> | <a href="#">Application Download</a></b></p>
		</div>
		<div class="col-12 col-md-2"></div>
	</div>
	<!-- ASK US ICON -->
	<a href="https://open.kakao.com/o/szHAOecb">
	<div id="askUs">
		<img src="img/askUs.png"/>
	</div>
	</a>
</body>

	<script type="text/javascript" src="main.js"></script>
	<script>
		/* 카테고리 버튼생성하기 */
		function createCategoryButton(){
			var category=["Bodybuild", "Soccer", "Climbing", "Acting", "Dancing", "Art", "Economy", "Philosophy","History"];
			var txt =  "";			
			for(var i=0;i<category.length;i++){
				 txt += "<a href='<%=request.getContextPath()%>/content/content.do?interest="+category[i]+"' class='col-md-1'><div>"+category[i]+"</div></a>";		 
			}
			document.getElementById("categoryDiv").innerHTML=txt;
			
		}
		createCategoryButton();		
		
		//6개만 잘라내기	

		function createRecomendedContents(){			
			var txt="";			
			for(var i =0; i<6; i++){				
				txt +="<a href='<%=request.getContextPath()%>/intro/intro.do?introNo="+recommendedData[i][0]+"' class='col-6 col-sm-4 pb-4'><div class='card w-100'><img src='data:image/jpeg;base64,"+recommendedData[i][6]+"' class='card-img-top'>"
				txt +="<div class='card-body'><h4 class='card-title'>"+recommendedData[i][7]+"</h4><p class='card-text'>Setter : "+recommendedData[i][1]+"</p><p class='card-text'>Followers : "+recommendedData[i][8]+"</p><p class='card-text'>Price : "+recommendedData[i][9]+" Acorn</p></div></div></a>"	
			}
			document.getElementById("recommendContents").innerHTML=txt;	
		}
		createRecomendedContents();	
		
	</script>
</html>