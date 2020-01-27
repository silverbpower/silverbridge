<%@page import="dto.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<%
/* jsp �� �����ܿ��� ����� */
	ArrayList<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
%>
	<!-- HTML���� -->
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>��ȣ</th>
					<th>����</th>
					<th>���ǻ�</th>
					<th>����</th>
					<th>�����</th>
					<th>�뿩����</th>
					<th>�뿩��</th>
					<th>�ݳ���</th>
					<th>�ݳ�����</th>
				</tr>
			</thead>
			<tbody>
<%
				for(BookDTO book : list){
%>
<!-- �� ���� ��� �Ʒ��� JSTL�� ����� �� �ִ�. --> 
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