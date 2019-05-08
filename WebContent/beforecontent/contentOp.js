/**
 * 
 */
$(function(){
	$('#input_star .fa-star').on('click',function(){ //별점 기능 추가!
		var index = $('.fa-star').index(this);
		if(index==4){
			$('#input_star .start-coment').html(" 5.0");
			$('#input_star .fa-star').addClass('fas');
		}else if(index==3){
			$('#input_star .start-coment').html(" 4.0"); //emp:far ocu:fas
			if($('#input_star .fa-star').eq(3).hasClass('fas')){
				$('#input_star .fa-star').eq(4).removeClass('fas');
				$('#input_star .fa-star').eq(4).addClass('far');
			}
			else if($('#input_star .fa-star').eq(3).hasClass('far')){
				for(n=0;n<=3;n++){
					$('#input_star .fa-star').eq(n).removeClass('far');
					$('#input_star .fa-star').eq(n).addClass('fas');
					}
			}
		}else if(index==2){
			$('#input_star .start-coment').html(" 3.0");
			if($('#input_star .fa-star').eq(3).hasClass('fas')){
				for(n=3;n<=4;n++){
				$('#input_star .fa-star').eq(n).removeClass('fas');
				$('#input_star .fa-star').eq(n).addClass('far');
				}
			}
			else if($('#input_star .fa-star').eq(3).hasClass('far')){
				for(n=0;n<=2;n++){
					$('#input_star .fa-star').eq(n).removeClass('far');
					$('#input_star .fa-star').eq(n).addClass('fas');
					}
			}
		}else if(index==1){
			$('#input_star .start-coment').html(" 2.0");
			if($('#input_star .fa-star').eq(2).hasClass('fas')){
				for(n=2;n<=4;n++){
				$('#input_star .fa-star').eq(n).removeClass('fas');
				$('#input_star .fa-star').eq(n).addClass('far');
				}
			}
			else if($('#input_star .fa-star').eq(2).hasClass('far')){
				for(n=0;n<=1;n++){
					$('#input_star .fa-star').eq(n).removeClass('far');
					$('#input_star .fa-star').eq(n).addClass('fas');
					}
			}
		}else{
			$('#input_star .start-coment').html(" 1.0");
			if($('#input_star .fa-star').eq(1).hasClass('fas')){
				for(n=1;n<=4;n++){
				$('#input_star .fa-star').eq(n).removeClass('fas');
				$('#input_star .fa-star').eq(n).addClass('far');
				}
			}
		}
	});

	var mHeightVal = $('.media-head').innerHeight();
	var heightVal = $('.fnt-size-ins-content').innerHeight();
	$('.show-less-btn').on('click',function(){
		var txt = $('.show-less-btn').text();
		if(txt=='SHOW LESS'){
			$('.instructor-content').animate({height:'28%'});
			$('.media-head').animate({height:'28%'});
			$('.show-less-btn').text('SHOW MORE');
		}else if(txt=='SHOW MORE'){
			$('.instructor-content').animate({height:heightVal});
			$('.media-head').animate({height:mHeightVal});
			$('.show-less-btn').text('SHOW LESS');
		}
		
	});
	////////////////
	$('#logoDiv img').on('click',function(){
		url = "main.html";
		location.href=(url);
	});

	$('.col-sm-4 .media:eq(0)').on('click',function(){
		url = "contentOp_02.html";
		location.href=(url);
	});
	$('.col-sm-4 .media:eq(1)').on('click',function(){
		url = "contentOp_03.html";
		location.href=(url);
		//url = "main.html";
		//location.href=(url);
	});
	
	/*팝오버 실행*/
	  $('#myInfo').popover({
		  html : true,
		  content: function(){
			  return $("#myInfoPopover").html();
		  },
		  title : "My Info"		  
	  });
	//comment height
	  $('.wri-comment').on('keydown keyup', function(){
		  $(this).height(1).height($(this).prop('scrollHeight'));
		  $('.submit-btn').prop('disabled',false);
		  if($('.wri-comment').val()==""){
			  $('.submit-btn').prop('disabled',true);
		  }
	  });
	//comment btn
	  $('.reset-btn').on('click',function(){
		  $('.wri-btn').css('display','none');
	  });
	  $('.wri-comment').focus(function(){
		  $('.wri-btn').css('display','block');
		  $('.submit-btn').prop('disabled',true);
	  });
	//comment box
	  
	var pro=localStorage.getItem("profile");
	$(".avatar").attr('src', pro);
});