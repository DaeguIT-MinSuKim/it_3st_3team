package kr.or.dgit.it_3st_3team.type;

public enum AdminGroupAuth {
	ADMINISTRATOR(9), SALESMAN(1);
	
	private final int value;
	
	AdminGroupAuth(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static AdminGroupAuth valueOf(int value) {
		switch(value) {
		case 1: return SALESMAN;
		case 9: return ADMINISTRATOR;
		default: throw new AssertionError("Unknown value : " + value);
		}
	}
}
