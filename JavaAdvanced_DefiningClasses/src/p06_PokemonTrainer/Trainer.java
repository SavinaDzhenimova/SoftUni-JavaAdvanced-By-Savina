package p06_PokemonTrainer;

import java.util.ArrayList;

public class Trainer {
    private final String name;
    private int badges;
    private final ArrayList<Pokemon> pokemons;

    public Trainer(String name, int badges, ArrayList<Pokemon> pokemons) {
        this.name = name;
        this.badges = badges;
        this.pokemons = pokemons;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badges, this.pokemons.size());
    }
}