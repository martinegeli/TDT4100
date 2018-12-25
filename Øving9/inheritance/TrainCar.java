package inheritance;

public class TrainCar {
	
	private int deadWeight;
	
	public TrainCar(int weight) {
		this.deadWeight = weight;
	}
	
	protected int getTotalWeight() {
		return deadWeight;
	}
	
	protected void setDeadWeight(int weight) {
		this.deadWeight = weight;
	}
	
	protected int getDeadWeight() {
		return deadWeight;
	}
	
}
