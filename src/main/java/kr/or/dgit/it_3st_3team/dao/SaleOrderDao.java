package kr.or.dgit.it_3st_3team.dao;

import java.util.Map;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;

public interface SaleOrderDao {
	SaleOrder selectSaleOrderByNo(SaleOrder saleOrder);
	SaleOrder selectSaleOrderByMapWithAPI(Map<String, String> map);
}
