<%@page import="vo.GradeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<GradeVO> list = (ArrayList<GradeVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div id="class_container">
		<h2 id="title">반별통계</h2>
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>학년</th>
				<th>반</th>
				<th>교사명</th>
				<th>국어총점</th>
				<th>영어총점</th>
				<th>수학총점</th>
				<th>국어평균</th>
				<th>영어평균</th>
				<th>수학평균</th>
			</tr>
			<%
				for(int i = 0 ; i < list.size() ; i++) {
			%>
			<tr>
				<td><%=list.get(i).getSyear() %></td>
				<td><%=list.get(i).getSclass() %></td>
				<td><%=list.get(i).getTname() %></td>
				<td><%=list.get(i).getKor_sum() %></td>
				<td><%=list.get(i).getEng_sum() %></td>
				<td><%=list.get(i).getMath_sum() %></td>
				<%
					float kor_avg = Integer.parseInt(list.get(i).getKor_sum()) / Integer.parseInt(list.get(i).getCount());
					float eng_avg = Integer.parseInt(list.get(i).getEng_sum()) / Integer.parseInt(list.get(i).getCount());
					float math_avg = Integer.parseInt(list.get(i).getMath_sum()) / Integer.parseInt(list.get(i).getCount());
				%>
				<td><%=kor_avg %></td>
				<td><%=eng_avg %></td>
				<td><%=math_avg %></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>