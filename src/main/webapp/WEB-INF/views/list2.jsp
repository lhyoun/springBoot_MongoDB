<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp" %>
<div style="width: 60%; margin: auto;">
<main>
	<br>
	<h1>BOARD LIST</h1>
	<br>
	<br>
	
	
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>ID</th>
				<th>TITLE</th>
				<!-- <th>CONTENT</th> -->
				<th>READCOUNT</th>
				<th>CREATEDATE</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="board" items="${boards.content}">
				<tr>
					<td>${board.id}</td>
					<td><a href="/board/${board.id}">${board.title}</a></td>
					<!-- <td>${board.content}</td> -->
					<td>${board.readCount}</td>
					<td>${board.date}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<div class="row">
		<div class="col-4"></div>	
		<div class="col-2">
			<button type="button" class="btn btn-dark" 
			onclick="location.href='?page=${boards.pageable.pageNumber-1}' ">이전</button>
		</div>
		<div class="col-2">
			<button type="button" class="btn btn-dark" 
			onclick="location.href='?page=${boards.pageable.pageNumber+1}' ">다음</button>
		</div>
		<div class="col-4"></div>
	</div>
</main>
</div>

<%@include file="layout/footer.jsp" %>
