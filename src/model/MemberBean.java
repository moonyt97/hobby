package model;

public class MemberBean {

	private String memberID;
	private String memberPassword;
	private String memberPhone;
	private String memberName;
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "MemberBean [memberID=" + memberID + ", memberPassword=" + memberPassword + ", memberPhone="
				+ memberPhone + ", memberName=" + memberName + "]";
	}
	
	
}
