package kr.or.dgit.it_3st_3team.dto;

import java.util.Date;

import kr.or.dgit.it_3st_3team.type.Payment;

public class SaleOrder {
	private int ordNo;
	private User userNo;
	private Software swNo;
	private int ordQuantity;
	private int ordSupplyPrice;
	private int ordSellPrice;
	private int ordTax;
	private int ordSellProfit;
	private Payment ordPayment;
	private Date ordDatetime;
	private Admin adminNo;

	public SaleOrder() {
	}

	public SaleOrder(int ordNo, User userNo, Software swNo, int ordQuantity, int ordSupplyPrice, int ordSellPrice,
			int ordTax, int ordSellProfit, Payment ordPayment, Date ordDatetime, Admin adminNo) {
		this.ordNo = ordNo;
		this.userNo = userNo;
		this.swNo = swNo;
		this.ordQuantity = ordQuantity;
		this.ordSupplyPrice = ordSupplyPrice;
		this.ordSellPrice = ordSellPrice;
		this.ordTax = ordTax;
		this.ordSellProfit = ordSellProfit;
		this.ordPayment = ordPayment;
		this.ordDatetime = ordDatetime;
		this.adminNo = adminNo;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public User getUserNo() {
		return userNo;
	}

	public void setUserNo(User userNo) {
		this.userNo = userNo;
	}

	public Software getSwNo() {
		return swNo;
	}

	public void setSwNo(Software swNo) {
		this.swNo = swNo;
	}

	public int getOrdQuantity() {
		return ordQuantity;
	}

	public void setOrdQuantity(int ordQuantity) {
		this.ordQuantity = ordQuantity;
	}

	public int getOrdSupplyPrice() {
		return ordSupplyPrice;
	}

	public void setOrdSupplyPrice(int ordSupplyPrice) {
		this.ordSupplyPrice = ordSupplyPrice;
	}

	public int getOrdSellPrice() {
		return ordSellPrice;
	}

	public void setOrdSellPrice(int ordSellPrice) {
		this.ordSellPrice = ordSellPrice;
	}

	public int getOrdTax() {
		return ordTax;
	}

	public void setOrdTax(int ordTax) {
		this.ordTax = ordTax;
	}

	public int getOrdSellProfit() {
		return ordSellProfit;
	}

	public void setOrdSellProfit(int ordSellProfit) {
		this.ordSellProfit = ordSellProfit;
	}

	public Payment getOrdPayment() {
		return ordPayment;
	}

	public void setOrdPayment(Payment ordPayment) {
		this.ordPayment = ordPayment;
	}

	public Date getOrdDatetime() {
		return ordDatetime;
	}

	public void setOrdDatetime(Date ordDatetime) {
		this.ordDatetime = ordDatetime;
	}

	public Admin getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(Admin adminNo) {
		this.adminNo = adminNo;
	}

	@Override
	public String toString() {
		return String.format(
				"SaleOrder [ordNo=%s, userNo=%s, swNo=%s, ordQuantity=%s, ordSupplyPrice=%s, ordSellPrice=%s, ordTax=%s, ordSellProfit=%s, ordPayment=%s, ordDatetime=%s, adminNo=%s]",
				ordNo, userNo, swNo, ordQuantity, ordSupplyPrice, ordSellPrice, ordTax, ordSellProfit, ordPayment,
				ordDatetime, adminNo);
	}

}
