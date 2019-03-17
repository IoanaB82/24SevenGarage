import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle_info {

	//list to contain the parked vehicles
	private List<Vehicle> parkedVehicleList = new ArrayList<Vehicle>();


//add vehicle to list
	public void addVehicle(String vehicleNumber) {
		Vehicle v = new Vehicle(vehicleNumber);
		v.createEntry(vehicleNumber);
		parkedVehicleList.add(v);
	}

	//method to remove vehicle from list
	public void removeVehicle(String vehicleNumber) {
		int index = -1;
		//int index = parkedVehicleList.indexOf(vehicleNumber);

		for (int i = 0; i < parkedVehicleList.size(); i++) {
			Vehicle v = parkedVehicleList.get(i);
			if (v.vehicleNumber.equals(vehicleNumber)) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			parkedVehicleList.remove(index);
		}
	}

	//retrievs list
	public List<Vehicle> getEntries(){
    return parkedVehicleList;
  }

	//get index of object in list, based on vehicle number
	public Vehicle getVehicle(String vehicleNumber) {
		int index = -1;
		// Check vehiclenumber at what position in array
		for (int i = 0; i < parkedVehicleList.size(); i++) {
			Vehicle v = getEntries().get(i);
			if (v.vehicleNumber.equals(vehicleNumber)) {
				index = i;
			}
			break;
		}
		if (index != -1) {
			return getEntries().get(index);
		} else {
			return null;
		}
	}

	//checks if car was already registred
	public boolean getVehicleStatus(String vehicleNumber) {
		boolean status = false;
		// Check vehiclenumber at what position in array
		for (int i = 0; i < parkedVehicleList.size(); i++) {
			Vehicle v = getEntries().get(i);
			if (v.vehicleNumber.equals(vehicleNumber)) {
				status = true;
			}
			break;
		}
		return status;
	}


	//method to print objects' vehiclenumber in list
	public void printEntires(){
		for(int i=0; i<parkedVehicleList.size(); i++){
			System.out.println("\nVehicle:"+ getEntries().get(i).getVehicleNumber()+"index: "+i);

		}
	}


	public int getParkingCount() {
		return parkedVehicleList.size();
	}
}
