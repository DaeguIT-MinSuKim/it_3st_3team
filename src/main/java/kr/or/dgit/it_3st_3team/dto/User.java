package kr.or.dgit.it_3st_3team.dto;

import kr.or.dgit.it_3st_3team.type.UserGroup;

public class User {
	private int userNo;
	private String userId;
	private String userPwd;
	private String name;
	private String email;
	private PhoneNumber phone;
	private String zipcode;
	private String addr1;
	private String addr2;
	private UserGroup userGroup;
	private Admin admin;

	public User() {
	}

	public User(int userNo) {
		this.userNo = userNo;
	}

	public User(String userId) {
		this.userId = userId;
	}

	public User(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public User(String userId, String userPwd, String name, String email, PhoneNumber phone, String zipcode,
			String addr1, String addr2, UserGroup userGroup, Admin admin) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.userGroup = userGroup;
		this.admin = admin;
	}

	
	public User(String userId, String name, String email, PhoneNumber phone, String zipcode, String addr1,
			String addr2, UserGroup userGroup, Admin admin) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.userGroup = userGroup;
		this.admin = admin;
	}

	public User(int userNo, String userId, String userPwd, String name, String email, PhoneNumber phone, String zipcode,
			String addr1, String addr2, UserGroup userGroup, Admin admin) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
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
				"User [userNo=%s, userId=%s, userPwd=%s, name=%s, email=%s, phone=%s, zipcode=%s, addr1=%s, addr2=%s, userGroup=%s, admin=%s]",
				userNo, userId, userPwd, name, email, phone, zipcode, addr1, addr2, userGroup, admin);
	}

}
