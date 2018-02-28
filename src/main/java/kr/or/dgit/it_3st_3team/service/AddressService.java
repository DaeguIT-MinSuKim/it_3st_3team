package kr.or.dgit.it_3st_3team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.util.MyBatisSqlSessionFactory;


public class AddressService {
	private static final AddressService instance = new AddressService();
	private static final Log log = LogFactory.getLog(AddressService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.AddressDao.";

	public static AddressService getInstance() {
		return instance;
	}

	private AddressService() {
	}
	
	
	
	public List<Address> selcectAddressBySido(){
		log.debug("selcectAddressBySido()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selcectAddressBySido");
		}
	}
	
	public List<Address> selcectAddressBySigungu(Address address) {
		log.debug("selcectAddressBySigungu()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selcectAddressBySigungu", address);
		}
	}
	
	public List<Address> selectAddressByDoro(Address address) {
		log.debug("selectAddressByDoro()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAddressByDoro", address);
		}
	}
	
	
	
	
}
