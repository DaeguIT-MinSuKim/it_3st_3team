package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.service.UserService;
import kr.or.dgit.it_3st_3team.type.UserGroup;

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
	
	@Test
	public void test2ListUserAll() {
		List<User> lists = service.listUserAll();
		System.out.println(lists);
		
		assertNotNull(lists);
		for (User u : lists) {
			System.out.println(u);
		}
	}
	
	@Test
	public void test3listUserAllByUserGroup() {
		List<User> lists = service.listUserAllByUserGroup(UserGroup.CUSTOMER);
		System.out.println(lists);
		
		assertNotNull(lists);
		for (User u : lists) {
			assertEquals(u.getUserGroup(), UserGroup.CUSTOMER);
			System.out.println(u);
		}
		/*
		lists.clear();
		lists = service.listUserAllByUserGroup(UserGroup.COMPANY);
		System.out.println(lists);
		
		assertNotNull(lists);
		for (User u : lists) {
			System.out.println(u);
		}
		*/
	}

	@Test
	public void test4AddUser() {
		// User user = new User(userNo, userId, userPwd, name, email, phone, zipcode, addr1, addr2, userGroup, admin);
		// int res = service.addUser(user);
		
		// assertEquals(1, res);
	}
}
