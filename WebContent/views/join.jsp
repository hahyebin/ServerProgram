<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<h2>회원 가입 폼</h2>
	<form action="/ServerProgram/join.do" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id"><br>
		<label for="name">이름</label>
		<input type="text" name="name"><br>
	
	<button>회원가입</button>
	<input type="button" value="돌아가기" id="back" onclick="location.href='/ServerProgram/loginPage.do'">
	</form>
	
</body>
</html>