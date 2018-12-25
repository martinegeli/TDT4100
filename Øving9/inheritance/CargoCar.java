package inheritance;

public class CargoCar extends TrainCar{

	public int last;

	
	public CargoCar(int weight, int last) {
		super(weight);
		this.last = last;
		// TODO Auto-generated constructor stub
	}
	
	public int getCargoWeight() {
		return last;
	}
	
	public void setCargoWeight(int last) {
		this.last = last;
	}
	
	
	protected int getTotalWeight() {
		return super.getDeadWeight() + this.last;
	}
	
}
