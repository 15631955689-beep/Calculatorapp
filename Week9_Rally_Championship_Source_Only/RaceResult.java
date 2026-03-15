/**
 * Interface for race results.
 */
public interface RaceResult {
    void recordResult(Driver driver, int position, int points);
    String getResultsSummary();
}
