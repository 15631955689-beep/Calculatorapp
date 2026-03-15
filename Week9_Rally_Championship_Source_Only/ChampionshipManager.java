import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Singleton class that manages the championship.
 */
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ArrayList<Driver> drivers;
    private ArrayList<RallyRaceResult> raceResults;

    private ChampionshipManager() {
        drivers = new ArrayList<Driver>();
        raceResults = new ArrayList<RallyRaceResult>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult raceResult) {
        raceResults.add(raceResult);
        totalRaces++;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<RallyRaceResult> getRaceResults() {
        return raceResults;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public static ArrayList<Driver> getChampionshipStandings() {
        ChampionshipManager manager = getInstance();
        ArrayList<Driver> standings = new ArrayList<Driver>(manager.drivers);

        Collections.sort(standings, new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                return d2.getTotalPoints() - d1.getTotalPoints();
            }
        });

        return standings;
    }

    public static Driver getLeadingDriver() {
        ArrayList<Driver> standings = getChampionshipStandings();
        if (standings.size() == 0) {
            return null;
        }
        return standings.get(0);
    }

    public static int getTotalChampionshipPoints() {
        ChampionshipManager manager = getInstance();
        int total = 0;
        for (int i = 0; i < manager.drivers.size(); i++) {
            total += manager.drivers.get(i).getTotalPoints();
        }
        return total;
    }
}
