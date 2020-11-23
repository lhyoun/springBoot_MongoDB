<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>

<main>
	<%-- <h1>게시글 상세보기</h1>
	<hr/>
	
	<table border="1">
		<tr>
			<td>ID</td>
			<td>TITLE</td>
			<td>CONTENT</td>
			<td>READCOUNT</td>
			<td>CREATEDATE</td>
		</tr>
			<tr>
				<td>${board.id}</td>
				<td><input id="title" type="text" value=${board.title}></td>
				<td><input id="content" type="text" value=${board.content}></td>
				<td>${board.readCount}</td>
				<td>${board.createDate}</td>
			</tr>
	</table>
	<button onclick="deleteBoard(${board.id})">삭제</button>
	<button onclick="updateBoard(${board.id})">수정</button> --%>



	<div style="width: 60%; margin: auto;">
		<br>
		<h1>DETAIL</h1>
		<br> <br> <label class="mr-sm-2">TITLE</label> <input
			type="text" class="form-control mb-2 mr-sm-2"
			placeholder="Enter title" id="title" value=${board.title }> <br>
		<label class="mr-sm-2">CONTENT</label> <br>
		<textarea id="summernote" name="content">${board.content}</textarea>
		<br> <br>

		<div class="row">
			<div class="col-4"></div>
			<div class="col-2">
				<button type="button" class="btn btn-dark"
					onclick="deleteBoard(${board.id})">삭제</button>
			</div>
			<div class="col-2">
				<button type="button" class="btn btn-dark"
					onclick="updateBoard(${board.id})">수정</button>
			</div>
			<div class="col-4"></div>
		</div>

		<!-- <input id="subBtn" type="button" value="글 작성" style="float: right;" onclick="createBoard"/> -->
	</div>
</main>

<script>
$(document).ready(function() {
     $('#summernote').summernote({
          placeholder: 'content',
           minHeight: 370,
           maxHeight: null,
           focus: true, 
           lang : 'ko-KR'
     });
   });
</script>

<script>
	function deleteBoard(id){
		fetch("/board/"+id,{
			method:"delete"
		}).then(res=>res.text())
		.then(res=>{
			if(res=="ok"){
				alert("삭제 성공");
				location.href="/board/list";	
			}else{
				alert("삭제 실패");
			}
		});
	}

	function updateBoard(id){
		// id, title, content
		let title_el = document.querySelector("#title");
		let content_el = document.querySelector("#summernote");
		let title = title_el.value;
		let content = content_el.value;
		
		console.log("id", id);
		console.log("title", title);
		console.log("content", content);

		let board = {
			title: title,
			content: content
		};

		fetch("/board/"+id, {
			method: "put",
			headers: {
				'Content-Type': 'application/json; charset=utf-8',
			},
			body: JSON.stringify(board)
		}).then(res=> res.text())
		.then(res=> {
			if(res=="ok"){
				alert("수정완료");
				location.reload();
			}else{
				alert("수정실패");
			}
		});

		console.log(board);
	}
</script>
<%@include file="layout/footer.jsp"%>
