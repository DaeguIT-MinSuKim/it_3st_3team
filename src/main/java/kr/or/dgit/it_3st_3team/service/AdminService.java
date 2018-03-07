package kr.or.dgit.it_3st_3team.service;

import java.util.List;

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

	public List<Admin> selectAdminAll() {
		log.debug("selectAdminAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAdminAll");
		}
	}
}
