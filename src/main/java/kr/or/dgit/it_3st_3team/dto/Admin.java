package kr.or.dgit.it_3st_3team.dto;

public class Admin {
	private int adminNo;
	private String adminId;
	private String adminName;
	private String adminPwd;
	private PhoneNumber phone;
	private AdminGroup adminGroup;

	public Admin() {
	}

	public Admin(int adminNo) {
		this.adminNo = adminNo;
	}

	public Admin(String adminName) {
		this.adminName = adminName;
	}

	public Admin(String adminId, String adminPwd) {
		this.adminId = adminId;
		this.adminPwd = adminPwd;
	}

	public Admin(int adminNo, String adminId, String adminName, String adminPwd, PhoneNumber phone,
			AdminGroup adminGroup) {
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.phone = phone;
		this.adminGroup = adminGroup;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public AdminGroup getAdminGroup() {
		return adminGroup;
	}

	public void setAdminGroup(AdminGroup adminGroup) {
		this.adminGroup = adminGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminNo != other.adminNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s", adminName);
	}
}
