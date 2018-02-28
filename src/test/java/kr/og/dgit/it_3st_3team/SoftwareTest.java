package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;

public class SoftwareTest {
		private static SoftwareService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = SoftwareService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void testAselectSoftwareByNo() {
		Software sw = new Software();
		sw.setSwNo(1);
		Software findsw = service.selectSoftwareByNo(sw);
		System.out.println(findsw);
		
		assertNotNull(findsw);
		assertEquals(sw.getSwNo(), findsw.getSwNo());
	}
	
	@Test
	public void testBselectSoftwareByAll() {
		List<Software> listsw = service.selectSoftwareByAll();
		System.out.println(listsw);
		assertNotNull(listsw);
		for(Software sw : listsw) {
			System.out.println(sw);
		}
	}
	
	@Test
	public void testCinsertSoftware() {
		Software sw = new Software("배고파", 123456, 354411, new SoftwareGroup(2), 100, new User(3));
		int res = service.insertSoftware(sw);
		System.out.println(sw);
		
		assertEquals(1, res);
	}
	
	@Test
	public void testDupdateSoftware() {
		Software sw = new Software(11);
		sw.setSwGroup(new SoftwareGroup(2));
		sw.setSwName("집에갈래");
		sw.setSwQuantity(250);
		sw.setSwSupplyPrice(3000);
		sw.setSwSellPrice(50000);
		sw.setUserNo(new User(1));
		
		int res = service.updateSoftware(sw);
		assertEquals(1, res);
	}
	
	@Test
	public void testFdeleteSoftware() {
		int res = service.deleteSoftware(new Software(11));
		assertEquals(1, res);
	}
	
	

}
