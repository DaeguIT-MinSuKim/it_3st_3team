package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	private static UserService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = UserService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindUserByNo() {
		User user = new User(1);
		User findUser = service.findUserByNo(user);
		System.out.println(findUser);
		
		assertNotNull(findUser);
		assertEquals(user.getUserNo(), findUser.getUserNo());
	}

}
