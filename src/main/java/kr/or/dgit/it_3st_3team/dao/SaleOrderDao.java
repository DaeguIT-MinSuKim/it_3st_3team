package kr.or.dgit.it_3st_3team.dao;

import java.util.List;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;

public interface SaleOrderDao {
	SaleOrder selectSaleOrderByNo(SaleOrder saleOrder);

	SaleOrder selectSaleOrderWithAllByNo(SaleOrder saleOrder);

	// 소프트웨어 주문 관리
	List<SaleOrder> selectOrderManagementByAll(SaleOrder saleOrder);

	SaleOrder selectOrderManagementByNo(SaleOrder saleOrder);

	int updateOrderManagement(SaleOrder saleOrder);

	int deleteOrderManagement(SaleOrder ordNo);

}
