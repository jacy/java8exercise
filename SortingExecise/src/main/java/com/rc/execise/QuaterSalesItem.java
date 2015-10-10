package com.rc.execise;

public class QuaterSalesItem {
	private int quarter;
	private double total;

	public QuaterSalesItem(int quarter, double total) {
		super();
		this.quarter = quarter;
		this.total = total;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuaterSalesItem other = (QuaterSalesItem) obj;
		if (quarter != other.quarter)
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

}
