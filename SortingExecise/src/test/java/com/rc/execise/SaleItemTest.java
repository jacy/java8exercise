package com.rc.execise;

import static org.junit.Assert.*;

import org.junit.Test;

public class SaleItemTest {

	@Test
	public void testMonthToQuater() {
		assertEquals(1, new SaleItem(1).getQuater());
		assertEquals(1, new SaleItem(2).getQuater());
		assertEquals(1, new SaleItem(3).getQuater());
		assertEquals(2, new SaleItem(4).getQuater());
		assertEquals(2, new SaleItem(5).getQuater());
		assertEquals(2, new SaleItem(6).getQuater());
		assertEquals(3, new SaleItem(7).getQuater());
		assertEquals(3, new SaleItem(8).getQuater());
		assertEquals(3, new SaleItem(9).getQuater());
		assertEquals(4, new SaleItem(10).getQuater());
		assertEquals(4, new SaleItem(11).getQuater());
		assertEquals(4, new SaleItem(12).getQuater());
	}

}
