package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class StopWatchManager {
	
	private Map<String, StopWatch> sw = new HashMap<String, StopWatch>();
	
	public StopWatch newStopWatch(String name) {
		StopWatch stopwatch = new StopWatch();
		sw.put(name, stopwatch);
		return stopwatch;
	}
	
	public void removeStopWatch(String name) {
			sw.remove(name);
	}
	
	public void tick(int ticks) {
		if (ticks < 0) {
			throw new IllegalArgumentException("Tiden kan ikke gå bakover");
		}
		for (StopWatch stopwatch : sw.values()) {
			stopwatch.tick(ticks);
		}
	}
	
	public StopWatch getStopWatch(String name) {
		return sw.get(name);
	}
	
	public Collection<StopWatch> getWatches(boolean started, boolean stopped){
		Collection<StopWatch> result = new ArrayList<StopWatch>();
		for (StopWatch stopwatch : sw.values()) {
			if ((stopwatch.isStarted() == started || started == null) && (stopwatch.isStopped() == stopped || stopped == null)){
				result.add(stopwatch);
			}
		}
		return result;
	}
	
	public Collection<StopWatch> getAllWatches(){
		return getWatches(null, null);
	}
	
	public Collection<StopWatch> getStartedWatches(){
		return getWatches(true, null);
	}
	
	public Collection<StopWatch> getStoppedWatches(){
		return getWatches(null, true);
	}
	
}
