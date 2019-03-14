import java.util.Scanner;


public class TSG_main {



	public static void printWelcome() {
		System.out.println("     Welcome to 24Seven Garage!");
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

	public static int readUsersChoice() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();

	}

	public static String getRegistrationNumber() {
				System.out.println("\nEnter Registration number (only numbers or letters accepted) :");
				Scanner scan = new Scanner(System.in);
				return scan.next();
				}
	public static boolean checkRegNumber(String v){
		if((v.length()==6)||(v.length()==7)&&((v.matches("[a-zA-Z0-9_]+")))){
				System.out.println("you enter reg number:" + v);
				return true;
				}
		else{System.out.println("Wrong registration number");
				return false;
				}
	}


	public static String confirmRegistrationNumber() {
		System.out.println("\nConfirm Registration number:");
		Scanner scan = new Scanner(System.in);
		return scan.next();
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
				// add Vehicle in array
									vehicleInfo.addVehicle(vehicleNumber);
									break;
								}

					} else {
				System.out.println("Parking is Full");
				}

			break;


			case 2:

				vehicleNumber = getRegistrationNumber();
				// ask for payment
				Vehicle vehicleToRemove = vehicleInfo.getVehicle(vehicleNumber);
				if (vehicleToRemove != null) {
					trans.doPaymnet(vehicleToRemove.inTime);
					//Remove Vehicle from array
					vehicleInfo.removeVehicle(vehicleNumber);
				}

				break;

			case 3:
				userChoice = 3;

			}
		}
	}

}
