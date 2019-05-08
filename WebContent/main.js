
	$("#pw").on("keydown",function(key){
		if(key.keyCode ==13){			
			$("#loginBtn").click();			
			/*//인풋값 초기화
			$("#id , #pw").val("");
			$("#loginModal").modal("toggle");*/
		};			
	});
	
	$(document).on("click","#logOut",function(){
		localStorage.setItem("loginMode","guest");
		$("#myInfo").popover("hide")
		checkLogin();
	});
	$(document).on("click","#setterMode",function(){
		localStorage.setItem("loginMode","setter");
		checkLogin();
	});
	$(document).on("click",".getterMode",function(){
		localStorage.setItem("loginMode","getter");
		checkLogin();
	});
	
	//로그인 여부를 체크하여 상단메뉴 노출을 지정해줌
/*function checkLogin(){
	if(${cnt}!=1){
		$("#login").css("display","block");
		$("#signUp").css("display","block");
		$("#myAcorn img").css("display","none");
		$("#myInfo img").css("display","none");
		var pro = localStorage.getItem("profile");
		$("#profile").attr('src', pro);		
	}else if(${cnt}==1){
		$("#login").css("display","none");
		$("#signUp").css("display","none");
		$("#myAcorn img").css("display","block");
		$("#myInfo img").css("display","flex");
		var pro = localStorage.getItem("profile");
		$("#profile").attr('src', pro);
		 $("#myAcorn p").html(localStorage.getItem("acornNum"));
		$('#myInfo').popover('enable')
	}
		
	
	
}	*/
	/*팝오버 실행*/
	  $('#myInfo').popover({
		  html : true,
		  content: function(){
			  return $("#myInfoPopover").html();
		  },
		  title : "My Info"		  
	  });
	  
	  //ask us position
	  var windowWidth;
	  var windowHeight;
	  function moveAskUs(){		  
		  windowWidth = window.innerWidth;
		  windowHeight = window.innerHeight;		  
		  $("#askUs").css("top",windowHeight-150+"px");
		  $("#askUs").css("left",windowWidth-150+"px");
		
		  window.addEventListener('resize',function(){
			   windowWidth = window.innerWidth;
			   windowHeight = window.innerHeight;		  
			   $("#askUs").css("top",windowHeight-150+"px");
			   $("#askUs").css("left",windowWidth-150+"px");
			   
		   });

		  

	  
	  }
	   moveAskUs();
		  window.addEventListener('scroll',function(){
			  var y = window.scrollY;			  
			  $("#askUs").css("top",windowHeight-200+y+"px");
			   
		   });
	  //검색 키워드 받기
			
			$(function(){
				$("#searchButton").on("click",function(){
					var searchTxt = $("#searchBar").val();
					
				})
				
			})
		//아콘표시	
	 
	 