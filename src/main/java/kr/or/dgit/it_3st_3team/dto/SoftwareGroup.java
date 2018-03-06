package kr.or.dgit.it_3st_3team.dto;

public class SoftwareGroup {
	private int sgNo;
	private String sgName;
	
	
	
	public SoftwareGroup(int sgNo) {
		super();
		this.sgNo = sgNo;
	}

	public SoftwareGroup(String sgName) {
		this.sgName = sgName;
	}

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
		return String.format("%s", sgName);

	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return new Object[] {String.format("%s",sgName)};

	}

	
}
