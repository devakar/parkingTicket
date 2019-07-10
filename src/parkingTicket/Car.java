package parkingTicket;

public class Car {
	private String registerNumber;
	private String color;
	
	public Car(String registerNumber, String color) {
		this.registerNumber = registerNumber;
		this.color=color;
	}
	
	public String getRegisterNumber() {
		return registerNumber;
	}
	
	public String getColor() {
		return color;
	}
}
