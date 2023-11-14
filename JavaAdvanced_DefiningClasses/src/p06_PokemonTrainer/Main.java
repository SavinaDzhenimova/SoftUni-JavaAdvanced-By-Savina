package p06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer = new Trainer(trainerName, 0, new ArrayList<>());
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).getPokemons().add(pokemon);

            input = scanner.nextLine();
        }

        String element = scanner.nextLine();

        while (!element.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                boolean haveSuchPokemon = false;

                if (entry.getValue().getPokemons().size() > 0) {
                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(element)) {
                            entry.getValue().setBadges(entry.getValue().getBadges() + 1);
                            haveSuchPokemon = true;
                            break;
                        }
                    }

                    if (!haveSuchPokemon) {
                        entry.getValue().getPokemons().forEach(p -> p.setHealth(p.getHealth() - 10));
                        entry.getValue().getPokemons().removeIf(p -> p.getHealth() <= 0);
                    }
                }
            }

            element = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getBadges(), b1.getValue().getBadges()))
                .forEach(t -> System.out.printf("%s %d %d%n", t.getKey(),
                        t.getValue().getBadges(),
                        t.getValue().getPokemons().size()));
    }
}