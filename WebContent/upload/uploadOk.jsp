<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

		
		<c:if test="${cnt>0}">
		<script>
			alert("인트로 수정 석세스");
			location.href="<%=request.getContextPath()%>/upload/upload.do"	
				</script>
		</c:if>

		
		
	