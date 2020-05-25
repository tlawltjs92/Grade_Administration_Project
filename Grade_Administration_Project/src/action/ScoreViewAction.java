package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ScoreService;
import vo.ActionForward;
import vo.GradeVO;

public class ScoreViewAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ArrayList<GradeVO> list = new ArrayList<GradeVO>();
		
		ScoreService ss = new ScoreService();
		list = ss.getList();
		request.setAttribute("list", list);
		forward.setPath("template.jsp?page=score_view");
		
		return forward;
	}

}
