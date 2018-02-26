package kr.or.dgit.it_3st_3team.service;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;



public class SaleOrderService {
	private static final SaleOrderService instance = new SaleOrderService();
	private static final Log log = LogFactory.getLog(SaleOrderService.class);
	private final String namespace = "kr.or.dgit.it_3st_3team.dao.SaleOrderService.";
			
			
			
	public static SaleOrderService getInstance() {
		return instance;
	}

	public SaleOrderService() {
	
	}
	
}
