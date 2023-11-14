package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Cloth> getData() {
        return data;
    }

    public void addCloth(Cloth cloth) {
        if (this.data.size() < this.capacity) {
            this.data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        for (Cloth cloth : this.data) {
            if (cloth.getColor().equals(color)) {
                this.data.remove(cloth);
                return true;
            }
        }

        return false;
    }

    public Cloth getSmallestCloth() {
        Optional<Cloth> cloth = this.data.stream().min(Comparator.comparingInt(Cloth::getSize));
        return cloth.orElse(null);
    }

    public Cloth getCloth(String color) {
        Cloth clothToReturn = null;

        for (Cloth cloth : this.data) {
            if (cloth.getColor().equals(color)) {
                clothToReturn = cloth;
            }
        }

        return clothToReturn;
    }

    public int getCount() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type).append(" magazine contains:").append(System.lineSeparator());
        this.data.forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}