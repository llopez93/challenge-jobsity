package challenge.jobsity.model;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private Set<Line> lines;

    public Game() {
        lines = new HashSet<>();
    }

    public Game(Set<Line> lines) {
        this.lines = lines;
    }

    public Set<Line> getLines() {
        return lines;
    }

    public Line findLineByPlayer(Player p){
        return lines.stream().filter( l -> l.getPlayer().equals( p ) )
                .findAny().orElse(null);
    }
}
