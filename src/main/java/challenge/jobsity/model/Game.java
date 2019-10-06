package challenge.jobsity.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Line> lines;

    public Game() {
        lines = new ArrayList<>();
    }

    public Game(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line findLineByPlayer(Player p){
        return lines.stream().filter( l -> l.getPlayer().equals( p ) )
                .findAny().orElse(null);
    }
}
