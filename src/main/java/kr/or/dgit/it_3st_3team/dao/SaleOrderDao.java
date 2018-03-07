package kr.or.dgit.it_3st_3team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;

public interface SaleOrderDao {
	SaleOrder selectSaleOrderByNo(SaleOrder saleOrder);

	// 현황관리 조건검색
	List<SaleOrder> selectSaleOrderWithAllBySearch(Map<String, String> map);

	// 차트 영업사원,품목별 판매갯수
	Map<String, Integer> selectSaleOrderBySwgType();
	
	// 현황관리 모든 데이터
	List<SaleOrder> selectSaleOrderByAll();
	
	// 소프트웨어 주문 관리

	int updateOrderManagementNo(SaleOrder saleOrder);

	int deleteSaleOrderByNo(SaleOrder ordNo);

}
