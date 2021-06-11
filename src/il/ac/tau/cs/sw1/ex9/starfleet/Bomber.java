package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbstractCombatSpaceship {

    public static final int BASIC_ANNUAL_MAINTENANCE_COST = 5000;
    public static final int ENGINE_MAINTENANCE_COST = 0;
    public static final float TECHNICIANS_DISCOUNT = 0.1f;
    public static final int MAX_TECHNICIANS = 5;
    public static final int MIN_TECHNICIANS = 0;

    protected int _numberOfTechnicians;

    public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians) {
        super(name, commissionYear, maximalSpeed, crewMembers, weapons);
        _basicAnnualMaintCost = BASIC_ANNUAL_MAINTENANCE_COST;
        _engineMaintCost = ENGINE_MAINTENANCE_COST;
        _numberOfTechnicians = numberOfTechnicians;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        // Calculate technicians discount on weapons' maintenance - 10% per technician
        int weaponCost = (int) ((super.getAnnualMaintenanceCost() - BASIC_ANNUAL_MAINTENANCE_COST) * (1 - _numberOfTechnicians * TECHNICIANS_DISCOUNT));
        return weaponCost + BASIC_ANNUAL_MAINTENANCE_COST;
    }

    public int getNumberOfTechnicians() {
        return _numberOfTechnicians;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tNumberOfTechnicians=" + _numberOfTechnicians;
    }
}
