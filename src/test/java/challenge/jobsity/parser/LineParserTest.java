package challenge.jobsity.parser;

import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.model.parser.GameParser;
import challenge.jobsity.model.parser.LineParser;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for LineParser class.
 */
public class LineParserTest {

    @Test
    public void parseLine() {
        Player player1 = new Player("Jeff");
        Player player2 = new Player("John");
        LineParser parser = new LineParser();
        ArrayList<DataEntry> entries = new ArrayList<>(0);
        entries.add(new DataEntry(player1, 10) );
        entries.add(new DataEntry(player2, 3) );
        entries.add(new DataEntry(player2, 7) );
        entries.add(new DataEntry(player1, 7) );
        entries.add(new DataEntry(player1, 3) );
        entries.add(new DataEntry(player2, 6) );
        entries.add(new DataEntry(player2, 3) );
        entries.add(new DataEntry(player1, 9) );
        entries.add(new DataEntry(player1, 0) );
        entries.add(new DataEntry(player2, 10) );

        Line l = parser.parseLine(entries, player2);
    }
}
