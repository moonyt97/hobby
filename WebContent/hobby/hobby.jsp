<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>HobbyMain</title>
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

			<c:if test="${loginMember==null }">
				<a href="member/loginForm.jsp" class="btn btn-outline-primary">로그인</a>
				<a href="member/joinform.jsp" class="btn btn-outline-primary">회원가입</a>
			</c:if>
			<c:if test="${loginMember!=null }">
				<a href="/Logout.do" class="btn btn-outline-primary">로그아웃</a>
				<a href="/Profile.do" class="btn btn-outline-primary">${loginMember }</a>
			</c:if>
		</div>
	</div>
	</header>
	<!-- center -->
	<center class="mt-5">
		<div class="container">
			<form action="/Hobby.do" method="get"
				class="row gy-2 gx-3 justify-content-center align-items-center">
				<div class="col-auto">
					<label class="visually-hidden" for="autoSizingSelect">Preference</label>
					<select class="form-select" name="hobbyLo" id="autoSizingSelect">
						<option selected value="0">지역선택</option>
						<option value="0">전체선택</option>
						<option value="서울">서울</option>
						<option value="대전">대전</option>
						<option value="부산">부산</option>
					</select>
				</div>
				<div class="col-auto">
					<label class="visually-hidden" for="autoSizingInput">Name</label> <input
						type="text" class="form-control" name="keyword" id="autoSizingInput"
						placeholder="검색어">
				</div>
				<div class="col-auto">
					<input type="submit" class="btn btn-outline-primary"
						value="동호회찾기🔍" /> 
						<input type="button"
						class="btn btn-outline-primary"
						onClick="location.href='/hobby/hobbyRegister.jsp'" value="동호회등록✏" />
				</div>
			</form>

			<div class="row row-cols-1">
				<c:forEach var="hobby" items="${beans }">
					<div class="mt-3 col-sm">
						<div class="card" style="width: 18rem;">
							<img src="${hobby.hobbyImg }" height="150"
								class="card-img-top">
							<div class="card-body">
								<h5 class="card-title">${hobby.hobbyTitle } </h5>
								<p class="card-text">${hobby.hobbyContent }</p>
								<p class="card-text">0/${hobby.hobbyCount }</p>
								<a href="/hobby/hobbyDetail.jsp?hobbyNo=${hobby.hobbyNo}" class="btn btn-outline-primary">상세보기🔍</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${result==0 }">
					<h2 class="text-center mt-5">검색결과가 없습니다 🖥</h2>
				</c:if>
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