<%@page import="com.study.dvd.dao.PublisherDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.study.dvd.entity.Publisher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String searchText = request.getParameter("searchText");
	List<Publisher> publishers = PublisherDao.searchPublisherByName(searchText);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border: 1px solid #dbdbdb;
		border-collapse: collapse;
		width: 1000px;
		overflow-x: auto;
	}
	
	thead, tbody {
		border-collapse: collapse;
	}
	
	th, td {
	border: 1px solid #dbdbdb;
	padding: 10px;
	
	}
	
</style>
</head>
<body>
	<label>제작사 검색</label>
	<input type="text"
		class="input-search"
		placeholder="제작사를 입력하세요."
		onKeyDown="handleInputKeyDown()">
	<button onClick="handleSearchButtonClick()">확인</button>
	<table>
		<thead>
			<tr>
				<th>producer_id</th>
				<th>producer_name</th>
			</tr>
		</thead>
		<tbody>
			
				<%for(Publisher publisher : publishers) {
				%>
				<tr>
					<td><%=publisher.getPublisherId() %></td>
					<td><%=publisher.getPublisherName() %></td>
				</tr>
				<%
					}
				%>
		</tbody>
	</table>
	<script src="/dvd/static/search_publisher.js"></script>
</body>
</html>