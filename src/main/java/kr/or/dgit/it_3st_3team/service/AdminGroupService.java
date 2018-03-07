package kr.or.dgit.it_3st_3team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.AdminGroup;
import kr.or.dgit.it_3st_3team.utils.MyBatisSqlSessionFactory;

public class AdminGroupService {
	private static AdminGroupService instance = new AdminGroupService();
	private static final Log log = LogFactory.getLog(AdminService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.AdminGroupDao.";

	public static AdminGroupService getInstance() {
		return instance;
	}

	private AdminGroupService() {
	}

	public AdminGroup findAdminByNo(AdminGroup adGroup) {
		log.debug("findAdminByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectAdminByNo", adGroup);
		}
	}
	
	public List<AdminGroup> listAdminGroupByAll() {
		log.debug("listAdminGroupByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAdminGroupByAll");
		}
	}
}
