<%@page import="vo.GradeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<GradeVO> list = (ArrayList<GradeVO>) request.getAttribute("list");
	String gender = null;
	int total_kor = 0;
	int total_eng = 0;
	int total_math = 0;
	
	double kor_avg = 0;
	double eng_avg = 0;
	double math_avg = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="score_container">
		<h2 id="title">학생성적조회</h2>
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>학년-반-번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getSyear()%>-<%=list.get(i).getSclass()%>-<%=list.get(i).getSno()%></td>
				<td><%=list.get(i).getSname()%></td>
				<%
					if (list.get(i).getGender().equals("F")) {
					gender = "여";
				} else {
					gender = "남";
				}
				%>
				<td><%=gender%></td>
				<td><%=list.get(i).getKor()%></td>
				<td><%=list.get(i).getEng()%></td>
				<td><%=list.get(i).getMath()%></td>
				<td><%=list.get(i).getSum()%></td>
				<td><%=list.get(i).getAvg()%></td>
			</tr>
			<%
				total_kor = total_kor + Integer.parseInt(list.get(i).getKor());
				total_eng = total_eng + Integer.parseInt(list.get(i).getEng());
				total_math = total_math + Integer.parseInt(list.get(i).getMath());
			}
			kor_avg = total_kor / list.size();
			eng_avg = total_eng / list.size();
			math_avg = total_math / list.size();
			%>
			<tr>
				<td></td>
				<td></td>
				<td>학년총점</td>
				<td><%=total_kor %></td>
				<td><%=total_eng %></td>
				<td><%=total_math %></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>학년평균</td>
				<td><%=kor_avg %></td>
				<td><%=eng_avg %></td>
				<td><%=math_avg %></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>