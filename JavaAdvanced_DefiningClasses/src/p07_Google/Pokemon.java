package p07_Google;

public class Pokemon {
    String pokemonName;
    String pokemonType;

    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public String format(){
        return String.format("%s %s", pokemonName, pokemonType);
    }
}