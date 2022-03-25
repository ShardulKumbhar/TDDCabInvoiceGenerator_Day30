package com.invoicegenerator;

public class InvoiceGenerator {
	/**
	 * 
	 * PROCEDURE
	 * =============================================================================================
	 * 1.created variables and assigned value 
	 * 2.create method to calculate total fare as per distance and time
	 * 3.if condition when given less distance and time then minimum charge should be given as 5.
	 * 4.Method to calculate total fare for multiple rides
	 *===============================================================================================
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

		return Math.max(totalFare, MINIMUM_FARE);
	}

	/*
	 * 4.Method to calculate total fare for multiple rides
	 */
	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return totalFare;
	}
	/**
	 * InvoiceSummary method for getting the part of the invoice
	 * 
	 * @param rides
	 * @return
	 */
	public InvoiceSummary getInvoiceSummary(Ride[] rides) {
		double totalFare = calculateFare(rides);
		int numOfRides = rides.length;
		return new InvoiceSummary(numOfRides, totalFare);
	}
}
