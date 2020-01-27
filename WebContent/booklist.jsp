<%@page import="dto.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<%
/* jsp 는 서버단에서 실행됨 */
	ArrayList<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
%>
	<!-- HTML문법 -->
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>출판사</th>
					<th>저자</th>
					<th>등록일</th>
					<th>대여여부</th>
					<th>대여일</th>
					<th>반납일</th>
					<th>반납여부</th>
				</tr>
			</thead>
			<tbody>
<%
				for(BookDTO book : list){
%>
<!-- 위 문법 대신 아래의 JSTL을 사용할 수 있다. --> 
<!-- <c:forEach var="book" items="${list}" -->
				<tr>
					<td><%=book.getBookNo() %></td>
					<td><%=book.getBookName() %></td>
					<td><%=book.getPublisher() %></td>
					<td><%=book.getAuthor() %></td>
					<td><%=book.getRegDate() %></td>
					<td><%=book.getRentYn() %></td>
					<td><%=book.getRentDate() %></td>
					<td><%=book.getReturnDate() %></td>
					<td><%=book.getReturnYn() %></td>
				</tr>
<!-- </c:forEach> -->
<%
				}
%>
			</tbody>
		</table>
	</div>
</body>
</html>