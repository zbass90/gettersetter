<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page trimDirectiveWhitespaces="true"%>
<c:if test="${cnt>0}">
	<script>
		alert("THIS ID has already been Taken.")
		history.back();
	</script>
</c:if>
<c:if test="${cnt<=0}">
	<script>
		location.href="<%=request.getContextPath()%>/signup/signup2.do";
	</script>
</c:if>
