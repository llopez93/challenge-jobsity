package challenge.jobsity.service;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.parser.DataEntry;

import java.util.ArrayList;

public interface GameParserService {

    /**
     * Parse a list of DataEntry to Frame and add it to the corresponding line.
     * @param entries A list of DataEntry
     * @return A Ten Pins game.
     */
    Game parseGame(ArrayList<DataEntry> entries);

}
