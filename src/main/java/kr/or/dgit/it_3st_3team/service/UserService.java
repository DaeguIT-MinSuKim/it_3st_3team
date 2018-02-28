package kr.or.dgit.it_3st_3team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.type.UserGroup;
import kr.or.dgit.it_3st_3team.util.MyBatisSqlSessionFactory;

public class UserService {
	private static final UserService instance = new UserService();
	private static final Log log = LogFactory.getLog(UserService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.UserDao.";

	public static UserService getInstance() {
		return instance;
	}

	private UserService() {
	}
	
	public User findUserByNo(User userNo) {
		log.debug("findUserByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectUserByNo", userNo);
		}
	}
	
	public List<User> listUserAll() {
		log.debug("listUserAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectUserAll");
		}
	}
	
	public List<User> listUserAllByUserGroup(UserGroup userGroup) {
		log.debug("listUserAllByUserGroup()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectUserAllByUserGroup", userGroup);
		}
	}
	
	public User findUserByLogin(User user) {
		log.debug("listUserAllByUserGroup()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectUserByLogin", user);
		}
	}
	
	public int addUser(User user) {
		log.debug("addUser()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertUser", user);
			sqlSession.commit();
		}
		return res;
	}
	
	public int modifyUser(User user) {
		log.debug("modifyUser()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "updateUser", user);
			sqlSession.commit();
		}
		return res;
	}
	
	public int removeUser(User user) {
		log.debug("modifyUser()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "deleteUser", user);
			sqlSession.commit();
		}
		return res;
	}
}
