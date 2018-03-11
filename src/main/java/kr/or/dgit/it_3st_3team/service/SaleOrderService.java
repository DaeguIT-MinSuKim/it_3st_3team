package kr.or.dgit.it_3st_3team.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.utils.MyBatisSqlSessionFactory;


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

	public List<SaleOrder> findSaleOrderWithAllBySearch(Map<String, String> map) {
		log.debug("findSaleOrderWithAllBySearch()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSaleOrderWithAllBySearch", map);
		}
	}
	
	public List<SaleOrder> findSaleOrderWithoutadminName(Map<String, String> map) {
		log.debug("findSaleOrderWithoutadminName()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSaleOrderWithoutadminName", map);
		}
	}
	
	public List<SaleOrder> findSaleOrderByAll() {
		log.debug("findSaleOrderByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSaleOrderByAll");
		}
	}

	// 주문관리
	public int updateOrderManagementNo(SaleOrder saleOrder) {
		log.debug("updateOrderManagementNo()");
		 int res=-1;
		 try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();){
			 res= sqlSession.update(namespace+ "updateOrderManagementNo", saleOrder);
			 sqlSession.commit();
			 }
		 return res;
	}
	
	 

	public int deleteSaleOrderByNo(SaleOrder ordNo) {
		log.debug("deleteSaleOrderByNo()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.delete(namespace + "deleteSaleOrderByNo", ordNo);
			sqlSession.commit();
		}
		return res;
	}
	
	// 품목별 차트 조건:영업사원,년도
	public List<Map<String, Integer>> selectSgGroupBySales(Map<String, String> map) {
		log.debug("selectSgGroupBySales()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSgGroupBySales", map);
		}
	}
	
	// 관리자 품목별 차트 조건:년도
		public List<Map<String, Integer>> selectSgGroupForYears(Map<String, String> map) {
			log.debug("selectSgGroupForYears()");
			try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
				return sqlSession.selectList(namespace + "selectSgGroupForYears", map);
			}
		}
		
	// 고객 품목별 차트 조건:년도
		public List<Map<String, Integer>> selectSgGroupCustomer(Map<String, String> map) {
			log.debug("selectSgGroupCustomer()");
			try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
				return sqlSession.selectList(namespace + "selectSgGroupCustomer", map);
			}
		}
	
	// 결제방법 차트
	public List<Map<String, Integer>> selectPaymentChartOption(Map<String, String> map) {
		log.debug("selectPaymentChartOption()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectPaymentChartOption", map);
		}
	}
}
