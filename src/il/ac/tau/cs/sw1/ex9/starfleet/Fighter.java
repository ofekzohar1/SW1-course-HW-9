package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractCombatSpaceship {

	public static final int BASIC_ANNUAL_MAINTENANCE_COST = 2500;
	public static final int ENGINE_MAINTENANCE_COST = 1000;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		_basicAnnualMaintCost = BASIC_ANNUAL_MAINTENANCE_COST;
		_engineMaintCost = ENGINE_MAINTENANCE_COST;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost();
	}
}
