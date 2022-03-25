package com.invoicegenerator;

public class InvoiceSummary {

	public int numOfRides;
	public double totalFare;
	public double avgFare;
	
	
	public InvoiceSummary(int numOfRides, double totalFare) {
		super();
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
	
	}
	
	@Override
	/**
	 * The equals() method of Boolean class is a built in method of Java which is
	 * used check equality of two Boolean object.
	 * 
	 */
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) o;
		return (numOfRides == that.numOfRides) && Double.compare(that.totalFare, totalFare) == 0
				&& Double.compare(that.avgFare, avgFare) == 0;
	}
}
