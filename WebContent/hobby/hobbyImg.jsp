<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2 class="justify-content-center">동호회 사진 수정</h2>

		<form action="" enctype="multipart/form-data">
			<div class="image-container">
				<img style="width: 415px; margin-right: 50px" id="preview-image"
					src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image">
				<input style="display: block; width: 415px; margin-right: 50px;"
					type="file" name="hobbyImg" class="form-control" id="input-image">
			</div>
			<input type="button" value="수정" onclick="imgok()">
		</form>
	</div>
	<script type="text/javascript" src="/assets/js/img.js"></script>
</body>
</html>