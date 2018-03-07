package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.service.AdminGroupService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminGroupServiceTest {
	private static AdminGroupService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = AdminGroupService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1ListAdminGroupByAll() {
		List<AdminGroup> list = service.listAdminGroupByAll();
		assertNotNull(list);
		
		for (AdminGroup ag : list) {
			System.out.println(ag);
		}
	}
	
	@Test
	public void test2FindAdminByNo() {
		AdminGroup adGroup = new AdminGroup();
		adGroup.setAgNo(1);
		
		AdminGroup findAdGroup = service.findAdminByNo(adGroup);
		assertNotNull(findAdGroup);
		System.out.println(findAdGroup);
		
		assertEquals(adGroup.getAgNo(), findAdGroup.getAgNo());
	}

}
