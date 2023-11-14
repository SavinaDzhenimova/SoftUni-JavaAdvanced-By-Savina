package p06_PokemonTrainer;

public class Pokemon {
    private final String name;
    private final String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public String getElement() {
        return element;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}