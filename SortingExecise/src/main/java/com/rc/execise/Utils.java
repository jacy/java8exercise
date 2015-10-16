package com.rc.execise;

import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsFirst;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Utils {
	public static final Map<String, Integer> EXTTYPE_ORDERING = new HashMap<>(8);
	static {
		EXTTYPE_ORDERING.put("Other", 0);
		EXTTYPE_ORDERING.put("TMO", 1);
		EXTTYPE_ORDERING.put("AO", 2);
		EXTTYPE_ORDERING.put("Dept", 3);
		EXTTYPE_ORDERING.put("User", 4);
	}

	/**
	 * Question1, sort by firstName + lastName + ext, if firstName is the same
	 * then sort by lastName and ext, please note lastName and ext can be empty
	 * string or null.
	 *
	 **/

	public static List<Extension> sortByName(List<Extension> extensions) {
		Comparator<String> nullFirstComparator = nullsFirst(String::compareTo);
		Comparator<Extension> compator = comparing(Extension::getFirstName).thenComparing(Extension::getLastName, nullFirstComparator).thenComparing(Extension::getExt, nullFirstComparator);
		return extensions.stream().sorted(compator).collect(toList());

	}

	/**
	 * Question2, sort extType, extType is a string and can be "User", "Dept",
	 * "AO", "TMO", "Other", sort by User > Dept > AO > TMO > Other;
	 *
	 **/
	public static List<Extension> sortByExtType(List<Extension> extensions) {
		return extensions.stream().sorted((e1, e2) -> Integer.compare(EXTTYPE_ORDERING.get(e1.getExtType()), EXTTYPE_ORDERING.get(e2.getExtType()))).collect(toList());
	}

	/**
	 * Question3, sum all sales items by quater
	 *
	 **/
	public static List<QuaterSalesItem> sumByQuater(List<SaleItem> saleItems) {
		//		saleItems.stream().reduce(new ArrayList<QuaterSalesItem>(), (list, saleItem) -> groupingBy(SaleItem::getQuater, summingDouble(SaleItem::getSaleNumbers)), List::addAll);
		Map<Integer, Double> quaterMap = saleItems.stream().collect(groupingBy(SaleItem::getQuater, summingDouble(SaleItem::getSaleNumbers)));
		return quaterMap.entrySet().stream().map(e -> new QuaterSalesItem(e.getKey(), e.getValue())).collect(toList());
	}

	/**
	 * Question4, max all sales items by quater
	 *
	 **/
	public static List<QuaterSalesItem> maxByQuater(List<SaleItem> saleItems) {
		Map<Integer, Optional<SaleItem>> maxQuaterMap = saleItems.stream().collect(groupingBy(SaleItem::getQuater, reducing(BinaryOperator.maxBy(comparing(SaleItem::getSaleNumbers)))));
		return maxQuaterMap.entrySet().stream().map(e -> new QuaterSalesItem(e.getKey(), e.getValue().get().getSaleNumbers())).collect(toList());
	}

	/**
	 * We have all Keys: 0-9; usedKeys is an array to store all used keys like :
	 * [2,3,4]; We want to get all unused keys, in this example it would be:
	 * [0,1,5,6,7,8,9,]
	 */

	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
		Arrays.sort(usedKeys);
		return Arrays.stream(allKeys).filter(e -> Arrays.binarySearch(usedKeys, e) < 0).toArray();
	}
}
