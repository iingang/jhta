<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="ex1-javascript.js"></script>
</head>
<body>



	<section id="ex6">
		<h1>ex6-노드조작: 메뉴추가하기</h1>
		<div>
			<input name="title" />
			<input type="button" name="btn-add" value="추가" />
		</div>
		<ul class="menu-list">
			
		</ul>
	</section>
	<hr />
	
	<section id="ex5">
		<h1>ex5-속성 조작 : 이미지 스타일 변경</h1>
		<div>
			<label>width</label>
			<input name="width" />
			<label>height</label>
			<input name="height" />
			<label>color</label>
			<input name="color"/>
			<input type="button" value="변경" />
		</div>
		<div>
		
			<img src="images/nat3.jpg" />
		</div>
	</section>
	<hr />
	
	
	<section id="ex4">
		<h1>ex4-속성 조작 : 이미지 변경</h1>
		<div>
			<input />
			<input type="button" value="변경" />
			<select><!-- <select onchange="alert(value)"> -->
				<option value="nat1.jpg">자연1</option>
				<option value="nat2.jpeg">자연2</option>
				<option value="nat3.jpg">자연3</option>
			</select>
		</div>
		<div>
		
			<img src="" />
		</div>
	</section>
	<hr />
	
	
	<section id="ex3">
		<h1>ex3-노드 선택 API: 계산기3</h1>
		<div>
			<input type="text" name="txt-x" />
			<input type="text" name="txt-y" />
			<input type="button" value="덧셈" />
			<input type="text" />
		</div>
	</section>
	<hr />
	
	<section id="ex2">
		<h1>ex2-노드 선택: 계산기2</h1>
		<div>
			<input type="text" name="txt-x" />
			<input type="text" name="txt-y" />
			<input type="button" value="덧셈" />
			<input type="text" />
		</div>
	</section>
	<hr />
	
	
	<section>
		<h1>ex1: 계산기</h1>
		<div>
			<input type="text" id="txt-x" />
			<input type="text" id="txt-y" />
			<input type="button" value="덧셈" id="btn-add" />
			<input type="text" id="txt-sum" />
		</div>
	</section>
	<hr />

	<div>
	<input type="button" value="클릭" id="btn-print" />
	</div>
</body>
</html>