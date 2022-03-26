package com.invoicegenerator;

public class InvoiceGenerator{

	/**
	 * 
	 * PROCEDURE
	 * =============================================================================================
	 * 1.created variables and assigned value 
	 * 2.create method to calculate total fare as per distance and time
	 * 3.if condition when given less distance and time then minimum charge should be given as 5.
	 * 4.Method to calculate total fare for multiple rides
	 * 5.method created add Rides for Given a user id
	 * 6.returning in voice summary
	 *===============================================================================================
	 * @author shardul
	*/

	/**
	 * 1.created variables and assigned value
	 */

	private RideRepository rideRepository;

	/**
	 * 2.create method to calculate total fare as per distance and time
	 * 
	 * @param distance -distance of per km cost is 10 rs
	 * @param time     -per minute cost is 1rs
	 * @return total fare -total fare to be calulated
	 */
	public InvoiceGenerator() {
		this.rideRepository = new RideRepository();
	}

	/*
	 * 3.Method to calculate
	 */
	public double calculateFare(Ride ride) {
		return Math.max(ride.rideType.minFare,
				ride.getDistance() * ride.rideType.costPerKm + ride.getTime() * ride.rideType.costPerTime);
	}

	/*
	 * 4.Method to calculate total fare for multiple rides
	 */
	public InvoiceSummary calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += calculateFare(ride);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

	/**
	 * 5.method created add Rides for Given a user id
	 * 
	 * @param userId
	 * @param ride
	 */
	public void addRides(String userId, Ride[] ride) {
		rideRepository.addRide(userId, ride);
	}

	/*
	 * 6.returning in voice summary
	 */
	public InvoiceSummary getInvoiceSummary(String userId) {
		return this.calculateFare(rideRepository.getRides(userId));
	}

}