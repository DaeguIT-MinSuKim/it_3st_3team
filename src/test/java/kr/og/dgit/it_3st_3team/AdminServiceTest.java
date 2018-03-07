package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.service.AdminService;

public class AdminServiceTest {
	private static AdminService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = AdminService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1selectLogin() {
		Admin admin = new Admin("admin1", "admin1");
		
		Admin loginAdmin = service.findAdminByLogin(admin);
		System.out.println(loginAdmin);
		
		assertNotNull(loginAdmin);
		assertEquals(admin.getAdminId(), loginAdmin.getAdminId());
	}

	@Test
	public void test2ListAdminAll() {
		List<Admin> listad = service.listAdminAll();
		System.out.println(listad);
		assertNotNull(listad);
		for(Admin ad : listad) {
			System.out.println(ad);
		}
	}

	@Test
	public void test3FindAdminById() {
		Admin admin = new Admin();
		admin.setAdminId("admin1");
		
		Admin findAdmin = service.findAdminById(admin);
		System.out.println(findAdmin);
		
		assertNotNull(findAdmin);
		assertEquals(admin.getAdminId(), findAdmin.getAdminId());
	}
}
