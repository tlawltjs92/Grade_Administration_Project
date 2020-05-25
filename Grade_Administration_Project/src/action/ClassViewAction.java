package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ClassService;
import vo.ActionForward;
import vo.GradeVO;

public class ClassViewAction {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		ArrayList<GradeVO> list = new ArrayList<GradeVO>();

		ClassService cs = new ClassService();
		list = cs.getList();
		request.setAttribute("list", list);
		forward.setPath("template.jsp?page=class_view");

		return forward;
	}
}
