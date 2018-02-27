package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.it_3st_3team.dto.Admin;
import kr.or.dgit.it_3st_3team.dto.SaleOrder;
import kr.or.dgit.it_3st_3team.dto.SoftwareGroup;
import kr.or.dgit.it_3st_3team.service.SaleOrderService;
import kr.or.dgit.it_3st_3team.type.Payment;

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
	public void test2FindSaleOrderWithAllByNo() {
		/*SaleOrder saleorder = new SaleOrder();
		saleorder.setOrdNo(1);
		SaleOrder findSaleOrder = service.findSaleOrderWithAllByNo(saleorder);
		assertNotNull(findSaleOrder);
		System.out.println(findSaleOrder);*/
	}
	
	@Test
	public void testAselectOrderManagementByAll() {
		List<SaleOrder> listsm = service.selectOrderManagementByAll();
		System.out.println(listsm);
		assertNotNull(listsm);
		for(SaleOrder sm :  listsm) {
			System.out.println(sm);
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
