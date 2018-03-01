package kr.or.dgit.it_3st_3team.dto;

import java.util.Date;

import kr.or.dgit.it_3st_3team.type.Payment;

public class SaleOrder {
	private int ordNo;
	private User user;
	private Software software;
	private int ordQuantity;
	private int ordSupplyPrice;
	private int ordSellPrice;
	private int ordTax;
	private int ordSellProfit;
	private Payment ordPayment;
	private Date ordDatetime;
	private Admin admin;
	private SoftwareGroup softwaregroup;

	public SaleOrder() {
	}

	public SaleOrder(int ordNo) {
		this.ordNo = ordNo;
	}

	public SaleOrder(User user, Software software, Payment ordPayment, Date ordDatetime, Admin admin,
			SoftwareGroup softwaregroup) {
		super();
		this.user = user;
		this.software = software;
		this.ordPayment = ordPayment;
		this.ordDatetime = ordDatetime;
		this.admin = admin;
		this.softwaregroup = softwaregroup;
	}

	public SaleOrder(int ordNo, User user, Software software, Payment ordPayment, Date ordDatetime, Admin admin,
			SoftwareGroup softwaregroup) {
		super();
		this.ordNo = ordNo;
		this.user = user;
		this.software = software;
		this.ordPayment = ordPayment;
		this.ordDatetime = ordDatetime;
		this.admin = admin;
		this.softwaregroup = softwaregroup;
	}

	public SaleOrder(int ordNo, User user, Software software, int ordQuantity, int ordSupplyPrice, int ordSellPrice,
			int ordTax, int ordSellProfit, Payment ordPayment, Date ordDatetime, Admin admin) {
		super();
		this.ordNo = ordNo;
		this.user = user;
		this.software = software;
		this.ordQuantity = ordQuantity;
		this.ordSupplyPrice = ordSupplyPrice;
		this.ordSellPrice = ordSellPrice;
		this.ordTax = ordTax;
		this.ordSellProfit = ordSellProfit;
		this.ordPayment = ordPayment;
		this.ordDatetime = ordDatetime;
		this.admin = admin;
	}
	
	public SaleOrder(int ordNo, User user, Software software, int ordQuantity, int ordSupplyPrice, int ordSellPrice,
			int ordTax, int ordSellProfit, Payment ordPayment, Date ordDatetime, Admin admin,
			SoftwareGroup softwaregroup) {
		super();
		this.ordNo = ordNo;
		this.user = user;
		this.software = software;
		this.ordQuantity = ordQuantity;
		this.ordSupplyPrice = ordSupplyPrice;
		this.ordSellPrice = ordSellPrice;
		this.ordTax = ordTax;
		this.ordSellProfit = ordSellProfit;
		this.ordPayment = ordPayment;
		this.ordDatetime = ordDatetime;
		this.admin = admin;
		this.softwaregroup = softwaregroup;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public SoftwareGroup getSoftwaregroup() {
		return softwaregroup;
	}

	public void setSoftwaregroup(SoftwareGroup softwaregroup) {
		this.softwaregroup = softwaregroup;
	}

	@Override
	public String toString() {
		return String.format(
				"SaleOrder [ordNo=%s, user=%s, software=%s, ordQuantity=%s, ordSupplyPrice=%s, ordSellPrice=%s, ordTax=%s, ordSellProfit=%s, ordPayment=%s, ordDatetime=%s, admin=%s, softwaregroup=%s]",
				ordNo, user, software, ordQuantity, ordSupplyPrice, ordSellPrice, ordTax, ordSellProfit, ordPayment,
				ordDatetime, admin, softwaregroup);
	}

	public Object[] toArray() {
		return new Object[] {
				ordNo, "고객명",/*softwaregroup.getSgName()*/"분류",software.getSwName(),
				ordQuantity,ordSupplyPrice,ordSellPrice,ordTax,ordSellProfit,
				ordPayment,"공급회사명", ordDatetime,admin.getAdminName()
				/*String.format("%s", user.getName())*/
		};
	}
}
