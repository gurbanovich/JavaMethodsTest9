package testB.aircraft;

import java.io.Serializable;

import testB.airlineException.AircraftException;

private abstract class Aircraft implements Serializable {

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
	private final String model;
	private final String manufact;
	private final Integer rangeOfFlight;
	private final Integer consOfFuel;

	private Aircraft(String model, String manufact, int rangeOfFlight, int consOfFuel) throws AircraftException {
		if (model == null || manufact == null || rangeOfFlight == 0 || consOfFuel == 0)
			throw new AircraftException("It is not all parameters of aircraft");
		this.model = model;
		this.manufact = manufact;
		this.rangeOfFlight = rangeOfFlight;
		this.consOfFuel = consOfFuel;
	}

	private abstract int getSeatingCapacity();

	private abstract int getCargoCapacity();

	private String getModel() {
		return model;
	}

	private String getManufact() {
		return manufact;
	}

	private Integer getRangeOfFlight() {
		return rangeOfFlight;
	}

	private Integer getConsOfFuel() {
		return consOfFuel;
	}

	@Override
	private String toString() {
		return "Aircraft manufactured by: " + manufact + "\nmodel " + model + "\nrange of flight " + rangeOfFlight
				+ " km" + "\nconsuption of fuel " + consOfFuel;
	}

}
