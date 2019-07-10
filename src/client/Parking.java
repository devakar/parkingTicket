package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parkingTicket.*;

public class Parking {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingManager parkingManager = new ParkingManager();
		
		int capacity=3;
		int levels=1;
		parkingManager.createParkingArea(capacity, levels);
		
		Ticket s1 = parkingManager.park("KA-53-94419", "grey", 1);
		System.out.println("Car No. : " + s1.getCar().getRegisterNumber() + " Level : " + s1.getLevel() + " Slot : " + s1.getSlotId());
		Ticket s2 = parkingManager.park("KA-53-94418", "grey", 1);
		System.out.println("Car No. : " + s2.getCar().getRegisterNumber() + " Level : " + s2.getLevel() + " Slot : " + s2.getSlotId());
		Ticket s3 = parkingManager.park("KA-53-94417", "grey", 1);
		System.out.println("Car No. : " + s3.getCar().getRegisterNumber() + " Level : " + s3.getLevel() + " Slot : " + s3.getSlotId());
		//Ticket s4 = parkingManager.park("KA-53-94419", "grey", 1);
		//System.out.println("Car No. : " + s1.getCar().getRegisterNumber() + " Level : " + s1.getLevel() + " Slot : " + s1.getSlotId());
		parkingManager.getAllRegForColor("grey");
 		parkingManager.unPark(s1);
 		parkingManager.getAllRegForColor("grey");
 		
 		parkingManager.getSlotNoForReg("KA-53-94417");
 		
// 		Ticket s5 = parkingManager.park("KA-53-94419", "grey", 1);
// 		System.out.println(s5);
 		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);

	}*/
	
	public static void main(String args[]) {
		ParkingManager parkingManager = new ParkingManager();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter number of levels/floors");
			int level = Integer.parseInt(br.readLine());
			System.out.println("Enter number of slots in a level");
			int slotsInLevel = Integer.parseInt(br.readLine());
			
			parkingManager.createParkingArea(slotsInLevel, level);
			
			while (true) {
				System.out.print("Choose an operation (Enter number) : \n"
						+ "1. Park a car of given color\n"
						+ "2. Unpark a car with given registration number\n"
						+ "3. List registration number of all cars of given color\n"
						+ "4. Slot number of car parked\n"
						+ "5. Slot number of all cars parked of given color\n"
						+ "6. Print Status\n"
						+ "7. Exit\n");
				System.out.println();
				
				int op = Integer.parseInt(br.readLine());
				
				switch (op) {
				case 1: {
						
						System.out.print("Enter Car Registration Number :");
						String regNo =  br.readLine();
						
						System.out.print("Enter car color :");
						String color =  br.readLine();
						
						Ticket s1 = parkingManager.park(regNo, color, 1);
						if (s1 !=null)
							System.out.println("Car No. : " + s1.getCar().getRegisterNumber() + " Level : " + s1.getLevel() + " Slot : " + s1.getSlotId());
						else
							System.out.println("Can not park. Parking Area is full");
						break;
					}
				case 2: {
					System.out.print("Enter Car Registration Number :");
					String regNo =  br.readLine();
					parkingManager.unPark(regNo);
					break;
				}
				case 3: {
					System.out.print("Enter car color :");
					String color =  br.readLine();
					
					parkingManager.getAllRegForColor(color);
					break;
				}
				case 4: {
					System.out.print("Enter Car Registration Number :");
					String regNo =  br.readLine();
					
					parkingManager.getSlotNoForReg(regNo);
					break;
				}
				case 5: {
					System.out.print("Enter car color :");
					String color =  br.readLine();
					
					parkingManager.getAllSlotsForCarColor(color);
					break;
				}
				case 6: {
					parkingManager.getStatus();
					break;
				}
				
				case 7: {
					System.exit(0);
				}

				}
			}
			
			
		} catch (IOException e) {
			System.out.println("Exception : " + e);
		}
	}

}
