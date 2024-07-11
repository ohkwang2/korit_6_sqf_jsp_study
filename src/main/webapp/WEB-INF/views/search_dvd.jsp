<%@page import="com.study.dvd.entity.Dvd"%>
<%@page import="java.util.List"%>
<%@page import="com.study.dvd.dao.DvdDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table {
		widh: 1000px;
		overflow-x: auto;
	}
	table, th, td {
		border: 1px solid #dbdbdb;
		border-collapse: collapse;
	}
	
	th, td {
		padding: 5px 10px;
	}
</style>

</head>
<body>
	<div>
		<label>DVD 검색</label>
		<input type="text"
			class="search-input"
			placeholder="DVD 제목을 입력하세요."
			onKeyDown="handleInputKeyDown()">
		<button onClick="handleSearchClick()">검색</button>	
	</div>
	<%
		// search 값을 파라메터로 받은 값을 DvdDao로 넘겨줌
		String searchText = request.getParameter("searchText");
		List<Dvd> dvds = DvdDao.searchDvdByTitle(searchText);
	%>
	<table>
		<thead>
			<tr>
				<th>DVD_ID</th>
				<th>등록번호</th>
				<th>제목</th>
				<th>제작자_ID</th>
				<th>제작자</th>
				<th>제작사_ID</th>
				<th>제작사</th>
				<th>발행연도</th>
				<th>등록일자</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Dvd dvd: dvds) {
			%>
			<tr>
				<td><%=dvd.getDvdId() %></td>
				<td><%=dvd.getRegistrationNumber() %></td>
				<td><%=dvd.getTitle() %></td>
				<td><%=dvd.getProducerId() %></td>
				<td><%=dvd.getProducerName() %></td>
				<td><%=dvd.getPublisherId() %></td>
				<td><%=dvd.getPublisherName() %></td>
				<td><%=dvd.getPublicationYear() %></td>
				<td><%=dvd.getPublicationYear() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	
	<script src="/dvd/static/search_dvd.js"></script>
</body>
</html>