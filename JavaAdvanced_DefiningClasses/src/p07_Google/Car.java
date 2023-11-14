package p07_Google;

public class Car {
    private String carModel;
    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String format(){
        return String.format("%s %d", carModel, carSpeed);
    }
}