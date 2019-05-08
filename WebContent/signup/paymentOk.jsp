<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${loginStatus==null || loginStatus==0}">
	<script>
		alert("로그인 후 Acorn 충전이 가능합니다... 로그인 페이지로 이동합니다.");
		location.href="../index.do";
	</script>
</c:if>
<c:if test="${loginStatus==1 }">
	
	<c:if test="${cnt>0 }">
		<script>
			alert("Acorn 충전이 완료 되었습니다. 즐거운 시간 되십시오~ ^^");
			location.href="<%=request.getContextPath()%>/signup/payment.do";
		</script>
	
	</c:if>
	<c:if test="${cnt<=0}">
		<script>
			alert("Acorn 충전에 실패하였습니다.ㅜㅜ 다시 충전해주세요~");
			history.back();
		</script>
	</c:if>
</c:if>