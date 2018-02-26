package kr.og.dgit.it_3st_3team;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
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
	public void test2FindSaleOrderWithAllByNo() {
		/*SaleOrder saleorder = new SaleOrder();
		saleorder.setOrdNo(1);
		SaleOrder findSaleOrder = service.findSaleOrderWithAllByNo(saleorder);
		assertNotNull(findSaleOrder);
		System.out.println(findSaleOrder);*/
	}

}
