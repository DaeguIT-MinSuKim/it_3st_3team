package kr.or.dgit.it_3st_3team.dto;

public class Software {
	private int swNo;
	private String swName;
	private int swSupplyPrice;
	private int swSellPrice;
	private SoftwareGroup swGroup;
	private User userNo;

	public Software() {
	}

	public Software(int swNo, String swName, int swSupplyPrice, int swSellPrice, SoftwareGroup swGroup, User userNo) {
		this.swNo = swNo;
		this.swName = swName;
		this.swSupplyPrice = swSupplyPrice;
		this.swSellPrice = swSellPrice;
		this.swGroup = swGroup;
		this.userNo = userNo;
	}

	public int getSwNo() {
		return swNo;
	}

	public void setSwNo(int swNo) {
		this.swNo = swNo;
	}

	public String getSwName() {
		return swName;
	}

	public void setSwName(String swName) {
		this.swName = swName;
	}

	public int getSwSupplyPrice() {
		return swSupplyPrice;
	}

	public void setSwSupplyPrice(int swSupplyPrice) {
		this.swSupplyPrice = swSupplyPrice;
	}

	public int getSwSellPrice() {
		return swSellPrice;
	}

	public void setSwSellPrice(int swSellPrice) {
		this.swSellPrice = swSellPrice;
	}

	public SoftwareGroup getSwGroup() {
		return swGroup;
	}

	public void setSwGroup(SoftwareGroup swGroup) {
		this.swGroup = swGroup;
	}

	public User getUserNo() {
		return userNo;
	}

	public void setUserNo(User userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return String.format("Software [swNo=%s, swName=%s, swSupplyPrice=%s, swSellPrice=%s, swGroup=%s, userNo=%s]",
				swNo, swName, swSupplyPrice, swSellPrice, swGroup, userNo);
	}

}
