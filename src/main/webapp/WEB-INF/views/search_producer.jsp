<%@page import="com.study.dvd.dao.ProducerDao"%>
<%@page import="com.study.dvd.entity.Producer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 여기서 params값(searchText은 js에서 작성한 params값과 맞춰주야 함
	String searchText = request.getParameter("searchText");
	List<Producer> producers = ProducerDao.seachProducerByProducerName(searchText);
%>
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
		<label>producer search</label>
		<input type="text"
			class="search-input"
			placeholder="프로듀서 이름을 입력하세요."
			onKeyDown = "handleInputKeyDown()">
		<button onClick="handleSearchButtonClick()">검색</button>
	</div>
	<table>
		<thead>
			<tr>
				<th>Producer_ID</th>
				<th>프로듀서 이름</th>
			</tr>
		</thead>
		<tbody>
			<%
				// JSTL (JSP Standard Tag Library)
				for(Producer producer: producers) {
			%>
				<tr>
					<td><%= producer.getProducerId() %></td>
					<td><%= producer.getProducerName() %></td>
				</tr>
			<%
				};
			%>
			
		</tbody>
	
	
	<script src="/dvd/static/search_producer.js"></script>
</body>
</html>