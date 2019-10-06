package challenge.jobsity.parser;

import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.model.parser.FrameParser;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for FrameParser class.
 */
public class FrameParserTest {

    @Test
    public void parseStrike() {
        FrameParser parser = new FrameParser();
        DataEntry entry1 = new DataEntry(new Player("Juan"), 10);
        DataEntry entry2 = new DataEntry(new Player("Carlos"), 7);

        Assert.assertTrue( parser.parse(entry1,entry2).isStrike() );
    }

    @Test
    public void parseStrikeInPerfectGame() {
        FrameParser parser = new FrameParser();
        DataEntry entry1 = new DataEntry(new Player("Juan"), 10);
        DataEntry entry2 = new DataEntry(new Player("Juan"), 10);

        Assert.assertTrue( parser.parse(entry1,entry2).isStrike() );
    }

    @Test
    public void parseOpenFrame() {
        FrameParser parser = new FrameParser();
        DataEntry entry1 = new DataEntry(new Player("Juan"), 7);
        DataEntry entry2 = new DataEntry(new Player("Juan"), 2);

        Assert.assertTrue( parser.parse(entry1,entry2).isOpenFrame() );
    }

    @Test
    public void parseSpare() {
        FrameParser parser = new FrameParser();
        DataEntry entry1 = new DataEntry(new Player("Juan"), 0);
        DataEntry entry2 = new DataEntry(new Player("Juan"), 10);

        Assert.assertTrue( parser.parse(entry1,entry2).isSpare() );
    }

    @Test
    public void parseLastFrame() {
        FrameParser parser = new FrameParser();
        DataEntry entry1 = new DataEntry(new Player("Juan"), 0);
        DataEntry entry2 = new DataEntry(new Player("Juan"), 10);
        DataEntry entry3 = new DataEntry(new Player("Juan"), 10);

        Assert.assertTrue( parser.parseLastFrame(entry1,entry2,entry3).isLastFrame() );
    }
}
