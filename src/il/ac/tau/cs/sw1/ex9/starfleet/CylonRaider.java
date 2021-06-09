package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myAbstractCombatSpaceship {

	public static final int BASIC_ANNUAL_MAINTENANCE_COST = 3500;
	public static final int ENGINE_MAINTENANCE_COST = 1200;
	public static final int MAINT_COST_PER_CREW_MEMBER = 500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		_basicAnnualMaintCost = BASIC_ANNUAL_MAINTENANCE_COST;
		_engineMaintCost = ENGINE_MAINTENANCE_COST;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost() + _crewMembers.size() * MAINT_COST_PER_CREW_MEMBER;
	}
}
