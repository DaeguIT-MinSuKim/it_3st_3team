package kr.og.dgit.it_3st_3team;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	@Test
	public void test5SelectSgGroupNoOption() {
		Map<String, String> maps = new HashMap<>();
		
		maps.put("adminName", "영업1");
		maps.put("date", "2018");
		
		List<Map<String, Integer>> listChart = service.selectSgGroupNoOption(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}

	@Test
	public void test6SelectSgGroupYear() {
		Map<String, String> maps = new HashMap<>();
		maps.put("date", "2018");
		
		List<Map<String, Integer>> listChart = service.selectSgGroupYear(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
	
	@Test
	public void test7SelectPaymentChartOption() {
		Map<String, String> maps = new HashMap<>();

		maps.put("date", "2016");
		
		List<Map<String, Integer>> listChart = service.selectPaymentChartOption(maps);
		Assert.assertNotNull(listChart);
		
		for(Map<String, Integer> map : listChart) {
			for(Entry<String, Integer> e : map.entrySet()) {
				System.out.printf("%s - %s%n", e.getKey(), e.getValue());
			}
		}
	}
}
