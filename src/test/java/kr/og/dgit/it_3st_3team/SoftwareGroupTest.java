package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SoftwareGroupService;

public class SoftwareGroupTest {
		private static SoftwareGroupService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = SoftwareGroupService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void testAselectSoftwareGroupByNo() {
		SoftwareGroup sg = new SoftwareGroup();
		sg.setSgNo(1);
		SoftwareGroup findsg = service.selectSoftwareGroupByNo(sg);
		System.out.println(findsg);
		
		assertNotNull(findsg);
		assertEquals(sg.getSgNo(), findsg.getSgNo());
	}
	
	@Test
	public void testBselectSoftwareGroupByAll() {
		List<SoftwareGroup> listsg = service.selectSoftwareGroupByAll();
		System.out.println(listsg);
		assertNotNull(listsg);
		for(SoftwareGroup sg : listsg) {
			System.out.println(sg);
		}
	}
	
	/*@Test
	public void testCinsertSoftwareGroup() {
		SoftwareGroup sg = new SoftwareGroup(4, "디자인");
		int res = service.insertSoftwareGroup(sg);
		System.out.println(sg);
		
		assertEquals(1, res);
	}*/
	
	/*@Test
	public void testDdeleteSoftwareGroup() {
		int res = service.deleteSoftwareGroup(new SoftwareGroup("디자인"));
		
		assertEquals(1, res);
		System.out.println(res);
	}*/
	
	@Test
	public void testEupdateSoftwareGroup() {
		Map<String, String> map = new HashMap<>();
		map.put("changeSgName", "게임2");
		map.put("oriSgName", "실험2");
		
		int res = service.updateSoftwareGroup(map);
		
		assertEquals(1, res);
		System.out.println(res);
	}

}
