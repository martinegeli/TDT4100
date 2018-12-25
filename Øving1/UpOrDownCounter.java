package stateandbehavior;

public class UpOrDownCounter {
	int end;
	int counter;
	
	public UpOrDownCounter(int start, int end) {
		if (start==end) {
			throw new IllegalArgumentException("Prøv på nytt");
		}else {
			this.end=end;
			this.counter=start;
		}
	}
	
	int getCounter() {
		return counter;
	}
	
	public boolean count() {
		if (counter<end) {
			this.counter++;
		}
		else if(counter>end) {
			this.counter--;
		}
		else {
			return false;
		} return true;
	}
	
	public String toString() {
		return "Counter = "+ counter + " end = " + end;
	}
	public static void main(String[] args) {
		UpOrDownCounter counter = new UpOrDownCounter(10,9);
		System.out.println(counter.toString());

		counter.count();
		System.out.println(counter.toString());

		counter.count();
		System.out.println(counter.toString());
		
		
	}
		
	
}

