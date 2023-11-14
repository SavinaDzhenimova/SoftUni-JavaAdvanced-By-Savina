package p09_CatLady;

public class Siamese {
    private String catName;
    private double earSize;

    public Siamese(String catName, double earSize) {
        this.catName = catName;
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %.2f", this.catName, this.earSize);
    }
}