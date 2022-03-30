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
<title>Join</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="/top.jsp"/>
	<!-- center -->
	<center class="mt-5">
		<div class="container">
			<h4 class="mb-4">회원가입</h4>
			<form action="/Join.do" name="joinForm" method="post"
				style="width: 600px" class="justify-content-center">
				<div class="row g-3  align-items-center mt-2">
					<div class="col-3">
						<label for="inputId" class="col-form-label">아이디</label>
					</div>
					<div class="col-auto">
						<input type="text" id="inputId" name="memberID"
							class="form-control" aria-describedby="passwordHelpInline"
							oninput="handleOnInput(this)" required>
					</div>
					<div class="col-auto">
						<input type="button" value="중복체크" class="btn btn-outline-primary"
							onclick="idCheck()"> <input type="hidden" name="isDuplication" value="idUncheck">
					</div>
				</div>
				<div class="row g-3  align-items-center mt-2">
					<div class="col-3">
						<label for="inputPassword1" class="col-form-label">패스워드</label>
					</div>
					<div class="col-auto">
						<input type="password" id="inputPassword1" class="form-control"
							aria-describedby="passwordHelpInline" name="memberPassword"
							required>
					</div>
				</div>
				<div class="row g-3  align-items-center mt-2">
					<div class="col-3">
						<label for="inputPassword2" class="col-form-label">패스워드 확인</label>
					</div>
					<div class="col-auto">
						<input type="password" name="memberPassword2" id="inputPassword2" class="form-control"
							aria-describedby="passwordHelpInline" onchange="checkPW()" required>
					</div>
					<div class="col-auto">
						<span id="passwordCheck" class="form-text" > </span>
					</div>
				</div>
				<div class="row g-3  align-items-center mt-2">
					<div class="col-3">
						<label for="inputName" class="col-form-label">이름</label>
					</div>
					<div class="col-auto">
						<input type="text" id="inputName" name="memberName"
							class="form-control" aria-describedby="passwordHelpInline"
							required>
					</div>
				</div>
				<div class="row g-3  align-items-center mt-2">
					<div class="col-3">
						<label for="inputPhone" class="col-form-label">전화번호</label>
					</div>
					<div class="col-auto">
						<input type="tel" id="inputPhone" name="memberPhone"
							class="form-control" aria-describedby="passwordHelpInline"
							required>
					</div>
				</div>
				<input type="submit" value="회원가입" class="mt-4 btn btn-outline-primary" name="joinBtn" />
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