import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TSG_Transaction {
	
		
	public void doPaymnet(Date inTime) {
		Scanner scan = new Scanner(System.in);
		int price = 10;
		double park_time = 0;
		double amount;
		String card_number;

		try {
			 Date outTime = new Date();
			double parkingHrs = calculateParkingHours(inTime, outTime);			
			amount = price * parkingHrs;
			System.out.println("Your parking price is: " + amount);

			System.out.println("\n\nEnter Debit/Credit card number(12 digit):");
			card_number = scan.next();

			System.out.println("\nPayment Successful!!\n\n");
		}
			
			catch (Exception e) {
				System.out.println("Try again");
				
		}

	}
	
	private double calculateParkingHours(Date inTime, Date outTime) {
		//Date outTime;
		double parkingHrs = outTime.getSeconds() - inTime.getSeconds();
		return parkingHrs;
		
	}

}
