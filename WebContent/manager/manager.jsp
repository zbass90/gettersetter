<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width , initial-scale=1" >
<title>제목을넣으면되ㅎㅎ</title>

</head>
<body class="container">
<h1>Setter's Introduction Table</h1>
<table>
	<thead>
		<tr>
			<td>introNo</td>
			<td>userid</td>
			<td>filename</td>
			<td>interestStr</td>
			<td>description</td>
			<td>introdate</td>
			<td>title</td>
			<td>follower</td>
			<td>price</td>
		</tr>
	</thead>
<c:forEach var="introvo" items="${introList}">	
		<tr>
			<td>${introvo.introNo }</td>
			<td>${introvo.userid }</td>
			<td>${introvo.filename }</td>
			<td>${introvo.interestStr }</td>
			<td>${introvo.description }</td>
			<td>${introvo.introdate }</td>			
			<td>${introvo.title }</td>
			<td>${introvo.follower }</td>
			<td>${introvo.price }</td>	
			<td><a href="<%=request.getContextPath()%>/manager/removeIntro.do?introNo=${introvo.introNo }">X</a></td>		
		</tr>
</c:forEach>
</table>
<hr/>
<hr/>
<hr/>
<h1>Member Table</h1>
<table>
	<thead>
		<tr>
			<td>userno</td>
			<td>userid</td>
			<td>userpwd</td>
			<td>tel</td>
			<td>email</td>
			<td>interestStr</td>
			<td>myAcorn</td>
			<td>contentPrice</td>
		</tr>
	</thead>
<c:forEach var="membervo" items="${memberList}">
	
		<tr>
			<td>${membervo.userno }</td>
			<td>${membervo.userid }</td>
			<td>${membervo.userpwd }</td>
			<td>${membervo.tel }</td>
			<td>${membervo.email }</td>
			<td>${membervo.interestStr }</td>			
			<td>${membervo.myAcorn }</td>
			<td>${membervo.contentPrice }</td>
			<td><a href="<%=request.getContextPath()%>/manager/removeUser.do?userid=${membervo.userid}">X</a></td>		
		</tr>
		
</c:forEach>

</table>

<hr/>
<hr/>
<hr/>


</body>
</html>