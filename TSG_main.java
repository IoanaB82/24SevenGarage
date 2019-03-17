import java.util.Scanner;
import java.util.*;


public class TSG_main {



	public static void printWelcome() {
		System.out.println("    \n Welcome to 24Seven Garage!");
		//System.out.println("****************************************");
	}

	private static void showInfoMenu(int availableParkingCount) {
		System.out.println("****************************************");
		System.out.println("Available parking places:" + availableParkingCount);
		System.out.println("Price per hour is 10kr");
		System.out.println("****************************************");
	}

	public static void showOptionMenu() {
		// show menu 1. Park 2. exit

		System.out.println("Chose a number corresponding to your option:");
		System.out.println("1: Want to park Vehicle?");
		System.out.println("2: Exit from parking?");
		System.out.println("3: Shut Down");

		System.out.print("\nMake Your Choice: ");
	}

	//method to validate that card number contains exactly 16 digits
	public static boolean checkCardNumber(String card_number){
		if((card_number.length()==16)&&(card_number.matches("[0-9]+"))){
					return true;
					}
	else{//System.out.println("Wrong format. Try again");
			return false;}
	}

	//method to manage try-catch for integer when user types choice
	public static int readUsersChoice() {
				int choice = 0;
				try{Scanner scan = new Scanner(System.in);
				choice = scan.nextInt();}
				catch(Exception e){System.out.println("Try a number");}
				return choice;
	}

	public static String getRegistrationNumber() {
				System.out.println("\nEnter Registration number (only numbers or letters accepted) :");
				Scanner scan = new Scanner(System.in);
				return scan.next();
				}

	public static String getCardNumber(){
		System.out.println("\nEnter card number (16 digits) :");
		Scanner scan = new Scanner(System.in);
		return scan.next();
		}

		//method to validate that vehicle's number contains only letters and digits
	public static boolean checkRegNumber(String v){
		if((v.length()==6)||(v.length()==7)&&((v.matches("[a-zA-Z0-9_]+")))){
				System.out.println("You entered registration number:" + v);
				return true;
				}
		else{System.out.println("Wrong registration number. Try again!");
				return false;
				}
	}


	public static void main(String[] args) {

		int userChoice= 0;
		String vehicleNumber;
		Vehicle_info vehicleInfo = new Vehicle_info();
		TSG_Transaction trans = new TSG_Transaction();
		int availableParkingCount = 5;
		printWelcome();


		while (userChoice != 3) {
			availableParkingCount = 5 - vehicleInfo.getParkingCount();
			showInfoMenu(availableParkingCount);

			showOptionMenu();

			userChoice = readUsersChoice();


			switch (userChoice) {
			case 1:
				if (availableParkingCount > 0) {
						vehicleNumber = getRegistrationNumber();
						while(checkRegNumber(vehicleNumber)){
									boolean userExists = vehicleInfo.getVehicleStatus(vehicleNumber);
									if(!userExists){
										// add Vehicle in array
										vehicleInfo.addVehicle(vehicleNumber);
										break;
									}
									else{
										System.out.println("Already parked. Do you want to pay instead?");
									}
									break;
								}

						}
				else {
							System.out.println("Parking is Full");
				}

			break;


			case 2:
				vehicleInfo.printEntires();
				vehicleNumber = getRegistrationNumber();
				//validate if number exists parked
				boolean userExists = vehicleInfo.getVehicleStatus(vehicleNumber);
				if(userExists){
				// ask for payment
						Vehicle vehicleToRemove = vehicleInfo.getVehicle(vehicleNumber);
							if (vehicleToRemove != null) {
								System.out.println("Enter the time of stay:");
								Scanner scan = new Scanner(System.in);
									try{
											int time = scan.nextInt();
											double amount;
											int price = 10;
											amount = time*price;
											System.out.println("Your parking price is: " + amount);
											while(true){
												String card_number = getCardNumber();

						 						boolean successful = checkCardNumber(card_number);
												if(successful){
													System.out.println("Successful!");
													System.out.println("*************************");
													System.out.println("Receipt: vehicle number:"+ vehicleNumber+"\ntime of stay:"+ time+"\namount payed:"+amount);
													System.out.println("Have a nice day!");

													//Remove Vehicle from array
													vehicleInfo.removeVehicle(vehicleNumber);
													break;
												}
										 		else{System.out.println("Wrong number, try again.");
											}
											}
										}
										catch(Exception e){
											System.out.println("Try a number instead");
										}
							}
					}
					else{
						System.out.println("User not found. Can't do payment.");
					}

						break;

			case 3:
				userChoice = 3;
			break;
			default:
				userChoice = 3;
			break;
		}


}
}
}
