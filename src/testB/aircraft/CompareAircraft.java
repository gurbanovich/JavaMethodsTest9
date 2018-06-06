package testB.aircraft;

import java.util.Comparator;

public class CompareAircraft implements Comparator<Aircraft> {

	@Override
	public int compare(Aircraft a1, Aircraft a2) {
		return new Integer(a1.getConsOfFuel()).compareTo(a2.getConsOfFuel());
	}

}
