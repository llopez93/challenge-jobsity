package challenge.jobsity.model.parser;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameParser {

    public Game createGame( ArrayList<DataEntry> entries ){
        List<Player> players = entries.stream().map(DataEntry::getPlayer).distinct().collect(Collectors.toList());
        return new Game( players.stream().map(player -> new Line(player) ).collect(Collectors.toSet()) );
    }

}
