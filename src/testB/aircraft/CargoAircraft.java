package testB.aircraft;

import testB.airlineException.AircraftException;

public class CargoAircraft extends Aircraft {

	/**
	 * Represents an invocation context for a service operation. A
	 * ServiceContext is associated with the thread's local state automatically
	 * when it is created. A call to getInstance() will return the
	 * ServiceContext for the the current thread only. The close() method will
	 * release all ServiceResources from the thread's state. The constructor and
	 * close() methods are protected so that only the subclasses can invoke
	 * them. This allows the framework control over the lifecycle of the context
	 * and prevents other objects from access the thread state directly.
	 * <p/>
	 *
	 * This object is not thread-safe and must never be shared across threads.
	 * <p/>
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int cargoCapacity;

	public CargoAircraft(String model, String manufact, int rangeOfFlight, int consOfFuel, int cargoCapacity)
			throws AircraftException {
		super(model, manufact, rangeOfFlight, consOfFuel);
		if (cargoCapacity == 0)
			throw new AircraftException("It is not cargo aircraft");
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public int getSeatingCapacity() {
		return 0;
	}

	@Override
	public int getCargoCapacity() {
		return cargoCapacity;
	}

}
