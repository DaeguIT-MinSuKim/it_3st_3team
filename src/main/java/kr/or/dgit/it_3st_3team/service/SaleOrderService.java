package kr.or.dgit.it_3st_3team.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.User;
import kr.or.dgit.it_3st_3team.ui.util.MyBatisSqlSessionFactory;

public class SaleOrderService {
	private static final SaleOrderService instance = new SaleOrderService();
	private static final Log log = LogFactory.getLog(SaleOrderService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.SaleOrderDao.";

	public static SaleOrderService getInstance() {
		return instance;
	}

	public SaleOrderService() {

	}

	public SaleOrder findSaleOrderByNo(SaleOrder ordNo) {
		log.debug("findSaleOrderByNo()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectOne(namespace + "selectSaleOrderByNo", ordNo);
		}
	}

	public List<SaleOrder> findSaleOrderByMapWithAPI(Map<String, String> map) {
		log.debug("findSaleOrderByMapWithAPI()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSaleOrderWithAllByNo", map);
		}
	}

	// 주문관리

	public List<SaleOrder> selectOrderManagementByAll() {
		log.debug("selectOrderManagementByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectOrderManagementByAll");
		}
	}
}
