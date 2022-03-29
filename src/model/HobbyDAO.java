package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HobbyDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public void getCon() {

		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");

			con = ds.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertHobby(HobbyBean hbean) {
		getCon();
		try {
			String sql = "INSERT INTO TBL_HOBBY VALUES(SEQ_HOBBY.NEXTVAL,?,?,?,?,SYSDATE,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hbean.getHobbyTitle());
			pstmt.setString(2, hbean.getHobbyLo());
			pstmt.setString(3, hbean.getHobbyContent());
			pstmt.setString(4, hbean.getHobbyImg());
			pstmt.setString(5, hbean.getMemberID());
			pstmt.setInt(6, hbean.getHobbyCount());

			pstmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HobbyBean> getAllHobby(int startRow, int endRow) {
		ArrayList<HobbyBean> beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RNUM FROM(SELECT * FROM TBL_HOBBY ORDER BY HOBBY_NO DESC)A) WHERE RNUM >= ? AND RNUM<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HobbyBean bean = new HobbyBean();
				bean.setHobbyNo(rs.getInt(1));
				bean.setHobbyTitle(rs.getString(2));
				bean.setHobbyLo(rs.getString(3));
				bean.setHobbyContent(rs.getString(4));
				bean.setHobbyImg(rs.getString(5));
				bean.setHobbyDate(rs.getDate(6));
				bean.setMemberID(rs.getString(7));
				bean.setHobbyCount(rs.getInt(8));

				beans.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return beans;
	}

	public ArrayList<HobbyBean> getLocationHobby(String hobbyLo, int startRow, int endRow) {
		ArrayList<HobbyBean> beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RNUM FROM (SELECT * FROM TBL_HOBBY WHERE HOBBY_LO=? ORDER BY HOBBY_NO DESC)A) WHERE RNUM >=? AND RNUM<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyLo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HobbyBean bean = new HobbyBean();
				bean.setHobbyNo(rs.getInt(1));
				bean.setHobbyTitle(rs.getString(2));
				bean.setHobbyLo(rs.getString(3));
				bean.setHobbyContent(rs.getString(4));
				bean.setHobbyImg(rs.getString(5));
				bean.setHobbyDate(rs.getDate(6));
				bean.setMemberID(rs.getString(7));
				bean.setHobbyCount(rs.getInt(8));

				beans.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return beans;
	}

	public ArrayList<HobbyBean> getKeywordHobby(String keyword, int startRow, int endRow) {
		ArrayList<HobbyBean> beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RNUM FROM (SELECT * FROM TBL_HOBBY WHERE HOBBY_TITLE LIKE ? OR HOBBY_CONTENT LIKE ? ORDER BY HOBBY_NO DESC)A) WHERE RNUM >=? AND RNUM<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HobbyBean bean = new HobbyBean();
				bean.setHobbyNo(rs.getInt(1));
				bean.setHobbyTitle(rs.getString(2));
				bean.setHobbyLo(rs.getString(3));
				bean.setHobbyContent(rs.getString(4));
				bean.setHobbyImg(rs.getString(5));
				bean.setHobbyDate(rs.getDate(6));
				bean.setMemberID(rs.getString(7));
				bean.setHobbyCount(rs.getInt(8));

				beans.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

	public ArrayList<HobbyBean> getKeywordLoHobby(String hobbyLo, String keyword, int startRow, int endRow) {
		ArrayList<HobbyBean> beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM (SELECT A.*, ROWNUM RNUM FROM (SELECT * FROM TBL_HOBBY WHERE HOBBY_LO=? AND (HOBBY_TITLE LIKE ? OR HOBBY_CONTENT LIKE ?) ORDER BY HOBBY_NO DESC)A)"
					+ " WHERE RNUM >= ? AND RNUM <=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyLo);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				HobbyBean bean = new HobbyBean();
				bean.setHobbyNo(rs.getInt(1));
				bean.setHobbyTitle(rs.getString(2));
				bean.setHobbyLo(rs.getString(3));
				bean.setHobbyContent(rs.getString(4));
				bean.setHobbyImg(rs.getString(5));
				bean.setHobbyDate(rs.getDate(6));
				bean.setMemberID(rs.getString(7));
				bean.setHobbyCount(rs.getInt(8));

				beans.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

	public int getAllCount() {
		getCon();

		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM TBL_HOBBY";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int getLocationCount(String hobbyLo) {
		getCon();

		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM TBL_HOBBY WHERE HOBBY_LO=? ORDER BY HOBBY_NO DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyLo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getKeywordCount(String keyword) {
		getCon();

		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM TBL_HOBBY WHERE HOBBY_TITLE LIKE ? OR HOBBY_CONTENT LIKE ? ORDER BY HOBBY_NO DESC ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public int getKeywordLoCount(String hobbyLo, String keyword) {
		getCon();

		int count = 0;
		try {
			String sql = "SELECT COUNT(*) FROM TBL_HOBBY WHERE HOBBY_LO=? AND (HOBBY_TITLE LIKE ? OR HOBBY_CONTENT LIKE ?) ORDER BY HOBBY_NO DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyLo);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public HobbyBean getHobbyDetail(int hobbyNo) {
		getCon();
		HobbyBean bean = new HobbyBean();
		
		try {
			String sql = "SELECT * FROM TBL_HOBBY WHERE HOBBY_NO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hobbyNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				bean.setHobbyNo(rs.getInt(1));
				bean.setHobbyTitle(rs.getString(2));
				bean.setHobbyLo(rs.getString(3));
				bean.setHobbyContent(rs.getString(4));
				bean.setHobbyImg(rs.getString(5));
				bean.setHobbyDate(rs.getDate(6));
				bean.setMemberID(rs.getString(7));
				bean.setHobbyCount(rs.getInt(8));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return bean;
	}

	public void updateImg(String hobbyImg,int hobbyNo) {
		getCon();
		try {
			String sql = "UPDATE TBL_HOBBY SET HOBBY_IMG=? WHERE HOBBY_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyImg);
			pstmt.setInt(2, hobbyNo);
			
			pstmt.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public void updateHobby(HobbyBean bean) {

		getCon();
		try {
			String sql = "UPDATE TBL_HOBBY SET HOBBY_TITLE=? , HOBBY_CONTENT=?,HOBBY_LO=?, HOBBY_COUNT=? WHERE HOBBY_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getHobbyTitle());
			pstmt.setString(2, bean.getHobbyContent());
			pstmt.setString(3, bean.getHobbyLo());
			pstmt.setInt(4, bean.getHobbyCount());
			pstmt.setInt(5, bean.getHobbyNo());
			
			pstmt.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteHobby(int hobbyNo) {
		getCon();
		
		try {
			String sql = "DELETE FROM TBL_HOBBY WHERE HOBBY_NO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hobbyNo);
			pstmt.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
