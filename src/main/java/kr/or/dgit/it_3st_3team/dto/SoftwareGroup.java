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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sgNo;
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
		SoftwareGroup other = (SoftwareGroup) obj;
		if (sgNo != other.sgNo)
			return false;
		return true;
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
