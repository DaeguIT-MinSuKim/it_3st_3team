package kr.or.dgit.it_3st_3team.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.util.MyBatisSqlSessionFactory;

public class AdminService {
	private static final AdminService instance = new AdminService();
	private static final Log log = LogFactory.getLog(AdminService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.AdminService.";

	public static AdminService getInstance() {
		return instance;
	}

	private AdminService() {
	}
	
	public User findUserByNo(User userNo) {
		log.debug("insertAdmin()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "insertAdmin", userNo);
		}
	}
}