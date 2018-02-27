package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;


public class SaleOrderServiceTest {
	private static SaleOrderService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = SaleOrderService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}

	@Test
	public void test1FindSaleOrderByNo() {
		SaleOrder saleorder = new SaleOrder();
		saleorder.setOrdNo(1);
		SaleOrder findSaleOrder = service.findSaleOrderByNo(saleorder);
		assertNotNull(findSaleOrder);
		System.out.println(findSaleOrder);
	}

	@Test
	public void test2FindSaleOrderByMapWithAPI() {
		 Map<String, String> maps = new HashMap<>();
	        maps.put("ordNo", "1");
	        maps.put("swName", "바람의 제국");
	        List<SaleOrder> saleOrders = service.findSaleOrderByMapWithAPI(maps);
	        Assert.assertNotNull(saleOrders);
	       for (SaleOrder s : saleOrders) {
	    	   System.out.println(s);
	       }
	}
	
}
