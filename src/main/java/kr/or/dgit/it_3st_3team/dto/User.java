package kr.or.dgit.it_3st_3team.dto;

import kr.or.dgit.it_3st_3team.type.UserGroup;

public class User {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String zipCode;
	private String address;
	private PhoneNumber phone;
	private UserGroup userGroup;
	private Admin admin;
	
	public User() {}

	public User(int userNo, String userId, String userPwd, String userName, String zipCode, String address,
			PhoneNumber phone, UserGroup userGroup, Admin admin) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.zipCode = zipCode;
		this.address = address;
		this.phone = phone;
		this.userGroup = userGroup;
		this.admin = admin;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return String.format(
				"User [userNo=%s, userId=%s, userPwd=%s, userName=%s, zipCode=%s, address=%s, phone=%s, userGroup=%s, admin=%s]",
				userNo, userId, userPwd, userName, zipCode, address, phone, userGroup, admin);
	}
	
}
