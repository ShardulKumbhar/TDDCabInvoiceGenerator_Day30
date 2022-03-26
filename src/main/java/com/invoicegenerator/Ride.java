package com.invoicegenerator;

public class Ride {

	/*
	 * variables
	 */
	private double distance;
	private int time;
	public PremiumRides rideType;


	/**
	 * create parameterized constructor of Ride class by passing distance and time
	 * 
	 * @param distance
	 * @param time
	 */
	public Ride(double distance, int time, PremiumRides rideType) {
		super();
		this.distance = distance;
		this.time = time;
		this.rideType = rideType;
	}

	/**
	 * created getter setter methods
	 * 
	 */
	public double getDistance() {
		return distance;
	}

	

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}