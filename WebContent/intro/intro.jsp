<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../jspf/SearchbarHeader.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>Instructor Introduction</title>
<script type="" src="intro.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="intro.css" type="text/css"/>
</head>
<c:if test="${loginStatus==null }">
	<script>
		alert("you must login");
		location.href="<%=request.getContextPath()%>/index.do"
	</script>
</c:if>
<body>

<div class="container-fluid">
	<ul class="nav">
		<li class="nav-item">
			<a class="nav-link nav-link-pri active" href="#cou">Course Introduction</a>
		</li>
		<li class="nav-item">
			<a class="nav-link nav-link-pri" href="#cur">Curriculum</a>
		</li>
		<li class="nav-item">
			<a class="nav-link nav-link-pri" href="#eva">Instructor Evaluation</a>
		</li>
	</ul>
	<div style="border:0.5px solid #eee;position:absolute;margin-left:-15px;width:100%"></div>
	<div style="width:50%; margin:30px auto 0 auto;">
		<div class="embed-responsive embed-responsive-16by9" id="cou">
			<iframe class="embed-responsive-item" src="getIntro/${introVO.filename }"></iframe>			
		</div><br/> <!-- 해당 INTRO 의 VO 는 = introVO 로 부르면됨!! -->
		
		<div>
		<form action="<%=request.getContextPath() %>/intro/buy.do" method="get" onsubmit="return confirm('do you really want to follow?')">
			<input type="hidden" name="introNo" value="${introVO.introNo }"/>
			<input type="submit" class="btn btn-primary" value="Follow Now"/>
		</form>
		</div>
		<h2>Instructor name <span style="font-weight:bold;font-size:0.7em;margin-right:10px;float:right;"> ${introVO.userid}</span></h2><hr/>
		<br/><h4>Instructor Introduction Content</h4><br/>
		<p>${introVO.description}</p>
		<br/><h4>instructor career</h4><br/>
		<ul>
			<li>Bivaripublica, Server Developer</li>
			<li>bluenight, CTO (2016-2017)</li>
			<li>Data Square, CEO / Developer / Joint Establishment (2011-2016)</li>
			<li>Like the handsome lion, the operating / teacher / founding member (2014-2016)</li>
			<li>IT Instructors such as Ajou University, KT&G, etc. (2014-2016)</li>
			<li>MERSMAP Development (Five million net visitors)</li>
			<li>IEEE Best-Poster Award for International Studies</li>
			<li>Microsoft Korea Cloud Competition Silver Award</li>
			<li>Korea Talent Award</li>			
		</ul>
		<h4 id="cur">Curriculum</h4><hr/>
		<c:if test="${cnt>0}">
		<div>		
			<ul>
				<li class="row"><h5 class="col-sm-2"><label>Interest</label></h5><h5 class="col-sm-8"><label>Title</label></h5><h5 class="col-sm-2"><label>RunningTime</label></h5></li>
			</ul>
			<c:forEach var="contentVO" items="${cList }">
			<ul>
				<li class="row"><label class="col-sm-2">${contentVO.interest }</label><a class="col-sm-8 content_linked" href="javascript:location.href='${ctx}content/contentView.do?contentNo=${contentVO.contentNo}&userid=${contentVO.userid}&interest=${contentVO.interest }'" >${contentVO.title}</a> <label class="col-sm-2">${contentVO.videoLengthStr }</label></li>
			</ul>
		</c:forEach>
		</div>	
		</c:if>
		<c:if test="${cnt==0}">
		<div style="display:none">		
			<ul>
				<li class="row"><h5 class="col-sm-2"><label>Interest</label></h5><h5 class="col-sm-8"><label>Title</label></h5><h5 class="col-sm-2"><label>RunningTime</label></h5></li>
			</ul>
			<c:forEach var="contentVO" items="${cList }">
				<ul>
					<li class="row"><label class="col-sm-2">${contentVO.interest }</label><a class="col-sm-8 content_linked" href="javascript:location.href='${ctx}content/contentView.do?contentNo=${contentVO.contentNo}&userid=${contentVO.userid}&interest=${contentVO.interest }'">${contentVO.title}</a> <label class="col-sm-2">${contentVO.videoLengthStr }</label></li>
				</ul>
			</c:forEach>
		</div>	
		</c:if>		
		<h4 id="eva">Instructor Evaluation</h4><hr/><br/>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-2" style="text-align:center;">
				<span style="font-size:4em;font-weight:bold;">
				<c:choose>
					<c:when test="${listSize>0}">
					<fmt:formatNumber value="${introVO.totalStar/listSize}" pattern="#.#"/>
					</c:when>
					<c:when test="${listSize<=0}">0</c:when>
				</c:choose>
				</span>				
				<br/>
				 <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i>
			</div>
			<div class="col-sm-5">
				<div class="container" style="margin-top:3px">
					<div class="progress" style="height:20px;margin-bottom:10px">
						<div class="progress-bar" style="width:${(starRateVO.fiveStar/listSize)*100}%"></div>
					</div>
					<div class="progress" style="height:20px;margin-bottom:10px">
						<div class="progress-bar" style="width:${(starRateVO.fourStar/listSize)*100}%"></div><br/>					
					</div>					
					<div class="progress" style="height:20px;margin-bottom:10px">
						<div class="progress-bar" style="width:${(starRateVO.threeStar/listSize)*100}%"></div><br/>
					</div>
					<div class="progress" style="height:20px;margin-bottom:10px">
						<div class="progress-bar" style="width:${(starRateVO.twoStar/listSize)*100}%"></div><br/>
					</div>
					<div class="progress" style="height:20px;margin-bottom:10px">
						<div class="progress-bar" style="width:${(starRateVO.oneStar/listSize)*100}%"></div>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				 <div style="margin-bottom:6px"><i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <span style="margin-left:10px">
				 <c:choose>
				 	<c:when test="${listSize>0}">
						 <fmt:formatNumber value="${(starRateVO.fiveStar/listSize)*1}" pattern="#,###%"/>
				 	</c:when>
				 	<c:when test="${listSize<=0}">
						 <fmt:formatNumber value="0" type="percent"/>
				 	</c:when>
				 </c:choose>
				 </span></div>
				 <div style="margin-bottom:6px"><i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px">
				 <c:choose>
				 	<c:when test="${listSize>0}">
						 <fmt:formatNumber value="${(starRateVO.fourStar/listSize)*1}" pattern="#,###%"/>
				 	</c:when>
				 	<c:when test="${listSize<=0}">
						 <fmt:formatNumber value="0" type="percent"/>
				 	</c:when>
				 </c:choose>
				 </span></div>
				 <div style="margin-bottom:6px"><i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px">
				 <c:choose>
				 	<c:when test="${listSize>0}">
						 <fmt:formatNumber value="${(starRateVO.threeStar/listSize)*1}" pattern="#,###%"/>
				 	</c:when>
				 	<c:when test="${listSize<=0}">
						 <fmt:formatNumber value="0" type="percent"/>
				 	</c:when>
				 </c:choose>
				 </span></div>
				 <div style="margin-bottom:6px"><i class="fas fa-star"></i> <i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px">
				 <c:choose>
				 	<c:when test="${listSize>0}">
						 <fmt:formatNumber value="${(starRateVO.twoStar/listSize)*1}" pattern="#,###%"/>
				 	</c:when>
				 	<c:when test="${listSize<=0}">
						 <fmt:formatNumber value="0" type="percent"/>
				 	</c:when>
				 </c:choose>
				 </span></div>
				 <div><i class="fas fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <i class="far fa-star"></i> <span style="margin-left:10px">
				 <c:choose>
				 	<c:when test="${listSize>0}">
						 <fmt:formatNumber value="${(starRateVO.oneStar/listSize)*1}" type="percent"/>
				 	</c:when>
				 	<c:when test="${listSize<=0}">
						 <fmt:formatNumber value="0" type="percent"/>
				 	</c:when>
				 </c:choose></span></div>
			</div>
			<div class="col-sm-1"></div>
		</div><br/><br/>
		
		<!-- 댓글 --> 
		<h4 id="review">Review </h4><hr/>
		<div class="row">			
			<form method="get" action="replyWrite.do" id="comment"class="col-12">
				<c:forEach var="vo" items="${list}">
					<div class="col-12 row">
						<p class="col-2">${vo.commenter }</p>
						<p class="col-6">${vo.commentContent }</p>
						<p class="col-2">${vo.commentDate}</p>
						<span class="col-2">
							<c:choose>
								<c:when test="${vo.star==5}"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></c:when>
								<c:when test="${vo.star==4}"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i></c:when>
								<c:when test="${vo.star==3}"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></c:when>
								<c:when test="${vo.star==2}"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></c:when>
								<c:when test="${vo.star==1}"><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></c:when>
							</c:choose>
						<span>${vo.star }</span></span>
					</div>
				</c:forEach>
				<div class="col-12 row">
					<p class="col-2">${userid }</p>
					<input class="col-6" type="text" name="commentContent"/>
					<input class="col-2" type="submit"/>
					<div class="col-2" id="input_star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><span class="start-coment" id="select_star">5.0</span></div><br/>
					<input type="hidden" name="star" id="star"/>
					<script>
						$(function(){
							$("#comment").on("submit",function(){
								var selectStar = $("#select_star").text();
								$("#star").val(selectStar);
							});
						});
					</script>
					<input type="hidden" name="commenter" value="${userid}"/>
					<input type="hidden" name="introNo" value="${introVO.introNo}"/>	
					<input type="hidden" name="contentid" value="${introVO.userid}"/>			
				</div>
			</form>
				
		</div>
		
	</div>
</div>
</body>
<%@ include file="/jspf/footer.jspf" %>
</html>