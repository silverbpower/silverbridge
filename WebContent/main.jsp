<%@page import="dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("main.jsp 진입");

	LoginDTO dto = (LoginDTO)session.getAttribute("dto");
	if(dto == null){
		response.sendRedirect("login.do");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Library!!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<div class="alert alert-warning" role="alert">
		<a href="#" class="alert-link">${dto.getName()}</a> 님 메뉴를 선택해 주세요.
		<form action="logout.do" method="post">
			<button type="submit" class="btn btn-outline-warning">로그아웃</button>
		</form>
	</div>
	<div class="list-group">
		<a href="/addBook" class="list-group-item list-group-item-action">도서추가</a>
		<a href="/booklist.del" class="list-group-item list-group-item-action">도서삭제</a>
		<a href="/booklist" class="list-group-item list-group-item-action">도서조회</a>
		<a href="#" class="list-group-item list-group-item-action">도서대여</a>
		<a href="#" class="list-group-item list-group-item-action">도서반납</a>
		<a href="#" class="list-group-item list-group-item-action">종료</a>
	</div>
<script>
	$("div.alert").css({"margin-bottom":"0", "position":"reletive"})
	.children("a")//.css("float", "left")
	.siblings("form").css({"position":"absolute", "right":"0", "top":"8px"})
</script>
</body>
</html>