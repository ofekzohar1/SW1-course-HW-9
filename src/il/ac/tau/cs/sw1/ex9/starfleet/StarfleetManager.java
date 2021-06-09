package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

    /**
     * Returns a list containing string representation of all fleet ships, sorted in descending order by
     * fire power, and then in descending order by commission year, and finally in ascending order by
     * name
     */
    public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear(Collection<Spaceship> fleet) {
        ArrayList<Spaceship> fleetList = new ArrayList<>(fleet);
        fleetList.sort(Collections.reverseOrder());
        ArrayList<String> sortedFlettAsStrings = new ArrayList<>();
        for (Spaceship ship : fleetList) {
            sortedFlettAsStrings.add(ship.toString());
        }
        return sortedFlettAsStrings;
    }

    /**
     * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
     */
    public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
        HashMap<String, Integer> fleetCounter = new HashMap<>();
        for (Spaceship ship : fleet) {
            fleetCounter.merge(ship.getClass().getSimpleName(), 1, Integer::sum);
        }
        return fleetCounter;
    }


    /**
     * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
     */
    public static int getTotalMaintenanceCost(Collection<Spaceship> fleet) {
        int sumMaintCost = 0;
        for (Spaceship ship : fleet) {
            sumMaintCost += ship.getAnnualMaintenanceCost();
        }
        return sumMaintCost;
    }


    /**
     * Returns a set containing the names of all the fleet's weapons installed on any ship
     */
    public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
        HashSet<String> weaponsSet = new HashSet<>();
        for (Spaceship ship : fleet) {
            if (ship instanceof myAbstractCombatSpaceship) {
                myAbstractCombatSpaceship combatShip = (myAbstractCombatSpaceship) ship;
                for (Weapon weapon : combatShip.getWeapon()) {
                    weaponsSet.add(weapon.getName());
                }
            }
        }
        return weaponsSet;
    }

    /**
     * Returns the total number of crew-members serving on board of the given fleet's ships.
     */
    public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
        int sumTotalCrewMembers = 0;
        for (Spaceship ship : fleet) {
            sumTotalCrewMembers += ship.getCrewMembers().size();
        }
        return sumTotalCrewMembers;
    }

    /**
     * Returns the average age of all officers serving on board of the given fleet's ships.
     */
    public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
        int countTotalOfficers = 0;
        int sumAges = 0;
        for (Spaceship ship : fleet) {
            for (CrewMember member : ship.getCrewMembers()) {
                if (member instanceof Officer) {
                    countTotalOfficers++;
                    sumAges += member.getAge();
                }
            }
        }
        return (float) sumAges / countTotalOfficers;
    }

    /**
     * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
     */
    public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
        HashMap<Officer, Spaceship> highestRankingOfficerPerShip = new HashMap<>();
        for (Spaceship ship : fleet) {
            OfficerRank maxRank = OfficerRank.Ensign;
            Officer highestRankOfficer = null;
            for (CrewMember member : ship.getCrewMembers()) {
                if (member instanceof Officer) {
                    Officer officer = (Officer) member;
                    if (officer.getRank().compareTo(maxRank) >= 0) {
                        maxRank = officer.getRank();
                        highestRankOfficer = officer;
                    }
                }
            }
            if (highestRankOfficer != null)
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
                if (member instanceof Officer) {
                    Officer officer = (Officer) member;
                    officerRanksCounter.merge(officer.getRank(), 1, Integer::sum);
                }
            }
        }
        List<Map.Entry<OfficerRank, Integer>> listOfRanksCounter = new ArrayList<>(officerRanksCounter.entrySet());
        listOfRanksCounter.sort((o1, o2) -> {
            int comp = Integer.compare(o1.getValue(), o2.getValue());
            if (comp != 0)
                return comp;
            return o1.getKey().compareTo(o2.getKey());
        });
        return listOfRanksCounter;
    }

}
