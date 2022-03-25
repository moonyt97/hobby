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
<title>Profile</title>
</head>
<body>
	<!-- Header -->
	<header>
	<div class="container d-flex justify-content-between mt-2">
		<h3 class="p-2">
			<a href="/" style="text-decoration: none; color: black">What's
				Your Hobby?!</a>
		</h3>
		<div class="p-2">
			<a class="btn btn-outline-primary" href="/Logout.do">로그아웃</a>
			<a class="btn btn-primary">내정보</a>
		</div>
	</div>
	</header>
	<!-- center -->
	<center class="mt-5">
		<div class="container">
			<h4 class="mb-4">내정보</h4>
			<form action="/ProfileUpdate.do" name="joinForm" method="post"
				style="width: 600px" class="justify-content-center">
				<div class="row g-3 justify-content-center align-items-center mt-2">
					<div class="col-3">
						<label for="inputID" class="col-form-label">아이디</label>
					</div>
					<div class="col-auto">
						<input type="text" id="inputID" class="form-control"
							aria-describedby="passwordHelpInline" name="memberID"
							 value="${bean.memberID }" readonly>
					</div>
				</div>
				<div class="row g-3 justify-content-center align-items-center mt-2">
					<div class="col-3">
						<label for="inputPassword1" class="col-form-label">패스워드</label>
					</div>
					<div class="col-auto">
						<input type="password" id="inputPassword1" class="form-control"
							aria-describedby="passwordHelpInline" name="memberPassword"
							required>
					</div>
				</div>
				<div class="row g-3 justify-content-center align-items-center mt-2">
					<div class="col-3">
						<label for="inputName" class="col-form-label">이름</label>
					</div>
					<div class="col-auto">
						<input type="text" name="memberName" id="inputName" class="form-control"
							aria-describedby="passwordHelpInline" readonly value="${bean.memberName }">
					</div>
				</div>
				<div class="row g-3 justify-content-center align-items-center mt-2">
					<div class="col-3">
						<label for="inputPhone" class="col-form-label">전화번호</label>
					</div>
					<div class="col-auto">
						<input type="tel" id="inputPhone" name="memberPhone"
							class="form-control" aria-describedby="passwordHelpInline"
							readonly value="${bean.memberPhone }">
					</div>
				</div>
				<input type="submit" value="정보수정" class="mt-4 btn btn-outline-primary"/>
			</form>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="/assets/js/join.js"></script>
</body>
</html>