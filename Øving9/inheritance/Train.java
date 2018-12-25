package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Train {
	
	public List<TrainCar> vogner;
	public int totalWeight;
	public int totalPassenger;
	public int totalCargo;
	
	public String s;
	
	public Train() {
		this.vogner = new ArrayList<TrainCar>();
	}
	
	public void addTrainCar(TrainCar trainCar) {
		vogner.add(trainCar);
	}
	
	public boolean contains(TrainCar trainCar) {
		return vogner.contains(trainCar);
	}
	
	public int getTotalWeight() {
		
		for(TrainCar vogn : vogner) {
			if(vogn instanceof TrainCar) {
				totalWeight += vogn.getTotalWeight();
			}
		}
		return totalWeight;
	}
	
	public int getPassengerCount() {
		for(TrainCar vogn : vogner) {
			if (vogn instanceof PassengerCar) {
				this.totalPassenger += ((PassengerCar) vogn).getPassengerCount();

			}
		}
		return totalPassenger;
	}
	
	public int getCargoWeight() {
		for(TrainCar vogn : vogner) {
			if(vogn instanceof CargoCar) {
				this.totalCargo += ((CargoCar) vogn).getCargoWeight();
			}
		}
		return totalCargo;
	}
	
	public String toString() {
		for(TrainCar vogn : vogner) {
			s += "\n Vognen tilhører " + vogn.getClass().toString().substring(18) + " og veier " + vogn.getTotalWeight();
			if (vogn instanceof CargoCar){
				s+= " og har last " + ((CargoCar)vogn).getCargoWeight() + "\n";
			}
			if (vogn instanceof PassengerCar){
				s += " og har antallet passasjerer " + ((PassengerCar)vogn).getPassengerCount() + " og får dermed totalvekt " + ((PassengerCar)vogn).getTotalWeight();
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		Train trains = new Train();
		CargoCar cargo = new CargoCar(2000,500);
		PassengerCar passenger = new PassengerCar(2500,8);
		TrainCar trainCar = new TrainCar(1500);
		trains.addTrainCar(cargo);
		trains.addTrainCar(passenger);
		trains.addTrainCar(trainCar);
		System.out.println(trains.toString());
	}
	
}
