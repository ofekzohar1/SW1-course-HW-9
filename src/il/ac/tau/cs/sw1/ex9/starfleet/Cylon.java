package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends myAbstractCrewMember {

	public static final int MODEL_MIN_RANGE = 1;
	public static final int MODEL_MAX_RANGE = 12;

	protected int _modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(name, age, yearsInService);
		_modelNumber = modelNumber;
	}

	public int getModelNumber() {
		return _modelNumber;
	}
}
