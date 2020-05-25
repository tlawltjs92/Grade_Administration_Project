package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.proxy.annotation.Pre;

import static db.UtilJdbc.*;
import vo.GradeVO;

public class GradeDAO {
	Connection conn;
	
	private static GradeDAO gradeDAO;
	
	private GradeDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static GradeDAO getInstance() {
		if(gradeDAO == null) {
			gradeDAO = new GradeDAO();
		}
		return gradeDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public int score(GradeVO gradeVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("insert into exam values(?,?,?,?,?,?)");
			pstmt.setString(1, gradeVO.getSyear());
			pstmt.setString(2, gradeVO.getSclass());
			pstmt.setString(3, gradeVO.getSno());
			pstmt.setString(4, gradeVO.getKor());
			pstmt.setString(5, gradeVO.getEng());
			pstmt.setString(6, gradeVO.getMath());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int student(GradeVO gradeVO) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, gradeVO.getSyear());
			pstmt.setString(2, gradeVO.getSclass());
			pstmt.setString(3, gradeVO.getSno());
			pstmt.setString(4, gradeVO.getSname());
			pstmt.setString(5, gradeVO.getBirth());
			pstmt.setString(6, gradeVO.getGender());
			pstmt.setString(7, gradeVO.getTel1());
			pstmt.setString(8, gradeVO.getTel2());
			pstmt.setString(9, gradeVO.getTel3());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<GradeVO> ScoreList() {
		ArrayList<GradeVO> list = new ArrayList<GradeVO>();
		GradeVO gradeVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			pstmt = conn.prepareStatement("select e.syear, e.sclass, e.sno, e2.sname, e2.gender, e.kor, e.eng, e.math, sum(e.kor+e.eng+e.math) as sum, round(avg((e.kor+e.eng+e.math)/3),1) as avg from exam e join student e2 on (e.sclass=e2.sclass and e.sno=e2.sno) group by e.syear, e.sclass, e.sno, e2.sname, e2.gender, \r\n" + 
					"e.kor, e.eng, e.math order by e.sclass, e.sno");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				gradeVO = new GradeVO();
				
				gradeVO.setSyear(rs.getString("syear"));
				gradeVO.setSclass(rs.getString("sclass"));
				gradeVO.setSno(rs.getString("sno"));
				gradeVO.setSname(rs.getString("sname"));
				gradeVO.setGender(rs.getString("gender"));
				gradeVO.setKor(rs.getString("kor"));
				gradeVO.setEng(rs.getString("eng"));
				gradeVO.setMath(rs.getString("math"));
				gradeVO.setSum(rs.getString("sum"));
				gradeVO.setAvg(rs.getString("avg"));
				list.add(gradeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<GradeVO> ClassList() {
		ArrayList<GradeVO> list = new ArrayList<GradeVO>();
		GradeVO gradeVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select e.syear, e.sclass, t.tname, sum(e.kor) as kor_sum, sum(e.eng) as eng_sum, sum(math) as math_sum, count(*) as count from exam e join teacher t on (e.sclass=t.sclass) group by e.syear, e.sclass, t.tname order by e.sclass");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				gradeVO = new GradeVO();
				
				gradeVO.setSyear(rs.getString("syear"));
				gradeVO.setSclass(rs.getString("sclass"));
				gradeVO.setTname(rs.getString("tname"));
				gradeVO.setKor_sum(rs.getString("kor_sum"));
				gradeVO.setEng_sum(rs.getString("eng_sum"));
				gradeVO.setMath_sum(rs.getString("math_sum"));
				gradeVO.setCount(rs.getString("count"));
				list.add(gradeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
