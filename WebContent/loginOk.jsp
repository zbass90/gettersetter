<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
 	//로그인성공
	if(${cnt==1}){
		alert("로그인성공");
		location.href="<%=request.getContextPath()%>/index.do"	
	
	}
	//로그인실패
	else{
		alert("로그인실패");
		location.href="<%=request.getContextPath()%>/index.do"
	}
 
</script>