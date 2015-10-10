package com.rc.execise;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testSortByNameWhenFirstNameIsDifferent() {
		List<Extension> extensions = new ArrayList<Extension>(3);
		Extension a = new Extension("a", null, null);
		Extension b = new Extension("b", null, null);
		Extension c = new Extension("c", null, null);
		extensions.add(b);
		extensions.add(a);
		extensions.add(c);
		List<Extension> sorted = Utils.sortByName(extensions);
		assertEquals(a, sorted.get(0));
		assertEquals(b, sorted.get(1));
		assertEquals(c, sorted.get(2));
	}

	@Test
	public void testSortByNameWhenFirstNameIsSameButLastNameIsDifferent() {
		List<Extension> extensions = new ArrayList<Extension>(4);
		Extension a = new Extension("sameFirstName", "a", null);
		Extension b = new Extension("sameFirstName", "b", null);
		Extension nul = new Extension("sameFirstName", null, null);
		Extension empty = new Extension("sameFirstName", "", null);
		extensions.add(a);
		extensions.add(b);
		extensions.add(nul);
		extensions.add(empty);
		List<Extension> sorted = Utils.sortByName(extensions);
		assertEquals(nul, sorted.get(0));
		assertEquals(empty, sorted.get(1));
		assertEquals(a, sorted.get(2));
		assertEquals(b, sorted.get(3));
	}

	@Test
	public void testSortByNameWhenFirstNameAndLastNameIsSameButExtIsDifferent() {
		List<Extension> extensions = new ArrayList<Extension>(4);
		Extension a = new Extension("sameFirstName", "sameLastName", "a");
		Extension b = new Extension("sameFirstName", "sameLastName", "b");
		Extension nul = new Extension("sameFirstName", "sameLastName", null);
		Extension empty = new Extension("sameFirstName", "sameLastName", "");
		extensions.add(a);
		extensions.add(b);
		extensions.add(nul);
		extensions.add(empty);
		List<Extension> sorted = Utils.sortByName(extensions);
		assertEquals(nul, sorted.get(0));
		assertEquals(empty, sorted.get(1));
		assertEquals(a, sorted.get(2));
		assertEquals(b, sorted.get(3));
	}

	@Test
	public void testSortByExtType() {
		List<Extension> extensions = new ArrayList<Extension>(5);
		Extension other = new Extension("Other");
		Extension tmo = new Extension("TMO");
		Extension ao = new Extension("AO");
		Extension dept = new Extension("Dept");
		Extension user = new Extension("User");
		extensions.add(ao);
		extensions.add(dept);
		extensions.add(user);
		extensions.add(tmo);
		extensions.add(other);
		List<Extension> sorted = Utils.sortByExtType(extensions);
		assertEquals(other, sorted.get(0));
		assertEquals(tmo, sorted.get(1));
		assertEquals(ao, sorted.get(2));
		assertEquals(dept, sorted.get(3));
		assertEquals(user, sorted.get(4));
	}

	@Test
	public void testSumByQuater() {
		List<SaleItem> items = new ArrayList<SaleItem>(12);
		items.add(new SaleItem(1, 1d));
		items.add(new SaleItem(2, 2d));
		items.add(new SaleItem(3, 3d));
		items.add(new SaleItem(4, 4d));
		items.add(new SaleItem(5, 5d));
		items.add(new SaleItem(6, 6d));
		items.add(new SaleItem(7, 7d));
		items.add(new SaleItem(8, 8d));
		items.add(new SaleItem(9, 9d));
		items.add(new SaleItem(10, 10d));
		items.add(new SaleItem(11, 11d));
		items.add(new SaleItem(12, 12d));
		List<QuaterSalesItem> quaterItems = Utils.sumByQuater(items);
		assertEquals(4, quaterItems.size());
		assertTrue(quaterItems.contains(new QuaterSalesItem(1, 6)));
		assertTrue(quaterItems.contains(new QuaterSalesItem(2, 15)));
		assertTrue(quaterItems.contains(new QuaterSalesItem(3, 24)));
		assertTrue(quaterItems.contains(new QuaterSalesItem(4, 33)));
	}

	@Test
	public void testMaxByQuater() {
		List<SaleItem> items = new ArrayList<SaleItem>(12);
		items.add(new SaleItem(1, 1d));
		items.add(new SaleItem(2, 2d));
		items.add(new SaleItem(3, 3d));
		items.add(new SaleItem(4, 4d));
		items.add(new SaleItem(5, 5d));
		items.add(new SaleItem(6, 6d));
		items.add(new SaleItem(7, 7d));
		items.add(new SaleItem(8, 8d));
		items.add(new SaleItem(9, 9d));
		items.add(new SaleItem(10, 10d));
		items.add(new SaleItem(11, 11d));
		items.add(new SaleItem(12, 12d));
		List<QuaterSalesItem> quaterItems = Utils.maxByQuater(items);
		assertEquals(4, quaterItems.size());
		assertTrue(quaterItems.contains(new QuaterSalesItem(1, 3d)));
		assertTrue(quaterItems.contains(new QuaterSalesItem(2, 6d)));
		assertTrue(quaterItems.contains(new QuaterSalesItem(3, 9d)));
		assertTrue(quaterItems.contains(new QuaterSalesItem(4, 12d)));
	}

	@Test
	public void testGetUnUsedKeys() {
		assertArrayEquals(new int[] { 0, 1, 5, 6, 7, 8, 9, 10 }, Utils.getUnUsedKeys(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] { 3, 2, 4 }));
	}

}
