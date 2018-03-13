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
	
	public List<SaleOrder> findSaleOrderAllByType(Map<String, String> map) {
		log.debug("findSaleOrderByAll()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSaleOrderAllByType", map);
		}
	}

	public int orderSoftwareByProc(SaleOrder saleOrder) {
		log.debug("orderSoftwareByProc()");
		int res = -1;
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			res = sqlSession.update(namespace + "insertOrderByProc", saleOrder);
			sqlSession.commit();
		}
		return res;
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
	public List<Map<String, Integer>> selectSwGroupBySales(Map<String, String> map) {
		log.debug("selectSwGroupBySales()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectSwGroupBySales", map);
		}
	}
	
	// 관리자 품목별 차트 조건:년도
		public List<Map<String, Integer>> selectSwGroupByAdmin(Map<String, String> map) {
			log.debug("selectSwGroupByAdmin()");
			try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
				return sqlSession.selectList(namespace + "selectSwGroupByAdmin", map);
			}
		}
		
	// 고객 품목별 차트 조건:년도
		public List<Map<String, Integer>> selectSwGroupByCustomer(Map<String, String> map) {
			log.debug("selectSwGroupByCustomer()");
			try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
				return sqlSession.selectList(namespace + "selectSwGroupByCustomer", map);
			}
		}
	
	// 공급회사 품목별 차트 조건:년도
		public List<Map<String, Integer>> selectSwGroupByCompany(Map<String, String> map) {
			log.debug("selectSwGroupByCompany()");
			try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
				return sqlSession.selectList(namespace + "selectSwGroupByCompany", map);
			}
		}
	
	// 관리자 결제타입 차트
	public List<Map<String, Integer>> selectPaymentChartByAdmin(Map<String, String> map) {
		log.debug("selectPaymentChartByAdmin()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectPaymentChartByAdmin", map);
		}
	}
	
	// 관리자 결제타입 차트
	public List<Map<String, Integer>> selectPaymentChartBySales(Map<String, String> map) {
		log.debug("selectPaymentChartBySales()");
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();) {
			return sqlSession.selectList(namespace + "selectPaymentChartBySales", map);
		}
	}
}
