package kr.or.dgit.it_3st_3team.dto;

public class SoftwareGroup {
	private int sgNo;
	private String sgName;

	public SoftwareGroup() {
	}

	public SoftwareGroup(int sgNo, String sgName) {
		this.sgNo = sgNo;
		this.sgName = sgName;
	}

	public int getSgNo() {
		return sgNo;
	}

	public void setSgNo(int sgNo) {
		this.sgNo = sgNo;
	}

	public String getSgName() {
		return sgName;
	}

	public void setSgName(String sgName) {
		this.sgName = sgName;
	}

	@Override
	public String toString() {
		return String.format("(%s)%s", sgNo, sgName);
	}

}
