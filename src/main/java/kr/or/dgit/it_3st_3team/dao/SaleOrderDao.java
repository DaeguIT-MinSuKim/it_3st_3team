package kr.or.dgit.it_3st_3team.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;

public interface SaleOrderDao {
	SaleOrder selectSaleOrderByNo(SaleOrder saleOrder);

	SaleOrder selectSaleOrderWithAllBySearch(Map<String, String> map);

	List<SaleOrder> selectSaleOrderByAll();
	// 소프트웨어 주문 관리

	int updateOrderManagement(SaleOrder saleOrder);

	int deleteOrderManagement(SaleOrder ordNo);

}
