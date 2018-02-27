package kr.or.dgit.it_3st_3team.type;

public enum UserGroup {
	CUSTOMER(1), COMPANY(2);
	
	private final int value;
	
	UserGroup(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static UserGroup valueOf(int value) {
		switch(value) {
		case 1: return CUSTOMER;
		case 2: return COMPANY;
		default: throw new AssertionError("Unknown value : " + value);
		}
	}
}
