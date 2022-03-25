package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

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

	public void joinMember(MemberBean bean) {
		getCon();
		try {
			String sql = "INSERT INTO TBL_MEMBER VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMemberID());
			pstmt.setString(2, bean.getMemberPassword());
			pstmt.setString(3, bean.getMemberPhone());
			pstmt.setString(4, bean.getMemberName());

			pstmt.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int idCheck(String memberID) {
		int result = 0;
		getCon();

		try {
			String sql = "SELECT * FROM TBL_MEMBER WHERE LOWER(MEMBER_ID)=LOWER(?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberID);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int memberLogin(String memberID, String memberPassword) {
		int result = 0;
		getCon();

		try {
			String sql = "SELECT * FROM TBL_MEMBER WHERE MEMBER_ID=? AND MEMBER_PASSWORD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberID);
			pstmt.setString(2, memberPassword);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public MemberBean getMember(String memberID) {
		MemberBean bean = new MemberBean();
		getCon();
		try {
			String sql = "SELECT * FROM TBL_MEMBER WHERE MEMBER_ID=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setMemberID(rs.getString(1));
				bean.setMemberPassword(rs.getString(2));
				bean.setMemberPhone(rs.getString(3));
				bean.setMemberName(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	public int updateMember(MemberBean bean) {
		int result = 0;
		getCon();
		try {
			String sql = "UPDATE TBL_MEMBER SET MEMBER_PASSWORD=?,MEMBER_NAME=?,MEMBER_PHONE=? WHERE MEMBER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getMemberPassword());
			pstmt.setString(2, bean.getMemberName());
			pstmt.setString(3, bean.getMemberPhone());
			pstmt.setString(4, bean.getMemberID());
			
			result = pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
