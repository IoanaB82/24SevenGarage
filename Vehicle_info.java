import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle_info {
	
	
	private List<Vehicle> parkedVehicleList = new ArrayList<Vehicle>();
	
	public void addVehicle(String vehicleNumber) {
		Vehicle v = new Vehicle(vehicleNumber, new Date());
		parkedVehicleList.add(v);
	}
	
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
	
	public Vehicle getVehicle(String vehicleNumber) {
		int index = -1;
		// Check vehiclenumber at what position in array 
		for (int i = 0; i < parkedVehicleList.size(); i++) {
			Vehicle v = parkedVehicleList.get(i);
			if (v.vehicleNumber.equals(vehicleNumber)) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			return parkedVehicleList.get(index);
		} else {
			return null;
		}
	}
	
	public int getParkingCount() {
		return parkedVehicleList.size();
	}	
}
