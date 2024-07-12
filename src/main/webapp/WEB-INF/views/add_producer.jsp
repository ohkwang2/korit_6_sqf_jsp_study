<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dvd/producer/add" method="post">
		<label>제작사</label>
		<%//form태그 안에 input이 들어있으면 name이 key값이 됨 %>
		<input name="producer" placeholder="제작사명을 입력하세요.">
		<%//button type이 submit이면 form의 액션을 호출 %>
		<button type="submit">추가</button>
	</form>
</body>
</html>