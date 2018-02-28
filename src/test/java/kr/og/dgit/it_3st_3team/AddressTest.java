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
			System.out.println(ad);
		}
	}
	
	@Test
	public void testBselcectAddressBySigungu() {
		List<Address> listad = service.selcectAddressBySigungu(new Address("대구광역시"));
		System.out.println(listad);
		assertNotNull(listad);
		for(Address ad : listad) {
			System.out.println(ad);
		}
	}
	

}
