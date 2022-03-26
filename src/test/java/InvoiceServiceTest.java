import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.invoicegenerator.InvoiceGenerator;

import com.invoicegenerator.InvoiceSummary;
import com.invoicegenerator.PremiumRides;
import com.invoicegenerator.Ride;

public class InvoiceServiceTest {
	/*
	 * test case to check
	 * ==================================================================================
	 *  Creating invoice before test run
	 * 1.created method for calculating the total fare by giving distance and time for
	 * the total fare will be more than 5
	 * 2.created method for calculating the total fare by giving distance and time for
	 * the total fare will be less than 5
	 * 3.To test given multiple rides should return total fare.
	 * 4.multiple rides should return the ride summary
	 * 5.Two Types of rides 
	 * ======================================================================================
	 */
	InvoiceGenerator invoiceGenerator = null;

	/*
	 * Creating invoice before test run
	 */
	@Before
	public void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	/**
	 * 1.created method for calculating the total fare by giving distance and time
	 * for the total fare will be more than 5
	 */
	@Test

	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 1.0;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(20, fare, 0.0);
	}

	/**
	 * 2.created method for calculating the total fare by giving distance and time
	 * for the total fare will be less than 5
	 */
	@Test

	public void givenDistanceAndTime_WhenTotalFareLessThan10_ShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}

	/**
	 * 3.To test given multiple rides should return total fare.
	 */
	@Test
	public void givenMultipleRidesShouldReturnRideSummary() {
		Ride[] rides = { new Ride(2.0, 5, PremiumRides.NORMAL_RIDE), new Ride(0.1, 1, PremiumRides.NORMAL_RIDE) };
		InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		assertEquals(expectedSummary, summary);
	}

	/**
	 * 4.multiple rides should return the ride summary
	 */
	@Test
	public void givenUserIdShouldReturnTheInvoice() {
		String userId = "sam@123";
		Ride[] rides = { new Ride(2.0, 5, PremiumRides.NORMAL_RIDE), new Ride(0.1, 1, PremiumRides.NORMAL_RIDE) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
		assertEquals(summary, checkSummary);
	}

	/**
	 * 5.Two Types of rides Normal Rides : 
	 * Rs.10 per km, Rs.1 per minute, Minimum fare of Rs.5 
	 * Premium Rides : Rs.15 per km, Rs.2 per minute , Minimum fare of Rs.20
	 * 
	 */
	@Test
	public void givenUserIdWithPremiumRideShouldReturnTheInvoice() {
		String userId = "sam@123";
		Ride[] rides = { new Ride(2.0, 5, PremiumRides.NORMAL_RIDE), new Ride(0.1, 1, PremiumRides.NORMAL_RIDE),
				new Ride(0.1, 1, PremiumRides.PREMIUM_RIDE) };
		invoiceGenerator.addRides(userId, rides);
		InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
		InvoiceSummary checkSummary = new InvoiceSummary(3, 50.0);
		assertEquals(summary, checkSummary);
	}
}