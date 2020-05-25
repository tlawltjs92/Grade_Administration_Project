package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ClassViewAction;
import action.ScoreAction;
import action.ScoreViewAction;
import action.StudentAction;
import vo.ActionForward;

@WebServlet("*.ga")
public class Grade_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		
		if(command.equals("/template.ga")) {
			String page = request.getParameter("page");
			
			if(page.equals("score_view")) {
				request.setAttribute("page", page);
				ScoreViewAction sva = new ScoreViewAction();
				forward = sva.execute(request, response);
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			} else if(page.equals("class_view")) {
				request.setAttribute("page", page);
				ClassViewAction cva = new ClassViewAction();
				forward = cva.execute(request, response);
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			} else {
				request.setAttribute("page", page);
				RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
				rd.forward(request, response);
			}
		} else if(command.equals("/score.ga")) {
			ScoreAction sa = new ScoreAction();
			forward = sa.execute(request, response);
			response.sendRedirect(forward.getPath());
		} else if(command.equals("/student.ga")) {
			StudentAction stu = new StudentAction();
			forward = stu.execute(request, response);
			response.sendRedirect(forward.getPath());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
