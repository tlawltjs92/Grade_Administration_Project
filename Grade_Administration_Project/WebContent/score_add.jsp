<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="score_add_container">
		<h2 id="title">성적입력</h2>
		<form action="score.ga" method="post">
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<td>학년</td>
					<td><input type="text" name="syear" id="syear" size="30">(예)
						1</td>
				</tr>
				<tr>
					<td>반</td>
					<td><input type="text" name="sclass" id="sclass" size="30">(예)
						01</td>
				</tr>
				<tr>
					<td>번호</td>
					<td><input type="text" name="sno" id="sno" size="30">(예)
						01</td>
				</tr>
				<tr>
					<td>국어</td>
					<td><input type="text" name="kor" id="kor" size="30">점수범위(0~100)</td>
				</tr>
				<tr>
					<td>영어</td>
					<td><input type="text" name="eng" id="eng" size="30">점수범위(0~100)</td>
				</tr>
				<tr>
					<td>수학</td>
					<td><input type="text" name="math" id="math" size="30">점수범위(0~100)</td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="성적저장"> <input
						type="reset" value="다시쓰기"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>