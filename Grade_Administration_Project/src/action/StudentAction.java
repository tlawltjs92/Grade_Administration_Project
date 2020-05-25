package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GradeDAO;
import vo.ActionForward;
import vo.GradeVO;
import static db.UtilJdbc.*;

public class StudentAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		GradeVO gradeVO = new GradeVO();
		
		gradeVO.setSyear(request.getParameter("syear"));
		gradeVO.setSclass(request.getParameter("sclass"));
		gradeVO.setSno(request.getParameter("sno"));
		gradeVO.setSname(request.getParameter("sname"));
		gradeVO.setBirth(request.getParameter("birth"));
		gradeVO.setGender(request.getParameter("gender"));
		gradeVO.setTel1(request.getParameter("tel1"));
		gradeVO.setTel2(request.getParameter("tel2"));
		gradeVO.setTel3(request.getParameter("tel3"));
		
		Connection conn = getConnection();
		GradeDAO gradeDAO = GradeDAO.getInstance();
		gradeDAO.setConnection(conn);
		
		int result = gradeDAO.student(gradeVO);
		
		if(result > 0) {
			forward.setPath("template.jsp?page=home");
		}
		
		return forward;
	}

}
