package il.ac.tau.cs.sw1.ex9.starfleet;

public class Officer extends CrewWoman {

	protected OfficerRank _rank;

	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age, yearsInService, name);
		_rank = rank;
	}

	public OfficerRank getRank() {
		return _rank;
	}
}
