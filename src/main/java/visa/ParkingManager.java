package visa;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParkingManager {

	private Queue<Integer> parkingSpaces;

	private ParkingManager(int count) {
		parkingSpaces = new LinkedBlockingQueue<>();
		for (int i = 0; i < count; i++) {
			parkingSpaces.add(i);
		}

	}

	public Integer getSpot() {
		return parkingSpaces.poll();

	}

	public boolean isSpotAvalable() {
		return parkingSpaces.isEmpty() ? false : true;

	}

	public void releaseSpot(Integer number) {
		parkingSpaces.add(number);

	}

	public ParkingManager getInstance(int count) {
		return ParkingManagerCreator.INSTANCE(count);
	}

	private static class ParkingManagerCreator {
		private static final ParkingManager INSTANCE(int count) {

			return new ParkingManager(count);
		}

	}

}
