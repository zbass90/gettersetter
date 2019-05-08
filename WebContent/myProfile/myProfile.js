var interestArr = [];
$(function(){
		/*$('[data-toggle="tooltip"]').tooltip(); //툴 팁 경로 설정
		var pro=localStorage.getItem("profile");
		$(".avatar").attr('src', pro);
		
		var readURL = function(input) { //프로필 이미지 input 경로 변경
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();

	            reader.onload = function (e) {
	                $('.avatar').attr('src', e.target.result);
	                //localStorage.setItem("profile",e.target.result);
	            }
	    
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
		$(".file-upload").on('change', function(){
	        readURL(this);
	        $("#apply").css("display", "block")
	        alert("d")
	    });
		$('.proImg').on('click', function() {
			alert("g")
	       $('#proImgUpload').click();
		});
		$('#proImgBtn').on('click', function() {
			alert("d")
			$('#proImgUpload').click();
	    }); 바로바로 안먹어서 myProfile.jsp에 옮김*/
		$(".media").mouseenter(function(){
			var clock = $(this).children('.media-left').children('.media-clock');
			var close = $(this).children('.media-body').children('.media-heading').children('.media-close');
			$(clock).attr('style','display:block');
			$(close).attr('style','display:block');
		}).mouseleave(function(){
			var clock = $(this).children('.media-left').children('.media-clock');
			var close = $(this).children('.media-body').children('.media-heading').children('.media-close');
			$(clock).attr('style','display:none');
			$(close).attr('style','display:none');
		});
		$(".media-clock").on('click',function(){
			$(".nav-tabs a[href='#wishList']").tab("show");
			var addMedia = $(this).parent().parent();
			$("#wishList").append(addMedia);
			$('[data-toggle="tooltip"], .tooltip').tooltip("hide");
			$("#empty_message").remove();
			$(this).remove();
			$("#history:empty").html("<div class=fnt-size-content-empty id='empty_message'>This list has no videos.</div>");
			//var d = $(".media").next().val();
		});
		$(".media-close").on('click',function(){
			var close = $(this).children('.media-body').children('.media-heading').children('.media-close');
			var addMedia = $(this).parent().parent().parent();
			$('[data-toggle="tooltip"], .tooltip').tooltip("hide");
			$(addMedia).remove();
			$("#wishList:empty").html("<div class=fnt-size-content-empty id='empty_message'>This list has no videos.</div>");
			$("#history:empty").html("<div class=fnt-size-content-empty id='empty_message'>This list has no videos.</div>");
			
		});
		$("#wishList:empty").html("<div class=fnt-size-content-empty id='empty_message'>This list has no videos.</div>");
		
		

		/*팝오버 실행*/
		  $('#myInfo').popover({
			  html : true,
			  content: function(){
				  return $("#myInfoPopover").html();
			  },
			  title : "My Info"		  
		  });
		//프로필부분 ============================================================
		 // var con1 =localStorage.getItem("concern1");
		 // var con2 =localStorage.getItem("concern2");
		 // var con3 =localStorage.getItem("concern3");
		  
		 // $("#ConDiv").append(con1+", ");
		 // $("#ConDiv").append(con2+", ");
		 // $("#ConDiv").append(con3);
		  $("#changeBtn1").on("click", function(){
			  $("#changeBtn1").css("display", "none");
			  $("#c1").css("display", "block");
		  })
		  $("#changeBtn2").on("click", function(){
			  $("#changeBtn2").css("display", "none");
			  $("#c2").css("display", "block");
		  })
		  $("#changeBtn3").on("click", function(){
			  $("#changeBtn3").css("display", "none");
			  $("#c3").css("display", "block");
			  
		  })
		  $("#changeBtn4").on("click", function(){
			  $("#total").css("display", "block");
		  })
		  $("#cha11").on("click", function(){
			  alert("Your Password is Changed successfully");
			 // localStorage.setItem("pw", ("#pwCheck").val());
		  });
		  $("#chaB").on("click", function(){
			   var telcha = $("#telCha").val();
			  // localStorage.setItem("tel", telcha);
			   $("#telDiv").text(telcha);
			  // alert("Your tel is changed successfully")
			   
			   alert("Your TelNum is Changed successfully");
		  })
		   $("#chaC").on("click", function(){
			   var mailcha = $("#mailCha").val();
			  // localStorage.setItem("mail", mailcha);
			   $("#mailDiv").text(mailcha)
			   alert("Your e-mail is changed successfully")
		  })
		  $("#closeBtn").on("click", function(){
			  $("#total").css("display", "none")
			  
			  	var list1btn1 = $("#list1btn1").text()
				var list1btn2 = $("#list1btn2").text()
				//localStorage.setItem("concernA",  list1btn1+"-"+list1btn2);
				var list2btn1 = $("#list2btn1").text()
				var list2btn2 = $("#list2btn2").text()
				//localStorage.setItem("concernB", list2btn1+"-"+list2btn2);
				var list3btn1 = $("#list3btn1").text()
				var list3btn2 = $("#list3btn2").text()
				//localStorage.setItem("concernC", list3btn1+"-"+list3btn2);
				//var conA =localStorage.getItem("concernA");
				// var conB =localStorage.getItem("concernB");
				// var conC =localStorage.getItem("concernC");
				//  $("#ConDiv").text(conA+", ");
				//  $("#ConDiv").append(conB+", ");
				//  $("#ConDiv").append(conC);
		  })
		  // 관심사 선택start 
		  
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
			$(".dbutton").on('click', function(){
				var id = $(this).attr("id");
				var type = id.substr(id.length-1,1); // id가 delete2 => '2'
				
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
			
			//관심사 선택end=======================================================================
		  
			  
});