package parkingTicket;

import java.time.LocalDateTime;
import java.util.Random;


public class Ticket {
	private String recieptNumber;
	private double fare;
	private LocalDateTime inTime;
	private int slotId;
	private int level;
	private Car car;
	
	public Ticket(int level, int slotId, Car car) {
		this.recieptNumber= Integer.toString(new Random().nextInt(1000));
		this.inTime = LocalDateTime.now();
		this.slotId = slotId;
		this.level = level;
		this.car = car;
	}
	
	public double getFare() {
		return fare;
	}
	
	public String getRecieptNumber() {
		return recieptNumber;
	}
	
	public LocalDateTime getEntryTime() {
		return inTime;
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
