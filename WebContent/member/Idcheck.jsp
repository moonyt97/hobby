<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h2 class="justify-content-center">아이디 중복 확인</h2>
<form action="Idcheck.do" name="joinForm">
아이디
<input type="text" name="memberID" value="${memberID }">
<input type="submit" value="중복체크"><br>

<c:if test="${result ==1}">
	${memberID }는 이미 사용중인 아이디입니다.
</c:if>
<c:if test="${result==0 }">
	${memberID }는 사용가능한 아이디입니다.
	<input type="button" value="사용" onclick="idok('${memberID}')">
</c:if>
</form>
</div>
<script type="text/javascript" src="assets/js/join.js"></script>
</body>
</html>