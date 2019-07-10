package parkingTicket;

public class Slot {
	private int slotId;
	private boolean isEmpty;
	
	public Slot(int slotId) {
		this.slotId=slotId;
		this.isEmpty=true;
	}
	
	public boolean isAvailable() {
		return isEmpty;
	}
	
	public int getSlotId() {
		return slotId;
	}
	
	public void makeAvailable() {
		this.isEmpty=true;
	}
	
	public void makeUnAvailable() {
		this.isEmpty=false;
	}
}
