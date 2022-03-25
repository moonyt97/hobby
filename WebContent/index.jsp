<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Main</title>
</head>
<body>
	<c:if test="${joinResult==1 }">
		<script type="text/javascript">
			alert("아이디 중복체크를 해주세요")
			history.go(-1)
		</script>
	</c:if>
	<c:if test="${loginResult==0 }">
		<script type="text/javascript">
			alert("아이디와 비밀번호를 확안해주세요")
			history.go(-1)
		</script>
	</c:if>
	<!-- Header -->
	<header>
	<div class="container d-flex justify-content-between mt-2">
		<h3 class="p-2">What's Your Hobby?!</h3>
		<div class="p-2">
			
			<c:if test="${loginMember==null }">
			<a href="member/loginForm.jsp" class="btn btn-outline-primary">로그인</a>
			<a href="member/joinform.jsp" class="btn btn-outline-primary">회원가입</a>
			</c:if>
			<c:if test="${loginMember!=null }">
			<a href="Logout.do" class="btn btn-outline-primary">로그아웃</a>
			<a href="Profile.do" class="btn btn-outline-primary" >${loginMember }</a>
			</c:if>
		</div>
	</div>
	</header>
	<!-- center -->
	<center class="mt-5">
		<div class="container">
			<c:if test="${loginMember==null }">
			<h5>로그인 후 다양한 취미를 즐겨 보세요!</h5>
			</c:if>
			<c:if test="${loginMember!=null }">
			<h5>${loginMember }님 환영합니다, 여러가지 취미를 즐겨보세요!</h5>
			</c:if>
			
			
			<div class="mt-5">
				<div class="slide1"><img alt="" src="assets/img/tennis.jpg"></div>
				<div class=" slide1"><img alt="" width="400" src="assets/img/basketball.jpg"></div>
				<div class=" slide1"><img alt="" width="400" src="assets/img/movie.jpg"></div>
				<div class=" slide1"><img alt="" width="400" src="assets/img/guitar.jpg"></div>
			</div>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>