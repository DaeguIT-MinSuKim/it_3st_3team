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
		maps.put("sgName", "게임");
		maps.put("adminName", "영업1");
		maps.put("endDate", "2017-12-31");
		// maps.put("searchBy", "softwarename");
		/*
		 * maps.put("name", "알럽소프트"); maps.put("name", "재밌는게임방");
		 */
		// maps.put("swName", "바람의 제국");
		List<SaleOrder> saleOrders = service.findSaleOrderByMapWithAPI(maps);
		Assert.assertNotNull(saleOrders);
		for (SaleOrder s : saleOrders) {
			System.out.println(s);
		}
	}

	@Test
	public void testAselectOrderManagementByAll() {
		List<SaleOrder> listsm = service.selectOrderManagementByAll();
		System.out.println(listsm);
		assertNotNull(listsm);
		for (SaleOrder sm : listsm) {
			System.out.println(sm);
		}
	}

}
