package model;

import java.util.Date;

public class HobbyBean {
	private int hobbyNo;
	private String hobbyTitle;
	private String hobbyLo;
	private String hobbyContent;
	private String hobbyImg;
	private Date hobbyDate;
	private String memberID;
	private int hobbyCount;
	private int currentCount;
	public int getHobbyNo() {
		return hobbyNo;
	}
	public void setHobbyNo(int hobbyNo) {
		this.hobbyNo = hobbyNo;
	}
	public String getHobbyTitle() {
		return hobbyTitle;
	}
	public void setHobbyTitle(String hobbyTitle) {
		this.hobbyTitle = hobbyTitle;
	}
	public String getHobbyLo() {
		return hobbyLo;
	}
	public void setHobbyLo(String hobbyLo) {
		this.hobbyLo = hobbyLo;
	}
	public String getHobbyContent() {
		return hobbyContent;
	}
	public void setHobbyContent(String hobbyContent) {
		this.hobbyContent = hobbyContent;
	}
	public String getHobbyImg() {
		return hobbyImg;
	}
	public void setHobbyImg(String hobbyImg) {
		this.hobbyImg = hobbyImg;
	}
	public Date getHobbyDate() {
		return hobbyDate;
	}
	public void setHobbyDate(Date hobbyDate) {
		this.hobbyDate = hobbyDate;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getHobbyCount() {
		return hobbyCount;
	}
	public void setHobbyCount(int hobbyCount) {
		this.hobbyCount = hobbyCount;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	@Override
	public String toString() {
		return "HobbyBean [hobbyNo=" + hobbyNo + ", hobbyTitle=" + hobbyTitle + ", hobbyLo=" + hobbyLo
				+ ", hobbyContent=" + hobbyContent + ", hobbyImg=" + hobbyImg + ", hobbyDate=" + hobbyDate
				+ ", memberID=" + memberID + ", hobbyCount=" + hobbyCount + ", currentCount=" + currentCount + "]";
	}
	

	
}
