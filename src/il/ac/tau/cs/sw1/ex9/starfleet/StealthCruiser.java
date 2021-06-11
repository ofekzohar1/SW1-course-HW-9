package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter {

	private static int engineCounter = 0;
	private static final Weapon LASER_CANNONS = new Weapon("Laser Cannons",10,100);
	public static final int ADDED_MAINT_COST_PER_ENGINE = 50;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		engineCounter++;
	}

	/**
	 * Constructor with default weapons list (LASER_CANNONS)
	 */
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(LASER_CANNONS));
	}

	@Override
	public int getAnnualMaintenanceCost() {
		// Add extra engine maintenance cost in direct proportion to the number of engines in the fleet
		return super.getAnnualMaintenanceCost() + ADDED_MAINT_COST_PER_ENGINE * engineCounter;
	}
}
