<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<jsp:include page="/top.jsp"/>
	<!-- center -->
	<center class="mt-5 pb-5">
		<div class="container">
			<form action="/Hobby.do" method="get"
				class="row gy-2 gx-3 justify-content-center align-items-center">
				<div class="col-auto">
					<h4>나의 신청 목록</h4>
				</div>
			</form>

			<div class="row row-cols-1 mt-3">
				<c:forEach var="hobby" items="${lists }">
					<div class="mt-3 col-sm">
						<div class="card" style="width: 18rem;">
							<img src="${hobby.hobbyImg }" height="150" class="card-img-top">
							<div class="card-body">
								<h5 class="card-title">${hobby.hobbyTitle } <span style="font-size:12px">(${hobby.hobbyLo })</span></h5>
								<p class="card-text">${hobby.hobbyContent }</p>
								<p class="card-text">${hobby.currentCount}/${hobby.hobbyCount }</p>
								<a href="/HobbyDetail.do?hobbyNo=${hobby.hobbyNo}"
									class="btn btn-outline-primary">상세보기🔍</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<c:if test="${result==0 }">
					<h2 class="text-center mt-5">검색결과가 없습니다 🖥</h2>
				</c:if>
			</div>
		</div>
		<div class="mt-5">
		<!-- 페이지 카운터링 소스 -->
		<c:if test="${count>0 }">
			<c:set var="pageCount" value="${count/pageSize + (count%pageSize == 0 ? 0:1) }"/>
			<c:set var="startPage" value="${1 }"/>
			
			<c:if test="${currentPage %10 !=0 }">
				<!-- 결과를 정수형으로 리턴 받아야 한다. -->
				<fmt:parseNumber var="result" value="${currentPage/10 }" integerOnly="true" />
				<c:set var="startPage" value="${result*10+1 }"/>	
			</c:if>
			<c:if test="${currentPage % 10 == 0 }">
				<c:set var="startPage" value="${(result-1)*10+1 }"/>
			</c:if>
			<!-- 화면에 보여질 페이지 처리 숫자를 표현 -->
			<c:set var="pageBlock" value="10" />
			<c:set var="endPage" value="${startPage+pageBlock-1 }" />
			<c:if test="${endPage>pageCount }">
				<c:set var="endPage" value="${pageCount }" />
			</c:if>
			
			<!-- 이전 링크를 걸지 파악 -->
			<c:if test="${startPage>10 }">
				<a href="Hobby.do?pageNum=${startPage-10 }" class="btn btn-outline-primary">이전</a>
			</c:if>
			<!-- 페이징 처리 -->
			<c:forEach var="i" begin="${startPage }" end="${endPage }" >
				<a href="Hobby.do?pageNum=${i }" class="btn btn-outline-primary">${i }</a>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${endPage<pageCount }">
				<a href="Hobby.do?pageNum=${startPage+10 }"class="btn btn-outline-primary">다음</a>
			</c:if>
		</c:if>
		</div>
	</center>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>