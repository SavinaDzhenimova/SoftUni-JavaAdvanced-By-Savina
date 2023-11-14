package p04_RawData;

public class Car {
    private final String model;
    private final Engine engine;
    private final Cargo cargo;
    private final Tires tires;

    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Tires getTires() {
        return tires;
    }

    public Engine getEngine() {
        return engine;
    }
}