package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVIN().equals(vin)) {
                this.vehicles.remove(vehicle);
                return true;
            }
        }

        return false;
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        Optional<Vehicle> lowestMileageVehicle = vehicles.stream()
                .min(Comparator.comparingInt(Vehicle::getMileage));
        return lowestMileageVehicle.orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:").append(System.lineSeparator());
        this.vehicles.forEach(v -> sb.append(v.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}