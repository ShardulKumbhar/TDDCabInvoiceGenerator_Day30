import static org.junit.Assert.*;

import org.junit.Test;

import com.invoicegenerator.InvoiceGenerator;

public class InvoiceServiceTest {
	/*
	 * test case to check
	 * ==================================================================================
	 * 1.created method for calculating the total fare by giving distance and time for
	 * the total fare will be more than 5
	 * 2.created method for calculating the total fare by giving distance and time for
	 * the total fare will be less than 5
	 * ======================================================================================
	 */

	/**
	 * 1.created method for calculating the total fare by giving distance and time for
	 * the total fare will be more than 5
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(25, fare, 0.0);
	}

	/**
	 * 2.created method for calculating the total fare by giving distance and time for
	 * the total fare will be less than 5
	 */
	@Test
	public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		assertEquals(5, fare, 0.0);
	}
}

