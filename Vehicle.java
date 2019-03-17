import java.util.Date;

public class Vehicle {

	String vehicleNumber;


	public Vehicle(){

	}

	public Vehicle (String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public void createEntry(String vehicleNumber){
		setVehicleNumber(vehicleNumber);
	}

}
