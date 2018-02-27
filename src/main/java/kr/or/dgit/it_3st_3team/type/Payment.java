package kr.or.dgit.it_3st_3team.type;

public enum Payment {
	BANK(1), ATM(2), CARD(3), MOBILE(4), SIMPLE(5);
	
	private final int value;
	
	Payment(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Payment valueOf(int value) {
		switch(value) {
		case 1: return BANK;
		case 2: return ATM;
		case 3: return CARD;
		case 4: return MOBILE;
		case 5: return SIMPLE;
		default: throw new AssertionError("Unknown value : " + value);
		}
	}
}
