package p03_SpeedRacing;

public class Car {
    private final String model;
    private double fuelAmount;
    private final double fuelCostForOneKilometer;
    private int travelledKilometers;

    public Car(String model, double fuelAmount, double fuelCostForOneKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
        setTravelledKilometers(0);
    }

    public void driveCar(int amountOfKilometers) {
        if (amountOfKilometers * this.fuelCostForOneKilometer <= fuelAmount) {
            fuelAmount -= amountOfKilometers * this.fuelCostForOneKilometer;
            setTravelledKilometers(amountOfKilometers + this.travelledKilometers);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void setTravelledKilometers(int travelledKilometers) {
        this.travelledKilometers = travelledKilometers;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.travelledKilometers);
    }
}