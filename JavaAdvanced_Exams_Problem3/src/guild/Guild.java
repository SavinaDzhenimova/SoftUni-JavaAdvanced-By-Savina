package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private  int capacity;
    List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (count() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        this.roster.stream()
                .filter(p -> p.getName().equals(name)).findFirst()
                .ifPresent(playerToPromote -> playerToPromote.setRank("Member"));
    }

    public void demotePlayer(String name) {
        this.roster.stream()
                .filter(p -> p.getName().equals(name)).findFirst()
                .ifPresent(playerToPromote -> playerToPromote.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removedPlayers = this.roster.stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(Player[]::new);
        this.roster.removeIf(p -> p.getClazz().equals(clazz));

        return removedPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:%n", this.name));
        if (count() > 0) {
            this.roster.forEach(p -> sb.append(p.toString()).append(System.lineSeparator()));
        }
        return sb.toString().trim();
    }
}