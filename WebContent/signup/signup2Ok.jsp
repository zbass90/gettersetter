<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true"%>
<c:if test="${cnt>0}">
	<script>
		alert("가입성공");
		location.href="<%=request.getContextPath()%>/index.do";
	</script>
</c:if>			
<c:if test="${cnt<=0}">
	<script>
		alert("가입실패");
		history.back();
	</script>
</c:if>