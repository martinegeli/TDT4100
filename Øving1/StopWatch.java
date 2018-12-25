package stateandbehavior;

public class StopWatch {
	
	private int ticks;
	private int currentLap;
	private int lastLap;
	private int time;
	private boolean started = false;
	
	boolean isStarted() {
		return started;
	}
	boolean isStopped() {
		return !started;
	}
	
	int getTicks() {
		return ticks;
	}
	
	int getTime() {
		return time;
	}
	
	int getLapTime() {
		if (currentLap != 0) {
			return currentLap;
		} return -1;
	}
	
	int getLastLapTime() {
		if (lastLap != 0) {
			return lastLap;
		} return -1;
	}
	
	void tick(int ticks) {
		if (started) {
			this.ticks += ticks;
			currentLap += ticks;
		}
		time += ticks;
	}
	
	void start() {
		started=true;
	}
	
	void lap() {
		this.lastLap = currentLap;
		currentLap = 0;
		
	}
	
	void stop() {
		started = false;
	}
	
	public String toString() {
		return "Tid som totalt har gått: " + time + ". Rundetid: " + currentLap + " Sist runde: " + lastLap;
	}
	
	public static void main(String[] args) {
		StopWatch ticks = new StopWatch();
		ticks.tick(8);
		System.out.println(ticks.getTicks());
		ticks.lap();
		ticks.start();
		System.out.println(ticks.getLastLapTime());
		ticks.tick(7);
		System.out.println(ticks.toString());
		ticks.lap();
		System.out.println(ticks.toString());
		ticks.tick(12);
		ticks.lap();
		System.out.println(ticks.toString());
		ticks.tick(7);
		System.out.println(ticks.toString());
		ticks.tick(7);
		System.out.println(ticks.toString());

	}
}
