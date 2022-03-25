package com.invoicegenerator;

public class InvoiceGenerator {
	/**
	 * 
	 * PROCEDURE
	 * =============================================================================================
	 * 1.created variables and assigned value 
	 * 2.create method to calculate total fare as per distance and time
	 * 3.if condition when given less distance and time then minimum charge should be given as 5.
	 * ===============================================================================================
	 * @author shardul
	*/
	
	/**
	 * 1.created variables and assigned value
	 */

	private static final int COST_PER_TIME = 1;
	private static final double COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;

	/**
	 * 2.create method to calculate total fare as per distance and time
	 * 
	 * @param distance -distance of per km cost is 10 rs
	 * @param time     -per minute cost is 1rs
	 * @return total fare -total fare to be calulated
	 */

	public double calculateFare(double distance, int time) {
		double totalFare = distance * COST_PER_KM + time * COST_PER_TIME;

		/*
		 * 3.if condition when given less distance and time then minimum charge should
		 * be given as 5.
		 */
		if (totalFare < MINIMUM_FARE)

			return MINIMUM_FARE;

		return totalFare;
	}
}
