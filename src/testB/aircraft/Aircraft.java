package testB.aircraft;

import java.io.Serializable;

import testB.airlineException.AircraftException;

public abstract class Aircraft implements Serializable {

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

	public Aircraft(String model, String manufact, int rangeOfFlight, int consOfFuel) throws AircraftException {
		if (model == null || manufact == null || rangeOfFlight == 0 || consOfFuel == 0)
			throw new AircraftException("It is not all parameters of aircraft");
		this.model = model;
		this.manufact = manufact;
		this.rangeOfFlight = rangeOfFlight;
		this.consOfFuel = consOfFuel;
	}

	public abstract int getSeatingCapacity();

	public abstract int getCargoCapacity();

	public String getModel() {
		return model;
	}

	public String getManufact() {
		return manufact;
	}

	public Integer getRangeOfFlight() {
		return rangeOfFlight;
	}

	public Integer getConsOfFuel() {
		return consOfFuel;
	}

	@Override
	public String toString() {
		return "Aircraft manufactured by: " + manufact + "\nmodel " + model + "\nrange of flight " + rangeOfFlight
				+ " km" + "\nconsuption of fuel " + consOfFuel;
	}

}
