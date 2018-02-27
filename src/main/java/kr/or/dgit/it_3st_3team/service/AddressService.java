package kr.or.dgit.it_3st_3team.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.Address;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.ui.util.MyBatisSqlSessionFactory;

public class AddressService {
	private static final AddressService instance = new AddressService();
	private static final Log log = LogFactory.getLog(AddressService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.AddressDao.";

	public static AddressService getInstance() {
		return instance;
	}

	private AddressService() {
	}
	
	
	
	public List<Address> selectAddressByAll(){
		log.debug("selectAddressByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectAddressByAll");
		}
	}
	
	
}
