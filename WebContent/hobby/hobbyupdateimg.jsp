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
<title>HobbyUpdateForm</title>
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
			<h4 class="mb-4">동호회 수정</h4>
			<form action="/HobbyUpdate.do" method="post"
				enctype="multipart/form-data" name="updateForm">
				<div class="row row-cols-1">
					<div class="col-sm justify-content-center mt-2">
						<div>
							<label for="inputImg" class="col-form-label">동호회 사진</label>
						</div>
						<div class="image-container">
							<img style="width: 415px; margin-right: 50px" id="preview-image"
								src="${bean.hobbyImg}" name="img"> <input
								style="display: block; width: 415px; margin-right: 50px;"
								type="file" name="hobbyImg" class="form-control"
								id="input-image"> 
								<input type="hidden" name="hobbyNo" value="${bean.hobbyNo }">
								<input type="submit" value="수정하기📃"
								class="mt-4 btn btn-outline-primary" name="joinBtn" />
						</div>
					</div>
					<div class="col-sm justify-content-center mt-2">
						<div class="row g-3 align-items-center mt-2">
							<div class="col-auto">
								<label for="inputTitle" class="col-form-label">동호회 이름</label>
							</div>
							<div class="col-auto">
								<input type="text" id="inputTitle" name="hobbyTitle"
									class="form-control" aria-describedby="passwordHelpInline"
									required value="${bean.hobbyTitle }" readonly>
							</div>
						</div>
						<div class="row g-3  align-items-center mt-2">
							<div class="col-auto">
								<label for="inputLo" class="col-form-label">활동지역</label>
							</div>
							<div class="col-auto">
								<input type="text" id="inputTitle" name="hobbyTitle"
									class="form-control" aria-describedby="passwordHelpInline"
									required value="${bean.hobbyLo }" readonly>
							</div>
						</div>

						<div class="row g-3  align-items-center mt-2">
							<div class="col-auto">
								<label for="inputCount" class="col-form-label">모집인원</label>
							</div>
							<div class="col-auto">
								<input type="number" id="inputCount" name="hobbyCount"
									class="form-control" aria-describedby="passwordHelpInline"
									required readonly value="${bean.hobbyCount }">
							</div>
						</div>
						<div class="row g-3 align-items-center mt-2">
							<div class="col-auto">
								<label for="inputContent" class="col-form-label">동호회 설명</label>
							</div>
							<div class="col-auto">
								<textarea class="form-control" name="hobbyContent" rows="8"
									cols="50" readonly>${bean.hobbyContent}</textarea>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="/assets/js/img.js"></script>
</body>
</html>