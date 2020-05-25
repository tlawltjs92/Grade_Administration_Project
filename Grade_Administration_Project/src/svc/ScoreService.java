package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GradeDAO;
import vo.GradeVO;
import static db.UtilJdbc.*;

public class ScoreService {

	public ArrayList<GradeVO> getList() {
		ArrayList<GradeVO> list = new ArrayList<GradeVO>();
		
		Connection conn = getConnection();
		GradeDAO gradeDAO = GradeDAO.getInstance();
		gradeDAO.setConnection(conn);
		
		list = gradeDAO.ScoreList();
		close(conn);
		
		return list;
	}

}
