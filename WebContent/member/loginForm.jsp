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
<title>Login</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/top.jsp"/>
	<!-- center -->
	<center class="mt-5">
		<div class="container">
			<h4 class="mb-4">로그인</h4>
			<form action="/Login.do" name="joinForm" method="post"
				style="width: 600px" class="justify-content-center">
				<div class="row g-3 justify-content-center align-items-center mt-2">
					<div class="col-2">
						<label for="inputID" class="col-form-label">아이디</label>
					</div>
					<div class="col-auto">
						<input type="text" id="inputID" name="memberID"
							class="form-control" aria-describedby="passwordHelpInline"
							required>
					</div>
				</div>
				<div class="row g-3 justify-content-center align-items-center mt-2">
					<div class="col-2">
						<label for="inputPassword" class="col-form-label">패스워드</label>
					</div>
					<div class="col-auto">
						<input type="password" id="inputPassword" name="memberPassword"
							class="form-control" aria-describedby="passwordHelpInline"
							required>
					</div>
				</div>
				<input type="submit" value="로그인"
					class="mt-4 btn btn-outline-primary" />
			</form>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>