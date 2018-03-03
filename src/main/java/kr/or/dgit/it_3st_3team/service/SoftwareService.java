package kr.or.dgit.it_3st_3team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.Software;
import kr.or.dgit.it_3st_3team.utils.MyBatisSqlSessionFactory;

public class SoftwareService {
	private static final SoftwareService instance = new SoftwareService();
	private static final Log log = LogFactory.getLog(SoftwareService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.SoftwareDao.";

	public static SoftwareService getInstance() {
		return instance;
	}

	private SoftwareService() {
	}
	
	public Software selectSoftwareByNo(Software software) {
		log.debug("selectSoftwareByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectSoftwareByNo", software);
		}
	}
	
	public List<Software> selectSoftwareByAll(){
		log.debug("selectSoftwareByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSoftwareByAll");
		}
	}
	
	public int insertSoftware(Software software) {
		log.debug("insertSoftware()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertSoftware", software);
			sqlSession.commit();
		}
		return res;
	}
	
	public int deleteSoftware(Software swNo) {
		log.debug("deleteSoftware()");
		int res=-1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res= sqlSession.delete(namespace + "deleteSoftware", swNo);
			sqlSession.commit();
		}
		return res;
	}
	
	public int updateSoftware(Software software) {
		log.debug("updateSoftware()");
		int res=-1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res= sqlSession.update(namespace + "updateSoftware", software);
			sqlSession.commit();
		}
		return res;
	}
	
}
