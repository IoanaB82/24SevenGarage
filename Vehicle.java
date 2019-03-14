import java.util.Date;

public class Vehicle {
	
	String vehicleNumber;
	Date inTime;
	
	public Vehicle (String vehicleNumber, Date inTime) {
		this.vehicleNumber = vehicleNumber;
		this.inTime = inTime;
		
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	
	

}
