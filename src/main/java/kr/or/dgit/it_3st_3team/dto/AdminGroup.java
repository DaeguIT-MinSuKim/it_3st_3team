package kr.or.dgit.it_3st_3team.dto;

import kr.or.dgit.it_3st_3team.type.AdminGroupAuth;

public class AdminGroup {
	private int agNo;
	private String agName;
	private AdminGroupAuth agAuth;

	public AdminGroup() {}

	public AdminGroup(int agNo, String agName, AdminGroupAuth agAuth) {
		super();
		this.agNo = agNo;
		this.agName = agName;
		this.agAuth = agAuth;
	}

	public int getAgNo() {
		return agNo;
	}

	public void setAgNo(int agNo) {
		this.agNo = agNo;
	}

	public String getAgName() {
		return agName;
	}

	public void setAgName(String agName) {
		this.agName = agName;
	}

	public AdminGroupAuth getAgAuth() {
		return agAuth;
	}

	public void setAgAuth(AdminGroupAuth agAuth) {
		this.agAuth = agAuth;
	}

	@Override
	public String toString() {
		return String.format("%s", agName);
	}

}
