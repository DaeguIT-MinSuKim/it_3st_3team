package kr.or.dgit.it_3st_3team.dto;

public class Address {
	private String zipcode;
	private String sido;
	private String sigungu;
	private String doro;
	private int building1;
	private int building2;

	public Address(String sido) {
		this.sido = sido;
	}

	public Address() {

	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public int getBuilding1() {
		return building1;
	}

	public void setBuilding1(int building1) {
		this.building1 = building1;
	}

	public int getBuilding2() {
		return building2;
	}

	public void setBuilding2(int building2) {
		this.building2 = building2;
	}

	public Address(String zipcode, String sido, String sigungu, String doro, int building1, int building2) {

		this.zipcode = zipcode;
		this.sido = sido;
		this.sigungu = sigungu;
		this.doro = doro;
		this.building1 = building1;
		this.building2 = building2;
	}

	public Address(String sido, String sigungu, String doro, int building1, int building2) {
		super();
		this.sido = sido;
		this.sigungu = sigungu;
		this.doro = doro;
		this.building1 = building1;
		this.building2 = building2;
	}

	@Override
	public String toString() {
		return String.format("Address [zipcode=%s, sido=%s, sigungu=%s, doro=%s, building1=%s, building2=%s]", zipcode,
				sido, sigungu, doro, building1, building2);
	}

	public Object[] toArray() {

		return new Object[] {
				String.format("[%s] %s %s %s (%s - %s)", zipcode, sido, sigungu, doro, building1, building2) };
	}

	public String getFirstAddress() {
		return String.format("%s %s %s", sido, sigungu, doro);
	}
}
