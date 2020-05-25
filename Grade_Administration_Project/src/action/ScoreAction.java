package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GradeDAO;
import vo.ActionForward;
import vo.GradeVO;
import static db.UtilJdbc.*;

public class ScoreAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		GradeVO gradeVO = new GradeVO();
		
		gradeVO.setSyear(request.getParameter("syear"));
		gradeVO.setSclass(request.getParameter("sclass"));
		gradeVO.setSno(request.getParameter("sno"));
		gradeVO.setKor(request.getParameter("kor"));
		gradeVO.setEng(request.getParameter("eng"));
		gradeVO.setMath(request.getParameter("math"));
		
		Connection conn = getConnection();
		GradeDAO gradeDAO = GradeDAO.getInstance();
		gradeDAO.setConnection(conn);
		
		int result = gradeDAO.score(gradeVO);
		
		if(result > 0) {
			forward.setPath("template.jsp?page=main");
		}
		return forward;
	}
}
