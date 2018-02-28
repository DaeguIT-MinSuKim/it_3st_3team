package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.AddressService;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;

public class AddressTest {
		private static AddressService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = AddressService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void testAselcectAddressBySido() {
		List<Address> listad = service.selcectAddressBySido();
		System.out.println(listad);
		assertNotNull(listad);
		for(Address ad : listad) {
			System.out.println(ad.getSido());
		}
	}
	
	@Test
	public void testBselcectAddressBySigungu() {
		List<Address> listad = service.selcectAddressBySigungu(new Address("대구광역시"));
		System.out.println(listad);
		assertNotNull(listad);
		for(Address ad : listad) {
			System.out.println(ad.getSigungu());
		}
	}
	
	@Test
	public void testCselectAddressByDoro() {
		Address ad = new Address();
		ad.setSigungu("달서구");
		ad.setDoro("진천로");
		ad.setBuilding1(0);
		ad.setBuilding2(0);
		List<Address> listad = service.selectAddressByDoro(ad);
		//Address res = service.selectAddressByDoro(ad);
		assertNotNull(listad);
		for(Address adr : listad) {
			System.out.println(adr);
		}
		//assertEquals(ad.getBuilding1(), res.getBuilding1());

	}

}
