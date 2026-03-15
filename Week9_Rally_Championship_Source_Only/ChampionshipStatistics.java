import java.util.ArrayList;
import java.util.HashMap;

/**
 * Utility class with only static methods.
 */
public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(ArrayList<Driver> drivers) {
        if (drivers.size() == 0) {
            return 0.0;
        }

        int total = 0;
        for (int i = 0; i < drivers.size(); i++) {
            total += drivers.get(i).getTotalPoints();
        }
        return (double) total / drivers.size();
    }

    public static String findMostSuccessfulCountry(ArrayList<Driver> drivers) {
        if (drivers.size() == 0) {
            return "No country";
        }

        HashMap<String, Integer> countryPoints = new HashMap<String, Integer>();

        for (int i = 0; i < drivers.size(); i++) {
            Driver driver = drivers.get(i);
            String country = driver.getCountry();
            int points = driver.getTotalPoints();

            if (countryPoints.containsKey(country)) {
                countryPoints.put(country, countryPoints.get(country) + points);
            } else {
                countryPoints.put(country, points);
            }
        }

        String bestCountry = "";
        int bestPoints = -1;

        for (String country : countryPoints.keySet()) {
            int points = countryPoints.get(country);
            if (points > bestPoints) {
                bestPoints = points;
                bestCountry = country;
            }
        }

        return bestCountry;
    }

    public static int getTotalRacesHeld() {
        return ChampionshipManager.getTotalRaces();
    }
}
