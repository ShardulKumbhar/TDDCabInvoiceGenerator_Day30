import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.invoicegenerator.InvoiceGenerator;
import com.invoicegenerator.InvoiceSummary;
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
			double distance = 2.0;
			int time = 5;
			double fare = invoiceGenerator.calculateFare(distance, time);
			assertEquals(25, fare, 0.0);
		}

		/**
		 * 2.created method for calculating the total fare by giving distance and time
		 * for the total fare will be less than 5
		 */
		@Test
		public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
			double distance = 0.1;
			int time = 1;
			double fare = invoiceGenerator.calculateFare(distance, time);
			assertEquals(5, fare, 0.0);
		}

		/**
		 * 3.To test given multiple rides should return total fare.
		 */
		@Test
		public void givenMultipleRides_ShouldReturnTotalFare() {
			Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
			double fare = invoiceGenerator.calculateFare(rides);
			assertEquals(30, fare, 0.0);
		}
		
		/**
		 * 4.multiple rides should return the ride summary
		 */
		@Test		
		public void givenMultipleRidesShouldReturnRideSummary() {
			Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
			InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(rides);
			InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
			assertEquals(expectedInvoiceSummary, summary);
		}

	}
