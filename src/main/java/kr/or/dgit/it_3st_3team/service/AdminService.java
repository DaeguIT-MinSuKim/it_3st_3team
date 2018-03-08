package kr.or.dgit.it_3st_3team.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.utils.MyBatisSqlSessionFactory;

public class AdminService {
	private static final AdminService instance = new AdminService();
	private static final Log log = LogFactory.getLog(AdminService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.AdminDao.";

	public static AdminService getInstance() {
		return instance;
	}

	private AdminService() {
	}

	public Admin findAdminByNo(Admin admin) {
		log.debug("findAdminByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAdminByNo", admin);
		}
	}
	
	public Admin findAdminByLogin(Admin admin) {
		log.debug("selectAdminByLogin()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAdminByLogin", admin);
		}
	}
	
	public Admin findAdminById(Admin admin) {
		log.debug("findAdminById()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAdminById", admin);
		}
	}

	public List<Admin> listAdminAll() {
		log.debug("listAdminAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAdminAll");
		}
	}
	
	public List<Admin> listAdminBySearch(Map<String, String> map) {
		log.debug("findAdminById()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAdminBySearch", map);
		}
	}
	
	public int addAdmin(Admin admin) {
		log.debug("addAdmin()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertAdmin", admin);
			sqlSession.commit();
		}
		return res;
	}
	
	public int modifyAdmin(Admin admin) {
		log.debug("modifyAdmin()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "updateAdmin", admin);
			sqlSession.commit();
		}
		return res;
	}
	
	public int removeAdmin(Admin admin) {
		log.debug("removeAdmin()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "deleteAdmin", admin);
			sqlSession.commit();
		}
		return res;
	}

}
