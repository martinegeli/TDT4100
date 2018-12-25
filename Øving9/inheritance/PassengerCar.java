package inheritance;

public class PassengerCar extends TrainCar{
	
	public int passasjerer;
	
	public PassengerCar(int weight, int passasjerer) {
		super(weight);
		this.passasjerer = passasjerer;
	}
	
	public int getPassengerCount() {
		return passasjerer;
	}
	
	public void setPassengerCount(int passasjerer) {
		this.passasjerer = passasjerer;
	}
	
	protected int getTotalWeight() {
		return super.getDeadWeight() + passasjerer*80;
	}
	
	
}
