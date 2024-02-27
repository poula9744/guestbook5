<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook5/guest/insert" method="get">
	<table border="1" width="540px">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value=""></td>
			<td>비밀번호</td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td colspan="4"><textarea cols="72" rows="5" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="hidden" name="action" value="insert">
				<button type="submit">등록</button>
			</td>
		</tr>
	</table>
	</form>
	<br>

	<c:forEach items="${requestScope.guestList}" var="guestVo">
	<table border="1" width="540px">
		<tr>
			<td>${guestVo.no}</td>
			<td>${guestVo.name}</td>
			<td>${guestVo.password}</td>
			<td><a href="/guestbook5/guest/deleteform?no=${guestVo.no}">삭제</a></td>
		</tr>
		
		<tr>
			<td colspan="4">${guestVo.content}</td>
		</tr>
		
	</table>
	</c:forEach>
</body>

</html>