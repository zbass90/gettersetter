<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<c:if test="${cnt>0 }">
	<script>
		alert("successfully comment wrote");
		location.href="<%=request.getContextPath()%>/intro/intro.do?introNo=${introNo}";
	</script>
</c:if>
<c:if test="${cnt<=0 }">
	<script>
		alert("error");
		location.href="<%=request.getContextPath()%>/intro/intro.do?introNo=${introNo}";
	</script>
</c:if>