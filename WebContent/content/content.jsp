<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../jspf/SearchbarHeader.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1" >
<title>제목을넣으면되ㅎㅎ</title>

<style>
	body{height:1000px;font-family: 'Montserrat', sans-serif;}			
	#menuList{padding-top:10px;margin:0px auto;}
	.cate{margin-left:15px ; color:gray }
	#container a{text-decoration: none;}
	#dropdownMenuButton{float:right;width:100px}
	.card-text{margin:0px}
	.buyBtn{
		width:100px; importaint!;
	}
	/* 우측 상단 my profile 이미지 */
	#myInfo img{
		width:50px;
		height:50px;	
	}
	/* 검색결과없을때 폰트 */								/*  추가부분*/
	.display-5{
		font-size:1.5em;
	}
			/* 회사정보 */
	#companyInfoDiv{
		margin-top:100px;
		height:200px;		
	}
	#companyInfoDiv>div{		
		text-align:center;		
	} 
	#companyInfoDiv img{
		width:210px;
		height:70px;
	}
	/* popover */
	.setterMode{
		font-weight:bolder;
	}
		/*아콘표시  */
	#myAcorn img{
		width:20px;
		height:20px;
	}
	
	.card-title{
		height:50px;
		overflow:hidden;
	}
	</style>

</head>
<body>
<div id="container">
	
	<!-- menuList -->
	<div id="menuList" class="container row" >		
			<div class="col-8">
				 <script>
				 	var category = ["All","Bodybuild","Soccer","Climbing","Acting","Dancing","Art","Economy","Philosophy","History"];
				 	var txt ="<p>";
				 	for(var i=0;i<category.length;i++){
				 		txt += "<a href='<%=request.getContextPath()%>/content/content.do?interest="+category[i]+"'><span class='cate'"
				 			 if(category[i]=="${interest}"){
				 				txt += "style='font-weight:bold'";
				 			}
				 		
				 			
				 		txt += ">"+category[i]+"</span></a>"
				 	}
				 	txt +="</p>";
				 	document.getElementById("menuList").innerHTML = txt;
				 	
				 	
				 /* 	$(function(){
				 		$("#menuList a:nth-child(1)>span").css("font-weight","bold");
				 	});
				  */
				  
				  
				 </script>	
			 </div>	 
			 <!-- dropdown filter-->
			<div class="dropdown col-2" >
		 		 <button class="btn btn-primary dropdown-toggle btn-sm" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		   			 Sort By
		  		</button>
			  	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				    <a class="dropdown-item" href="#" id="hottest" onclick="clickHottest()">Hottest</a>
				    <a class="dropdown-item" href="#" id="lowPrice" onclick="clickLowPrice()">LowPrice</a>
				    <a class="dropdown-item" href="#" id="highPrice"onclick="clickHighPrice()">HighPrice</a>
				 </div>		  
			</div>

			
			   
	</div><!-- menuList -->
	<!-- 컨텐츠 -->
	<div id="result" class="container">
		<p></p>
	 	<div id="contents" class="container"> 	
		 
		 		
				
		 </div>
		
</div><!-- container -->
<script>	
		var searchedData =[] ;
		 <c:forEach var ="i" items="${list}">		 	
		 searchedData.push(
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
		 
		//hottest 
			
			function clickHottest(){
				for(var i=0;i<searchedData.length;i++){
					for(var j=0;j<searchedData.length;j++){
						if(searchedData[i][8]*1>searchedData[j][8]*1){
							var higherData = searchedData[j];
							searchedData[j] = searchedData[i];
							searchedData[i] = higherData;
						};
					};
				};						
				//콘텐츠 생성
				createContents();					
			}
			//low price
			function clickLowPrice(){
				for(var i=0;i<searchedData.length;i++){
					for(var j=0;j<searchedData.length;j++){
						if(searchedData[i][9]*1<searchedData[j][9]*1){
							var higherData = searchedData[j];
							searchedData[j] = searchedData[i];
							searchedData[i] = higherData;
						};
					};
				};		
				createContents();					
			}
			//high price
			function clickHighPrice(){
				for(var i=0;i<searchedData.length;i++){
					for(var j=0;j<searchedData.length;j++){
						if(searchedData[i][9]*1>searchedData[j][9]*1){
							var higherData = searchedData[j];
							searchedData[j] = searchedData[i];
							searchedData[i] = higherData;
						};
					};
				};
				createContents();					
			}
			function createContents(){
				var txt = "";
				for(var i=0;i<searchedData.length;i++){
					if(i%3==0){
						txt += "<div class='row'>"
					}
					txt += "<a href='<%=request.getContextPath()%>/intro/intro.do?introNo="+searchedData[i][0]+"'><div class='card col-3  m-3' style='width:18rem'><img src='data:image/jpeg;base64,"+searchedData[i][6]+"' class='card-img-top'/>"
					txt += "<div class='card-body'>";
					txt += "<h5 class='card-title'style='color:gray text-line:bold'>"+searchedData[i][7]+"</h5>";
					txt += "<p class= 'card-text' style='color:gray;'>"+"Setter : "+searchedData[i][1]+ "</p>";
					txt += "<p class='card-text'style='color:gray'>"+"Follower : " +searchedData[i][8]+"</p>";
					txt += "<p class='card-text'style='color:gray'>"+"Price : " +searchedData[i][9]+" Acorn</p>";
					txt += "<div class='d-flex justify-content-center mt-3'><a href='<%=request.getContextPath() %>/intro/buy.do?introNo="+searchedData[i][0]+"' class='btn btn-primary buyBtn'>Follow</a></div>"
					txt += "</div></div></a>";
					if(i%3==2){
						txt += "</div>"
					}
				}
				
				document.getElementById("contents").innerHTML = txt;	
			}
			createContents();
				//프로필 
				/* $(function(){
					var profile = localStorage.getItem("profile");
					$("#profile").attr('scr', profile);
				}); */
</script>
	</div>
	<!-- 회사정보 -->
<%@include file="../jspf/footer.jspf" %>
</body>
</html>