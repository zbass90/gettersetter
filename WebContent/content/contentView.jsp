<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../jspf/SearchbarHeader.jspf"%>
<link rel="stylesheet" href="contentView.css" type="text/css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<script>
	$(function(){
		$('.fa-star').on('click',function(){ //별점 기능 추가!
			var index = $('.fa-star').index(this);
			if(index==4){
				$('.start-coment').html(" 5.0");
				$('.fa-star').addClass('fas');
			}else if(index==3){
				$('.start-coment').html(" 4.0"); //emp:far ocu:fas
				if($('.fa-star').eq(3).hasClass('fas')){
					$('.fa-star').eq(4).removeClass('fas');
					$('.fa-star').eq(4).addClass('far');
				}
				else if($('.fa-star').eq(3).hasClass('far')){
					for(n=0;n<=3;n++){
						$('.fa-star').eq(n).removeClass('far');
						$('.fa-star').eq(n).addClass('fas');
						}
				}
			}else if(index==2){
				$('.start-coment').html(" 3.0");
				if($('.fa-star').eq(3).hasClass('fas')){
					for(n=3;n<=4;n++){
					$('.fa-star').eq(n).removeClass('fas');
					$('.fa-star').eq(n).addClass('far');
					}
				}
				else if($('.fa-star').eq(3).hasClass('far')){
					for(n=0;n<=2;n++){
						$('.fa-star').eq(n).removeClass('far');
						$('.fa-star').eq(n).addClass('fas');
						}
				}
			}else if(index==1){
				$('.start-coment').html(" 2.0");
				if($('.fa-star').eq(2).hasClass('fas')){
					for(n=2;n<=4;n++){
					$('.fa-star').eq(n).removeClass('fas');
					$('.fa-star').eq(n).addClass('far');
					}
				}
				else if($('.fa-star').eq(2).hasClass('far')){
					for(n=0;n<=1;n++){
						$('.fa-star').eq(n).removeClass('far');
						$('.fa-star').eq(n).addClass('fas');
						}
				}
			}else{
				$('.start-coment').html(" 1.0");
				if($('.fa-star').eq(1).hasClass('fas')){
					for(n=1;n<=4;n++){
					$('.fa-star').eq(n).removeClass('fas');
					$('.fa-star').eq(n).addClass('far');
					}
				}
			}
		});
	});
</script>
<title>${contentVO.title }</title>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-8" id="left"> <!-- left -->
			<div class="embed-responsive embed-responsive-16by9"><!-- 동영상 출력 -->
				<iframe class="embed-responsive-item" src="<c:url value='getContent/video/${contentVO.filename }'/>"></iframe> <!-- https://www.youtube.com/embed/l49aooJqlwA -->
			</div> <!-- 동영상 출력 -->
			<div class="media-head">
				<div class="media-title fnt-size-head row"><b class="col-sm-12">${contentVO.title }</b></div>
				<div class="container">
					<div class="media-details row">
						<div class="col-sm-12">${contentVO.views }<label>views</label></div><hr/>
					</div>
				</div><div style="border:0.2px solid lightgray; margin-top:5px; margin-bottom:5px"></div>
				<div class="row editor">
					<div class="col-sm-2">
						<img src="data:image/jpeg;base64,${contentVO.thumbnail }" class="ins-avatar rounded-circle"/>
					</div>
					<div class="col-sm-10">
						<div class="ins-content"><b class="fnt-size-title instructor">${contentVO.userid }</b><br/><span class="fnt-size-content ins-date">Published on ${contentVO.uploadDate }</span>
						</div>
					</div>
				</div>				
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="instructor-content col-sm-10"><p class="fnt-size-ins-content">${contentVO.description }</p></div>					
				</div>
			</div><hr/>		
		</div><!-- left -->
		<div class="col-sm-4"> <!-- right -->
			<div id="next"><b class="fnt-size-title">Up Next</b></div>
			<c:forEach var="iList" items="${interestList }">
			<div class="media"> <!-- media (1) -->
				<div class="media-left">
					<a class="next_link" href="javascript:location.href='${ctx }content/contentView.do?contentNo=${iList.contentNo}&userid=${iList.userid}&interest=${iList.interest }'"><img class="media-object thumbnail-img" src="data:image/jpeg;base64,${iList.thumbnail }"/></a>
				</div>
				<div class="media-body">
					<div class="media-heading">
						<a class="next_link" href="javascript:location.href='${ctx }content/contentView.do?contentNo=${iList.contentNo}&userid=${iList.userid}&interest=${iList.interest }'"><b class="fnt-size-title">${iList.title }</b></a>
					</div>
						<a class="next_link" href="javascript:location.href='${ctx }content/contentView.do?contentNo=${iList.contentNo}&userid=${iList.userid}&interest=${iList.interest }'">
						<span class="fnt-size-content">Instructor : ${iList.userid }</span><br/>
						<span class="fnt-size-content"><i class="fas fa-users fa-xs"></i> ${iList.views }</span>
						</a>
				</div>
			</div> <!-- media(1) -->
			</c:forEach>
		</div><!-- right -->
	</div> <!-- container-fluid->row -->
</div> <!-- container-fluid -->
</body>
<%@ include file="../jspf/footer.jspf"%>