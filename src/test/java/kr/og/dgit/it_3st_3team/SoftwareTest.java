package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;
import kr.or.dgit.it_3st_3team.service.SoftwareService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		/*User user = new User();
		user.setName("크라이스");
		sw.setUserNo(user);*/
		
		Software findsw = service.selectSoftwareByNo(sw);
		
		
		assertNotNull(findsw);
		assertEquals(sw.getSwNo(), findsw.getSwNo());
	}
	
	@Test
	public void testEselectSoftwareBySearch() {
		Map<String, String> map = new HashMap<>();
		
		// searchBy = 공급회사 or 품목명 or 분류
		// searchText = "";
		map.put("searchBy", "company");
		//map.put("searchBy", "swName");
		//map.put("searchBy", "swGroup");
		map.put("searchText", "크라이스");
		
		List<Software> listpc = service.selectSoftwareBySearch(map);
		assertNotNull(listpc);
		
	}
	
	@Test
	public void select1FindSoftwareByOrder() {
		Software sw = new Software();
		sw.setSwGroup(new SoftwareGroup("게임"));
		User us = new User();
		us.setName("크라이스");
		sw.setUserNo(us);
		sw.setSwName("");
		
		List<Software> findsw = service.findSoftwareByOrder(sw);
		System.out.println(sw);
		for(Software s : findsw) {
			System.out.println(s);
		}
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
		/*Software sw = new Software("배고파", 123456, 354411, new SoftwareGroup(2), 100, new User(4));
		int res = service.insertSoftware(sw);
		System.out.println(sw);
		
		assertEquals(1, res);*/
	}
	
	@Test
	public void testDupdateSoftware() {
		/*Software sw = new Software(11);
		sw.setSwGroup(new SoftwareGroup(2));
		sw.setSwName("집에갈래");
		sw.setSwQuantity(250);
		sw.setSwSupplyPrice(3000);
		sw.setSwSellPrice(50000);
		sw.setUserNo(new User(1));
		
		int res = service.updateSoftware(sw);
		assertEquals(1, res);*/
	}
	

	@Test
	public void testFdeleteSoftware() {
		int res = service.deleteSoftware(new Software("ㄴㄴㄴ"));
		assertEquals(1, res);
	}


	

}
