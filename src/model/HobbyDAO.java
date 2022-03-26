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

	public ArrayList<HobbyBean> getAllHobby() {
		ArrayList<HobbyBean>beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM TBL_HOBBY ORDER BY HOBBY_NO DESC";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
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

	public ArrayList<HobbyBean> getLocationHobby(String hobbyLo) {
		ArrayList<HobbyBean>beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM TBL_HOBBY WHERE HOBBY_LO=? ORDER BY HOBBY_NO DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyLo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
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

	public ArrayList<HobbyBean> getKeywordHobby(String keyword) {
		ArrayList<HobbyBean>beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM TBL_HOBBY WHERE HOBBY_TITLE LIKE ? OR HOBBY_CONTENT LIKE ? ORDER BY HOBBY_NO DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
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

	public ArrayList<HobbyBean> getKeywordLoHobby(String hobbyLo, String keyword) {
		ArrayList<HobbyBean>beans = new ArrayList<>();
		getCon();
		try {
			String sql = "SELECT * FROM TBL_HOBBY WHERE HOBBY_LO=? AND (HOBBY_TITLE LIKE ? OR HOBBY_CONTENT LIKE ?) ORDER BY HOBBY_NO DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, hobbyLo);
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setString(3, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
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

}
