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
		maps.put("sgName", "그래픽");
		maps.put("adminName", "영업1");
		maps.put("endDate", "2017-12-31");
		//maps.put("searchBy", "softwarename");
		maps.put("searchBy", "company");
		
		maps.put("name", "알럽소프트"); 
		//maps.put("name", "재밌는게임방");
		 
		//maps.put("swName", "바람의 제국");
		List<SaleOrder> saleOrders = service.findSaleOrderByMapWithAPI(maps);
		Assert.assertNotNull(saleOrders);
		for (SaleOrder s : saleOrders) {
			System.out.println(s);
		}
	}

	
	
	/*@Test 
	public void testBselectOrderManagementByNo() {
		SaleOrder so = new SaleOrder();
		so.setSoftwaregroup(new SoftwareGroup("게임"));
		so.setAdmin(new Admin("영업1"));
		so.setOrdDatetime(2018/02/01);
		SaleOrder findso = service.selectOrderManagementByNo(so);
		System.out.println(findso);
		
		assertNotNull(findso);
		assertEquals(so.getOrdNo(), findso.getOrdNo());
		}
	}*/
	
	/*@Test
	public void testCupdateOrderManagement() {
		SaleOrder so = new SaleOrder(10);
		so.setOrdQuantity(40);
		so.setOrdPayment(Payment.MOBILE);
		
		int res = service.updateOrderManagement(so);
		assertEquals(1, res);
	}*/

}
