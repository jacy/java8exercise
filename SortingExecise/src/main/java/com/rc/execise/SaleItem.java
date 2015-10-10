package com.rc.execise;

import java.util.Date;

public class SaleItem {
	private int month;
	private Date date;
	private String transationId;
	private double saleNumbers;

	public SaleItem(int month, double saleNumbers) {
		super();
		this.month = month;
		this.saleNumbers = saleNumbers;
	}

	public SaleItem(int month) {
		super();
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransationId() {
		return transationId;
	}

	public void setTransationId(String transationId) {
		this.transationId = transationId;
	}

	public double getSaleNumbers() {
		return saleNumbers;
	}

	public void setSaleNumbers(double saleNumbers) {
		this.saleNumbers = saleNumbers;
	}

	public int getQuater() {
		return month % 3 == 0 ? (month / 3) : (month / 3) + 1;
	}
}
