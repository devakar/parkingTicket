package parkingTicket;

import java.util.ArrayList;
import java.util.List;

public class ParkingArea {
	private int levelCount;
	private int capacity;
	public List<Level> levels;
	
	public ParkingArea(int levelCount, int slotsPerLevel) {
		this.levelCount=levelCount;
		this.capacity=levelCount * slotsPerLevel;
		this.levels = new ArrayList<Level>();
		
//		int levelCapacity=capacity/levelCount;
//		int remainingCapacity = capacity%levelCount;
//		int i=0;
		
		for(int i=0;i<levelCount;i++) {
			this.levels.add(new Level(i+1, slotsPerLevel));
		}
		//this.levels.add(new Level(i+1, levelCapacity+remainingCapacity));
	}
	
	
	
	public int getLevelCount() {
		return levelCount;
	}



	public void setLevelCount(int levelCount) {
		this.levelCount = levelCount;
	}



	public int getCapacity() {
		return capacity;
	}



	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}



	public List<Level> getLevels() {
		return levels;
	}



	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}



	public boolean isParkingAreaFull() {
		int count=1;
		for(;count<=levelCount;count++) {
			if(!levels.get(count-1).isLevelFull()) {
				return false;
			}
		}
		return true;
	}
}
