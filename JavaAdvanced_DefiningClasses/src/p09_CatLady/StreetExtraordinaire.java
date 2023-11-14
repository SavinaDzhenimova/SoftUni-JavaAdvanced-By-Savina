package p09_CatLady;

public class StreetExtraordinaire {
    private String catName;
    private double decibelsOfMeows;

    public StreetExtraordinaire(String catName, double decibelsOfMeows) {
        this.catName = catName;
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", this.catName, this.decibelsOfMeows);
    }
}