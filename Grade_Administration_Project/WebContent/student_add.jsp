<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="student_add_container">
		<h2 id="title">학생 등록</h2>
		<form action="student.ga">
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
					<td>이름</td>
					<td><input type="text" name="sname" id="sname" size="30"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="birth" id="birth" size="30">(예)
						190301</td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="radio" name="gender" id="gender" value="F">남성
						<input type="radio" name="gender" id="gender" value="M">여성
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="tel1" id="tel1" size="10">-
						<input type="text" name="tel2" id="tel2" size="10">- <input
						type="text" name="tel3" id="tel3" size="10"></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="학생등록"> <input
						type="reset" value="다시쓰기"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>