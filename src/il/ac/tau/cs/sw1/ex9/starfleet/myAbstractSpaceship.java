package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship {
    protected String _name;
    protected int _commissionYear;
    protected float _maximalSpeed;
    protected Set<? extends CrewMember> _crewMembers;
    protected int _basicAnnualMaintCost;

    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
        _name = name;
        _commissionYear = commissionYear;
        _maximalSpeed = maximalSpeed;
        _crewMembers = new HashSet<>(crewMembers);
        _basicAnnualMaintCost = 0;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getCommissionYear() {
        return _commissionYear;
    }

    @Override
    public float getMaximalSpeed() {
        return _maximalSpeed;
    }

    @Override
    public int getFirePower() {
        return Spaceship.BASIC_FIRE_POWER;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return _crewMembers;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return _basicAnnualMaintCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractSpaceship that = (myAbstractSpaceship) o;
        return Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\n\tName=" + _name +
                "\n\tCommissionYear=" + _commissionYear +
                "\n\tMaximalSpeed=" + _maximalSpeed +
                "\n\tFirePower=" + getFirePower() +
                "\n\tCrewMembers=" + _crewMembers.size() +
                "\n\tAnnualMaintenanceCost=" + getAnnualMaintenanceCost();
    }

    @Override
    public int compareTo(Spaceship o) {
        int compResult;
        compResult = Integer.compare(this.getFirePower(), o.getFirePower());
        if (compResult != 0)
            return compResult;
        compResult = Integer.compare(this._commissionYear, o.getCommissionYear());
        if (compResult != 0)
            return compResult;
        return o.getName().compareTo(this._name);
    }

}
