package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ParticipateDAO {
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

	public void participateInsert(String memberID, int hobbyNo) {
		getCon();
		try {
			String sql = "INSERT INTO TBL_PARTICIPATE VALUES(SYSDATE,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hobbyNo);
			pstmt.setString(2, memberID);

			pstmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean isParticipate(int hobbyNo, String loginMember) {
		getCon();
		boolean flag = false;
		try {
			String sql = "SELECT * FROM TBL_PARTICIPATE WHERE HOBBY_NO=? AND MEMBER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hobbyNo);
			pstmt.setString(2, loginMember);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public int participateCount(int hobbyNo) {
		getCon();

		int count = 0;

		try {
			String sql = "SELECT COUNT(*) FROM TBL_PARTICIPATE WHERE HOBBY_NO=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hobbyNo);
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

	public void deleteParticipate(int hobbyNo, String loginMember) {
		getCon();
		
		try {
			String sql = "DELETE FROM TBL_PARTICIPATE WHERE HOBBY_NO=? AND MEMBER_ID=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hobbyNo);
			pstmt.setString(2, loginMember);
			pstmt.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
