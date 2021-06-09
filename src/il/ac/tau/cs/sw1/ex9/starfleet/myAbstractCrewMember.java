package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myAbstractCrewMember implements CrewMember {
    protected String _name;
    protected int _age;
    protected int _yearsInService;

    public myAbstractCrewMember(String name, int age, int yearsInService) {
        _name = name;
        _age = age;
        _yearsInService = yearsInService;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getAge() {
        return _age;
    }

    @Override
    public int getYearsInService() {
        return _yearsInService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractCrewMember that = (myAbstractCrewMember) o;
        return Objects.equals(_name, that._name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_name);
    }
}
