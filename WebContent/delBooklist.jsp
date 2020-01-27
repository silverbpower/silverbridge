<!DOCTYPE html>
<%@page import="dto.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<%--브라우저 화면 한글깨짐 처리 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- theme -->
<link href="css/tabulator/tabulator.min.css" rel="stylesheet">
<!-- <link href="../dist/css/tabulator_simple.min.css" rel="stylesheet"> -->
<!-- <link href="../dist/css/tabulator_midnight.min.css" rel="stylesheet"> -->
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/tabulator/tabulator.min.js"></script>
<script type="text/javascript">
	$(function(){
		//Build Tabulator
		var table = new Tabulator("#example-table", {
//		    height:"311px",
		    columns:[
		      {formatter:"rowSelection", titleFormatter:"rowSelection", align:"center", headerSort:false, cellClick:function(e, cell){
		        cell.getRow().toggleSelect();
		      }},
		      {title:"번호", field:"no", width:100, align:"right", sorter:"number"},
		      {title:"제목", field:"title", width:400},
		      {title:"출판사", field:"publisher", width:100},
		      {title:"저자", field:"author", width:100},
		      {title:"등록일", field:"regDate", align:"center", sorter:"date"},
		      {title:"대여여부", field:"rentYn", width:10, align:"center"},
		      {title:"대여일", field:"rentDate", align:"center", sorter:"date"},
		      {title:"반납일", field:"returnDate", align:"center", sorter:"date"},
		      {title:"반납여부", field:"returnYn", width:10, align:"center"}
 		    ]
		});
	})
</script>
</head>
<body>
<%
	ArrayList<BookDTO> list = (ArrayList<BookDTO>)request.getAttribute("list");
%>
	<table id="example-table">
		<thead>
			<tr>
				<th tabulator-align="center">번호</th>
				<th tabulator-align="center">제목</th>
				<th>출판사</th>
				<th>저자</th>
				<th width="150">등록일</th>
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
<%
	}
%>
		</tbody>
	</table>
	<input type="button" value="삭제" class="delete">
<script>
	$(function(){
		var btn = document.getElementsByClassName("delete")[0];
		var chkIdx = $("div.tabulator-table").children("div.tabulator-selectable");
        var arr = [];
		btn.addEventListener("click", function(){
            for(i=0; i<chkIdx.length; i++){
                //hasClass는 jQuery객체이므로, chkIdx[i]를 jQuery 객체로 바꿔 주어야 인식이 된다.
                var hasCls = $(chkIdx[i]).hasClass('tabulator-selected');
                if(hasCls==true){
                    var selected = document.querySelector(".tabulator-selectable:nth-child("+(i+1)+")>div.tabulator-cell:nth-child(2)").innerHTML;
                    var reg = new RegExp(/^\d+/);
                    arr.push(reg.exec(selected)[0]);
                    console.log(arr);
                    
                    var val = location.href.substr(
                        location.href.lastIndexOf('book') + 1
                    );
                    console.log('val : ' + val);
                    }
                }
        })
	})
</script>
</body>
</html>