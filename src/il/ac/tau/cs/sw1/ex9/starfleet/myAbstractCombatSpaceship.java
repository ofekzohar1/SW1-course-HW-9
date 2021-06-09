package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class myAbstractCombatSpaceship extends myAbstractSpaceship {

    protected List<Weapon> _weapons;
    protected int _engineMaintCost;

    public myAbstractCombatSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons) {
        super(name, commissionYear, maximalSpeed, crewMembers);
        _weapons = new ArrayList<>(weapons);
        _engineMaintCost = 0;
    }

    public List<Weapon> getWeapon() {
        return _weapons;
    }

    @Override
    public int getFirePower() {
        int sumFirePower = 0;
        for (Weapon weapon : _weapons) {
            sumFirePower += weapon.getFirePower();
        }
        return super.getFirePower() + sumFirePower;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        int sumWeaponMaintCost = 0;
        for (Weapon weapon : _weapons) {
            sumWeaponMaintCost += weapon.getAnnualMaintenanceCost();
        }
        return super.getAnnualMaintenanceCost() + sumWeaponMaintCost + (int) (_engineMaintCost * _maximalSpeed);
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tWeaponArray=" + _weapons.toString();
    }
}
