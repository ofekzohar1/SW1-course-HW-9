package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.*;
import java.util.stream.Collectors;

public class StarfleetManager {

    /**
     * Returns a list containing string representation of all fleet ships, sorted in descending order by
     * fire power, and then in descending order by commission year, and finally in ascending order by
     * name
     */
    public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
        return fleet.stream().sorted(Collections.reverseOrder()).map(Spaceship::toString).collect(Collectors.toList());
    }

    /**
     * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
     */
    public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
        // x.getClass().getSimpleName() == ship type, summingInt count the type
        return fleet.stream().collect(Collectors.groupingBy(x -> x.getClass().getSimpleName(), Collectors.summingInt(x -> 1)));
    }


    /**
     * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
     */
    public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
        // Sum maintenance cost
        return fleet.stream().mapToInt(Spaceship::getAnnualMaintenanceCost).sum();
    }


    /**
     * Returns a set containing the names of all the fleet's weapons installed on any ship
     */
    public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
        return fleet.stream().filter(x -> x instanceof myAbstractCombatSpaceship).map(x -> ((myAbstractCombatSpaceship) x).getWeapon())
                .flatMap(List::stream).map(Weapon::getName).collect(Collectors.toSet());
    }

    /**
     * Returns the total number of crew-members serving on board of the given fleet's ships.
     */
    public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
        return fleet.stream().map(Spaceship::getCrewMembers).mapToInt(Set::size).sum();
    }

    /**
     * Returns the average age of all officers serving on board of the given fleet's ships.
     */
    public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
        return fleet.stream().flatMap(x -> x.getCrewMembers().stream()).filter(x -> x instanceof Officer).map(x -> (Officer) x)
                .collect(Collectors.averagingDouble(Officer::getAge)).floatValue();
    }

    /**
     * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
     */
    public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
        HashMap<Officer, Spaceship> highestRankingOfficerPerShip = new HashMap<>();
        for (Spaceship ship : fleet) {
            OfficerRank maxRank = OfficerRank.Ensign; // Lowest rank
            Officer highestRankOfficer = null;
            for (CrewMember member : ship.getCrewMembers()) {
                if (member instanceof Officer) { // Only if CrewMember is Officer
                    Officer officer = (Officer) member;
                    if (officer.getRank().compareTo(maxRank) >= 0) { // Save the maximal rank for each ship
                        maxRank = officer.getRank();
                        highestRankOfficer = officer;
                    }
                }
            }
            if (highestRankOfficer != null) // At least one officer on board
                highestRankingOfficerPerShip.put(highestRankOfficer, ship);
        }
        return highestRankingOfficerPerShip;
    }

    /**
     * Returns a List of entries representing ranks and their occurrences.
     * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
     * The returned list is sorted ascendingly based on the number of occurrences.
     */
    public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
        HashMap<OfficerRank, Integer> officerRanksCounter = new HashMap<>();
        for (Spaceship ship : fleet) {
            for (CrewMember member : ship.getCrewMembers()) {
                if (member instanceof Officer) { // Only if CrewMember is Officer
                    Officer officer = (Officer) member;
                    // Merge method - if key (Officer) exists add 1 to it's value, if not exist add as new key with value 1
                    officerRanksCounter.merge(officer.getRank(), 1, Integer::sum);
                }
            }
        }
        List<Map.Entry<OfficerRank, Integer>> listOfRanksCounter = new ArrayList<>(officerRanksCounter.entrySet());
        // Sort using lambda expression
        listOfRanksCounter.sort((o1, o2) -> {
            int comp = Integer.compare(o1.getValue(), o2.getValue());
            if (comp != 0)
                return comp;
            return o1.getKey().compareTo(o2.getKey());
        });
        return listOfRanksCounter;
    }

}
