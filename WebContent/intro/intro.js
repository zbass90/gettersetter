/**
 * 
 */

/*팝오버 실행*/
 $(function(){
	$("#clickLogo").on("click", function(){		
		location.href="main.html"
	});			

	var pro=localStorage.getItem("profile");
	$(".avatar").attr('src', pro);

	/*팝오버 실행*/

	  $('#myInfo').popover({
		  html : true,
		  content: function(){
			  return $("#myInfoPopover").html();
		  },
		  title : "My Info"		  
	  });
	  
	  /*별점 부여 기능*/
	  $('#input_star .fa-star').on('click',function(){ //별점 기능 추가!
			var index = $('#input_star .fa-star').index(this);
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
	  
});
