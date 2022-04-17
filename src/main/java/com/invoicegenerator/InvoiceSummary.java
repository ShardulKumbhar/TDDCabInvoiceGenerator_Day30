package com.invoicegenerator;

public class InvoiceSummary {

	/**
	 *1. variables
	 */
	public int numOfRides;
	public double totalFare;
	public double avgFare;

	/**
	 * 2.constructor
	 * 
	 * @param numOfRides
	 * @param totalFare
	 */
	public InvoiceSummary(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.avgFare = this.totalFare / this.numOfRides;
	}

	/*
	 * 3.equals to method of boolean class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(avgFare) != Double.doubleToLongBits(other.avgFare))
			return false;
		if (numOfRides != other.numOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

}
