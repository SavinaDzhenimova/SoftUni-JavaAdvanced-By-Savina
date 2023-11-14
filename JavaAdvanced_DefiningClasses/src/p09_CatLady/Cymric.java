package p09_CatLady;

public class Cymric {
    private String catName;
    private double furLength;

    public Cymric(String catName, double furLength) {
        this.catName = catName;
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", this.catName, this.furLength);
    }
}