<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<c:if test="${cnt==1 }">
	<script>
		location.href="<%=request.getContextPath()%>/manager/manager.do"
	</script>
</c:if>
<c:if test="${cnt!=1 }">
	<script>
		alert("error");
		location.href="<%=request.getContextPath()%>/manager/manager.do"
	</script>
</c:if>