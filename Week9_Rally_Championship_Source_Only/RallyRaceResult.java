import java.util.ArrayList;

/**
 * Represents one rally race result.
 */
public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private String surface;
    private ArrayList<ResultEntry> results;

    /**
     * Simple inner class for one finishing result.
     */
    private static class ResultEntry {
        private Driver driver;
        private int position;
        private int points;

        public ResultEntry(Driver driver, int position, int points) {
            this.driver = driver;
            this.position = position;
            this.points = points;
        }
    }

    public RallyRaceResult(String raceName, String location, String surface) {
        this.raceName = raceName;
        this.location = location;
        this.surface = surface;
        this.results = new ArrayList<ResultEntry>();
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    public String getSurface() {
        return surface;
    }

    public ArrayList<Driver> getDriversInRace() {
        ArrayList<Driver> list = new ArrayList<Driver>();
        for (int i = 0; i < results.size(); i++) {
            list.add(results.get(i).driver);
        }
        return list;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.add(new ResultEntry(driver, position, points));
        driver.addPoints(points);
    }

    @Override
    public String getResultsSummary() {
        String text = "Race: " + raceName + " (" + location + ", " + surface + ")\n";
        for (int i = 0; i < results.size(); i++) {
            ResultEntry entry = results.get(i);
            text += " Position " + entry.position + ": " + entry.driver.getName()
                    + " - " + entry.points + " points\n";
        }
        return text;
    }
}
