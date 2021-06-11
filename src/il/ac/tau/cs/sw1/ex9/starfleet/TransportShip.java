package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceship {

	public static final int BASIC_ANNUAL_MAINTENANCE_COST = 3000;
	public static final int COST_PER_MEGATON_CARGO = 5;
	public static final int COST_PER_MEGATON_PASSENGERS = 3;

	protected int _cargoCapacity;
	protected int _passengerCapacity;

	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		_basicAnnualMaintCost = BASIC_ANNUAL_MAINTENANCE_COST;
		_cargoCapacity = cargoCapacity;
		_passengerCapacity = passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		// Add maintenance cost per MT passengers and MT cargo
		return super.getAnnualMaintenanceCost() + (COST_PER_MEGATON_CARGO * _cargoCapacity) + (COST_PER_MEGATON_PASSENGERS * _passengerCapacity);
	}

	@Override
	public String toString() {
		String desc = "\n\tCargoCapacity=" + _cargoCapacity + "\n\tPassengerCapacity=" +_passengerCapacity;
		return super.toString() + desc;
	}

	public int getCargoCapacity() {
		return _cargoCapacity;
	}

	public int getPassengerCapacity() {
		return _passengerCapacity;
	}
}
