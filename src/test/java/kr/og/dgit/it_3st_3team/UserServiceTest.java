package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.PhoneNumber;
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
	public void test11FindUserByLogin() {
		User user = new User("uid1", "uid1");
		User findUser = service.findUserByLogin(user);
		System.out.println(findUser);
		
		assertNotNull(findUser);
		assertEquals(user.getUserId(), findUser.getUserId());
	}
	
	@Test
	public void test12FindUserById() {
		User user = new User("uid1");
		User findUser = service.findUserById(user);
		System.out.println(findUser);
		
		assertNotNull(findUser);
		assertEquals(user.getUserId(), findUser.getUserId());
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
		User user = new User("uid7", "uid7", "테스트유저", "uid7@test.com", 
				new PhoneNumber("010-1122-3344"), "11234", "테스트시 되지는않구 오류만나로", "233-2", 
				"nobody.png", UserGroup.CUSTOMER, new Admin(1));
		int res = service.addUser(user);
		
		assertEquals(1, res);
	}
	
	@Test
	public void test5ModifyUser() {
		User user = new User("uid7", "테스트유저111", "uid7111@test.com", 
				new PhoneNumber("010-5566-2462"), "88563", "테스트시 되지는않구 오류만나로", "233-2", 
				"nobody.png", UserGroup.COMPANY, new Admin(2));
		int res = service.modifyUser(user);
		
		assertEquals(1, res);
	}
	
	@Test
	public void test6RemoveUser() {
		User user = new User("uid7");
		int res = service.removeUser(user);
		
		assertEquals(1, res);
	}
	
	@Test
	public void test7FindUserByLogin() {
		User user = new User("uid1", "uid1");
		User findUser = service.findUserByLogin(user);
		System.out.println(findUser);
		
		assertNotNull(findUser);
		assertEquals(user.getUserId(), findUser.getUserId());
	}
}
