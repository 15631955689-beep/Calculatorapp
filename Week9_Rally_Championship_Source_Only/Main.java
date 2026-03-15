import java.util.ArrayList;

/**
 * Main class to run the rally championship system.
 */
public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelToyota = new GravelCar("Toyota", "GR Yaris Rally1", 480);
        RallyCar asphaltHyundai = new AsphaltCar("Hyundai", "i20 N Rally1", 475);
        RallyCar gravelFord = new GravelCar("Ford", "Puma Rally1", 470);
        RallyCar asphaltToyota = new AsphaltCar("Toyota", "GR Yaris Asphalt", 476);

        Driver ogier = new Driver("Sebastien Ogier", "France", gravelToyota);
        Driver rovanpera = new Driver("Kalle Rovanpera", "Finland", asphaltHyundai);
        Driver tanak = new Driver("Ott Tanak", "Estonia", gravelFord);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltHyundai);

        manager.registerDriver(ogier);
        manager.registerDriver(rovanpera);
        manager.registerDriver(tanak);
        manager.registerDriver(neuville);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyvaskyla", "Gravel");
        race1.recordResult(ogier, 1, 25);
        race1.recordResult(tanak, 2, 18);
        race1.recordResult(rovanpera, 3, 15);
        race1.recordResult(neuville, 4, 12);
        manager.addRaceResult(race1);

        rovanpera.setCar(asphaltToyota);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco", "Asphalt");
        race2.recordResult(rovanpera, 1, 25);
        race2.recordResult(neuville, 2, 18);
        race2.recordResult(ogier, 3, 15);
        race2.recordResult(tanak, 4, 12);
        manager.addRaceResult(race2);

        printStandings();
        System.out.println();

        printLeader();
        System.out.println();

        printStatistics(manager.getDrivers());
        System.out.println();

        printRaceResults(manager.getRaceResults());
        System.out.println();

        printCarPerformance(ogier, rovanpera);
    }

    public static void printStandings() {
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        ArrayList<Driver> standings = ChampionshipManager.getChampionshipStandings();

        for (int i = 0; i < standings.size(); i++) {
            Driver driver = standings.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" 
                    + driver.getCountry() + "): " 
                    + driver.getTotalPoints() + " points");
        }
    }

    public static void printLeader() {
        Driver leader = ChampionshipManager.getLeadingDriver();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        if (leader != null) {
            System.out.println(leader.getName() + " with " 
                    + leader.getTotalPoints() + " points");
        }
    }

    public static void printStatistics(ArrayList<Driver> drivers) {
        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.getTotalRacesHeld());
        System.out.printf("Average Points Per Driver: %.2f%n",
                ChampionshipStatistics.calculateAveragePointsPerDriver(drivers));
        System.out.println("Most Successful Country: "
                + ChampionshipStatistics.findMostSuccessfulCountry(drivers));
        System.out.println("Total Championship Points: "
                + ChampionshipManager.getTotalChampionshipPoints());
    }

    public static void printRaceResults(ArrayList<RallyRaceResult> races) {
        System.out.println("===== RACE RESULTS =====");

        for (int i = 0; i < races.size(); i++) {
            System.out.print(races.get(i).getResultsSummary());
        }
    }

    public static void printCarPerformance(Driver d1, Driver d2) {
        System.out.println("===== CAR PERFORMANCE RATINGS =====");

        System.out.println(d1.getName() + " car: " + d1.getCar());
        System.out.printf("Performance: %.1f%n", d1.getCar().calculatePerformance());

        System.out.println(d2.getName() + " car: " + d2.getCar());
        System.out.printf("Performance: %.1f%n", d2.getCar().calculatePerformance());
    }
}