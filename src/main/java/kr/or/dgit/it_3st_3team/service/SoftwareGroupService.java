package kr.or.dgit.it_3st_3team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.util.MyBatisSqlSessionFactory;

public class SoftwareGroupService {
	private static final SoftwareGroupService instance = new SoftwareGroupService();
	private static final Log log = LogFactory.getLog(SoftwareGroupService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.SoftwareGroupDao.";

	public static SoftwareGroupService getInstance() {
		return instance;
	}

	private SoftwareGroupService() {
	}
	
	public SoftwareGroup selectSoftwareGroupByNo(SoftwareGroup softwaregroup) {
		log.debug("selectSoftwareGroupByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectSoftwareGroupByNo", softwaregroup);
		}
	}
	
	public List<SoftwareGroup> selectSoftwareGroupByAll(){
		log.debug("selectSoftwareGroupByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSoftwareGroupByAll");
		}
	}
	
	public int insertSoftwareGroup(SoftwareGroup softwaregroup) {
		log.debug("insertSoftwareGroup()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.insert(namespace + "insertSoftwareGroup", softwaregroup);
			sqlSession.commit();
		}
		return res;
	}
	
	public int deleteSoftwareGroup(SoftwareGroup sgNo) {
		log.debug("deleteSoftwareGroup()");
		int res=-1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res= sqlSession.delete(namespace + "deleteSoftwareGroup", sgNo);
			sqlSession.commit();
		}
		return res;
	}
}
