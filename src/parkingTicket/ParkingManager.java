package parkingTicket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingManager {
	private ParkingArea parkingArea;
	private HashMap<String, ArrayList<String> > map;
	private HashMap<String, Ticket> tickets;
	
	public ParkingManager() {
		this.map = new HashMap<String, ArrayList<String> >();
		this.tickets = new HashMap<>();
	}
	
	public void createParkingArea(int slotsPerLevel, int levels) {
		this.parkingArea=new ParkingArea(levels, slotsPerLevel);
	}
	
	public ParkingArea getParkingArea() {
		return parkingArea;
	}
	
	public Ticket park(String registrationNumber, String color, int entryNumber) {
		
		if(parkingArea.isParkingAreaFull()) {
			return null;
		}
		for (int i=1;i<=parkingArea.getLevelCount();i++) {
			Level level=parkingArea.levels.get(i-1);
			
			for(Slot slot:level.slots) {
				if(slot.isAvailable()) {
					slot.makeUnAvailable();
					Car car = new Car(registrationNumber, color);
					
					if (map.get(color) == null) {
					    map.put(color, new ArrayList<String>());
					}
					map.get(color).add(registrationNumber);
					Ticket ticket = new Ticket(level.getLevelNumber(), slot.getSlotId(), car);
					tickets.put(registrationNumber, ticket);
					return ticket;
				}
			}
		}
		
		
		return null;
	}
	
	public void unPark(int levelNumber, int slotNumber, Car car) {
		Level level=parkingArea.levels.get(levelNumber-1);
		Slot slot = level.slots.get(slotNumber-1);
		if(slot.isAvailable()) {
			System.out.println("No car parked for given ticket");
		}
		else {
			slot.makeAvailable();
			tickets.remove(car.getRegisterNumber());
			System.out.println("Car " + car.getRegisterNumber() + " unparked from slot " + slotNumber + " of level " + levelNumber);
		}
	}

	public void unPark(String regNo) {
		Ticket ticket = tickets.get(regNo);
		if (ticket==null) {
			System.out.println("No car parked for given ticket");
			return;
		}
		Car car = ticket.getCar();
		String color = car.getColor();
		removeRegFromColor(color, regNo);
		int level = ticket.getLevel();
		int slot = ticket.getSlotId();
		unPark(level, slot, car);
	}

	private void removeRegFromColor(String color, String regNo) {
		map.get(color).remove(regNo);
	}
	
	public void getAllRegForColor(String color) {
		ArrayList<String> reg = map.get(color);
		for (String regNo : reg) {
			System.out.print(regNo + " ");
		}
		System.out.println();
	}
	
	public void getSlotNoForReg(String regNo) {
		Ticket ticket = tickets.get(regNo);
		if (ticket == null) {
			System.out.println("Car with given registration number is not parked");
			return;
		}
		int level=ticket.getLevel();
		int slot=ticket.getSlotId();
		System.out.println("For car registration number "+ regNo+" the level is : "+level+" and slot is: "+slot);
			
	}

	public void getAllSlotsForCarColor(String color) {
		ArrayList<String> regList = map.get(color);
		if (regList == null || regList.isEmpty()) {
			System.out.println("No cars are parked of given color");
			return;
		}
		
		for (String regNo : regList) {
			Ticket ticket = tickets.get(regNo);
			System.out.println("Car with registration no " + regNo + " and color " + color + " is parked in level " + 
					ticket.getLevel() + " and slot " + ticket.getSlotId());
		}
		
	}

	public void getStatus() {
		if (tickets.isEmpty()) {
			System.out.println("No cars are parked. Parking area is empty");
			return;
		}
		int i = 1;
		for (Map.Entry<String, Ticket> entry : tickets.entrySet()) {
			String regNo = entry.getKey();
			Ticket ticket = entry.getValue();
			System.out.println(i++ + "\t" + regNo + "\t" + ticket.getCar().getColor() + "\t" + ticket.getLevel() + "\t" + ticket.getSlotId());
		}
	}
	
}
