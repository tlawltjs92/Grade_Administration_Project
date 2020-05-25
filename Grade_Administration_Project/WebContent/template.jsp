<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getParameter("page");

	if (path.equals("home")) {
		path = "home.jsp";
	} else if (path.equals("student_add")) {
		path = "student_add.jsp";
	} else if (path.equals("score_add")) {
		path = "score_add.jsp";
	} else if (path.equals("score_view")) {
		path = "score_view.jsp";
	} else if (path.equals("class_view")) {
		path = "class_view.jsp";
	} else {
		path = "home.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고교성적관리 프로그램</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<section>
		<jsp:include page="<%=path%>"></jsp:include>
	</section>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>