package kr.og.dgit.it_3st_3team;



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
		Assert.assertNotNull(findSaleOrder);
	}

	@Test
	public void test2FindSaleOrderWithAllBySearch() {
		Map<String, String> maps = new HashMap<>();
		
		maps.put("sgName", "");
		maps.put("adminName", "");
		maps.put("startDate", "");
		maps.put("endDate", "");
		//maps.put("searchBy", "softwarename");
		maps.put("searchBy", "company");
		maps.put("name", ""); 
		//maps.put("name", "재밌는게임방");
		//maps.put("swName", "바람의 제국");
		List<SaleOrder> saleOrders = service.findSaleOrderWithAllBySearch(maps);
		Assert.assertNotNull(saleOrders);
		for (SaleOrder s : saleOrders) {
			System.out.println(s);
		}

	/*
	 * @Test public void testBselectOrderManagementByNo() { SaleOrder so = new
	 * SaleOrder(); so.setSoftwaregroup(new SoftwareGroup("게임")); so.setAdmin(new
	 * Admin("영업1")); so.setOrdDatetime(2018/02/01); SaleOrder findso =
	 * service.selectOrderManagementByNo(so); System.out.println(findso);
	 * 
	 * assertNotNull(findso); assertEquals(so.getOrdNo(), findso.getOrdNo()); } }
	 */

	/*
	 * @Test public void testCupdateOrderManagement() { SaleOrder so = new
	 * SaleOrder(10); so.setOrdQuantity(40); so.setOrdPayment(Payment.MOBILE);
	 * 
	 * int res = service.updateOrderManagement(so); assertEquals(1, res); }
	 */

	}
	
	@Test
	public void test3findSaleOrderByAll() {
		List<SaleOrder> findSaleOrder = service.findSaleOrderByAll();
		Assert.assertNotNull(findSaleOrder);
		System.out.println(findSaleOrder);
	}
	
	@Test
	public void test4deleteSaleOrderByNo() {
		int res = service.deleteSaleOrderByNo(new SaleOrder(1));
		Assert.assertEquals(1, res);
		System.out.println(res);
	}
}
