package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public interface Spaceship extends Comparable<Spaceship> {
	float MAX_SPEED = 10.0f;
	float MIN_SPEED = 0.0f;
	int BASIC_FIRE_POWER = 10; // Basic fire power for each spaceship

	String getName();
	int getCommissionYear();
	float getMaximalSpeed();
	int getFirePower();
	Set<? extends CrewMember> getCrewMembers(); // Crew members on board
	int getAnnualMaintenanceCost();
}
