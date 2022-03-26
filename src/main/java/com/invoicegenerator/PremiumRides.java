package com.invoicegenerator;

public enum PremiumRides {
	 NORMAL_RIDE(10.0, 1, 5.0), PREMIUM_RIDE(15.0, 2, 20.0);

	
	/*
	 * varables
	 */
	public final double costPerKm;
	public final int costPerTime;
	public final double minFare;

	/*
	 * constructor to check premimum rides
	 */
        private PremiumRides(double costPerKm, int costPerTime, double minFare) {
		this.costPerKm = costPerKm;
		this.costPerTime = costPerTime;
		this.minFare = minFare;
	}

	
	/**
	method created to calculate total Fare of both premium and normal rides
	*/
	public double calculateFare(Ride ride) {
		return Math.max((ride.getDistance() * costPerKm) + (ride.getTime() * costPerTime), minFare);
	}
	
}

