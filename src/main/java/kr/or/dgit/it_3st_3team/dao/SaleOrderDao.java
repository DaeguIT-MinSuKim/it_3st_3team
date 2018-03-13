package kr.or.dgit.it_3st_3team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;

public interface SaleOrderDao {
	SaleOrder selectSaleOrderByNo(SaleOrder saleOrder);

	// 현황관리 모든 데이터
	List<SaleOrder> selectSaleOrderByAll();
	
	// 현황관리 조건검색
	List<SaleOrder> selectSaleOrderWithAllBySearch(Map<String, String> map);

	// 관리자차트 연도별 품목 판매갯수
	List<Map<String, Integer>> selectSwGroupByAdmin(Map<String, String> map);
		
	// 영업사원차트 품목별 판매갯수- 조건:영업사원별,년도별
	List<Map<String, Integer>> selectSwGroupBySales(Map<String, String> map);
	
	// 고객별차트 연도별 품목 판매갯수
	List<Map<String, Integer>> selectSwGroupByCustomer(Map<String, String> map);
	
	// 공급회사별차트 연도별 품목 판매갯수
	List<Map<String, Integer>> selectSwGroupByCompany(Map<String, String> map);
	
	// 관리자차트 결제타입별
	List<Map<String, Integer>> selectPaymentChartByAdmin(Map<String, String> map);
	
	// 영업사원차트 결제타입별
	List<Map<String, Integer>> selectPaymentChartBySales(Map<String, String> map);
	
	// 고객별차트 결제타입별
	List<Map<String, Integer>> selectPaymentChartByCustomer(Map<String, String> map);
	
	// 공급회사별차트 결제타입별
	List<Map<String, Integer>> selectPaymentChartByCompany(Map<String, String> map);
	
	

	// 차트 결제타입별 갯수
	List<Map<String, Integer>> selectPaymentChartOption(Map<String, String> map);
	
	// 현황관리 모든 데이터
	List<SaleOrder> selectSaleOrderByAll(Map<String, String> map);

	
	// 소프트웨어 주문 관리
	int insertOrderByProc(SaleOrder saleOrder);
	
	int updateOrderManagementNo(SaleOrder saleOrder);

	int deleteSaleOrderByNo(SaleOrder ordNo);

}
