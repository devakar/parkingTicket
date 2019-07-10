package parkingTicket;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private int levelNumber;
	private int levelCapacity;
	public List<Slot> slots;
	
	public Level(int levelNumber, int levelCapacity) {
		this.levelNumber=levelNumber;
		this.levelCapacity=levelCapacity;
		this.slots = new ArrayList<Slot>();
		
		for(int i=0;i<levelCapacity;i++) {
			Slot slot = new Slot(i+1);		
			this.slots.add(slot);
		}
	}
	
	public boolean isLevelFull() {
		int count=1;
		for(;count<=levelCapacity;count++) {
			if(slots.get(count-1).isAvailable()) {
				return false;
			}
		}
		return true;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
}
