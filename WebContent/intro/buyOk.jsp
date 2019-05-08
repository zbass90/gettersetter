<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${cnt==1 }">
	<script>
		alert("successfully followed this setter");
		location.href="<%=request.getContextPath()%>/intro/intro.do?introNo=${introNo}";
	</script>
</c:if>

<c:if test="${cnt==-1 }">
	<script>
		alert("you need more acorn to follow");
		location.href="<%=request.getContextPath()%>/intro/intro.do?introNo=${introNo}";
		
	</script>
</c:if>

<c:if test="${cnt==0 }">
	<script>
		alert("something error....I donno what the fffucx");
		location.href="<%=request.getContextPath()%>/intro/intro.do?introNo=${introNo}";
		
	</script>
</c:if>
<c:if test="${cnt==2 }">
	<script>
		alert("you have already followed this setter");
		location.href="<%=request.getContextPath()%>/intro/intro.do?introNo=${introNo}";
		
	</script>
</c:if>
