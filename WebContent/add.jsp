<!-- 지시 블럭 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%!
	private int add(int x, int y){
		return x+y;
	}
%>

<%
// 이 안은 자바 영역이야 ~~
// 코드블럭이 된다.

	int x = 3;
	int y = 4;
	int sum = add(x, y);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~~</title>
</head>
<body>
	<form action ="add" method="post">
		<table border="1">
			<tr>
				<td>
					계산할 값 입력하세요. 
				</td>
			</tr>	
			<tr>
				<td>
					<input type="text" name="x"/>
					<input type="text" name="y"/>
				</td>
				<td>
					<input type="submit" name="cmd" value="덧셈"/>
					<input type="submit" name="cmd" value="application"/>
					<input type="submit" name="cmd" value="session"/>
					<input type="submit" name="cmd" value="cookie"/>
				</td>
			</tr>	
		</table>
		<div>
			<label>sum : ${sum} - ${param.s}
			<% //out.print(sum); %>
			<%//= sum %>
			</label>
			<input type="hidden" name="sum" value="${sum}" />
		</div>
	</form>
	<a href="mypage.jsp">마이페이지</a>
</body>
</html>