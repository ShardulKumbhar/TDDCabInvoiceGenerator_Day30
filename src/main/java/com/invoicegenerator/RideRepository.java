package com.invoicegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	Map<String, ArrayList<Ride>> userRides;

	public RideRepository() {
		userRides = new HashMap<String, ArrayList<Ride>>();
	}

	/*
	 * method created to add rides and give id
	 */
	public void addRide(String userId, Ride[] ride) {
		ArrayList<Ride> ridesList = this.userRides.get(userId);
		if (ridesList == null) {
			this.userRides.put(userId, new ArrayList<Ride>(Arrays.asList(ride)));
		}

	}

	/*
	 * return the invoice
	 */
	public Ride[] getRides(String userId) {
		return this.userRides.get(userId).toArray(new Ride[0]);
	}
}