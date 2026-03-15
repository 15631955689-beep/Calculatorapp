/**
 * Car for asphalt surfaces.
 */
public class AsphaltCar extends RallyCar {
    public AsphaltCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return getHorsepower() * 0.95 + 20.0;
    }
}
