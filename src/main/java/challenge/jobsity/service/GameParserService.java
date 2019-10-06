package challenge.jobsity.service;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.parser.DataEntry;

import java.util.ArrayList;

public interface GameParserService {

    public Game parseGame(ArrayList<DataEntry> entries);

}
