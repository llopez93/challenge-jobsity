package challenge.jobsity.parser;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.model.parser.GameParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for GameParser class.
 */
public class GameParserTest {

    @Test
    public void createTwoPlayersGame() {
        Player player1 = new Player("Juan");
        Player player2 = new Player("Bart");
        GameParser gameParser = new GameParser();
        ArrayList<DataEntry> entries = new ArrayList<>(0);
        entries.add(new DataEntry(player1, 1) );
        entries.add(new DataEntry(player1, 9) );
        entries.add(new DataEntry(player2, 10) );
        entries.add(new DataEntry(player1, 0) );
        entries.add(new DataEntry(player1, 9) );
        entries.add(new DataEntry(player2, 7) );
        entries.add(new DataEntry(player2, 3) );

        Game g = gameParser.createGame(entries);

        Assert.assertTrue( g.getLines().size() == 2 );
    }

    @Test
    public void createPerfectGame() {
        Player player1 = new Player("Juan");
        GameParser gameParser = new GameParser();
        ArrayList<DataEntry> entries = new ArrayList<>(0);
        entries.add(new DataEntry(player1, 10) );
        entries.add(new DataEntry(player1, 10) );
        entries.add(new DataEntry(player1, 10) );
        entries.add(new DataEntry(player1, 10) );
        entries.add(new DataEntry(player1, 10) );


        Game g = gameParser.createGame(entries);

        Assert.assertEquals( player1, g.findLineByPlayer(player1).getPlayer() );
    }

    @Test
    public void createEmptyGame() {
        GameParser gameParser = new GameParser();
        ArrayList<DataEntry> entries = new ArrayList<>(0);
        Game g = gameParser.createGame(entries);

        Assert.assertEquals( 0, g.getLines().size() );
    }
}
