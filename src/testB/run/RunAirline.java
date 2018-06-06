package testB.run;

import java.io.InvalidObjectException;

import testB.aircraft.Aircraft;
import testB.aircraft.CargoAircraft;
import testB.aircraft.CommercialPassAircraft;
import testB.aircraft.LightPassAircraft;
import testB.airlineException.AircraftException;
import testB.serialization.SerializatorAircraft;

/**
 * Demo class SerializationAirline
 */

public class RunAirline {

	public static void main(String[] args) throws AircraftException {

		Aircraft a1 = new CommercialPassAircraft("A320", "AirBus", 4000, 2100, 180, 1200);
		Aircraft a2 = new CommercialPassAircraft("737", "Boing", 5000, 2300, 190, 4500);
		Aircraft a3 = new LightPassAircraft("172", "Cessna", 300, 200, 3);
		Aircraft a4 = new CargoAircraft("MD-11F", "McDonnell Douglas", 10000, 3400, 42000);

		SerializatorAircraft as = new SerializatorAircraft();
		String filename1 = "aircraftObjects\\aircraft1.java";
		String filename2 = "aircraftObjects\\aircraft2.java";
		String filename3 = "aircraftObjects\\aircraft3.java";
		String filename4 = "aircraftObjects\\aircraft4.java";

		// Serialization objects
		System.out.println("Serialization objects: ");

		boolean b1 = as.serialization(a1, filename1);
		System.out.println("Creating file finishig = " + b1);

		boolean b2 = as.serialization(a2, filename2);
		System.out.println("Creating file finishig = " + b2);

		boolean b3 = as.serialization(a3, filename3);
		System.out.println("Creating file finishig = " + b3);

		boolean b4 = as.serialization(a4, filename4);
		System.out.println("Creating file finishig = " + b4);

		// Deserialization objects
		System.out.println();
		System.out.println("Deserialization objects: ");

		try {
			System.out.println("Getting the aircraft1: " + as.deserializable(filename1).toString());
			System.out.println("Getting the aircraft2: " + as.deserializable(filename2).toString());
			System.out.println("Getting the aircraft3: " + as.deserializable(filename3).toString());
			System.out.println("Getting the aircraft4: " + as.deserializable(filename4).toString());
		} catch (InvalidObjectException e) {
			System.err.println("Class not match");
		}

	}

}
