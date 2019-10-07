package challenge.jobsity.services;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FrameParserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for FrameParserService class.
 */
public class FrameServiceTest {

    private FrameParserService service;

    public FrameServiceTest() {
        this.service = ServiceFactory.getInstance().getFrameParserService();
    }


    @Test
    public void parseAnStrike() throws InvalidEntryFormatException {
        DataEntry entry = new DataEntry();
        entry.parseValue("Maria 10");
        Frame s = service.parseStrike( entry );

        Assert.assertEquals("X", s.printScore().trim());
        Assert.assertTrue( s.isStrike() );
    }

    @Test
    public void parseAnOpenFrame() throws InvalidEntryFormatException{
        DataEntry entry1 = new DataEntry();
        entry1.parseValue("Marc 5");
        DataEntry entry2 = new DataEntry();
        entry2.parseValue("Marc F");
        Frame s = service.parse(entry1, entry2 );

        Assert.assertEquals("5  F", s.printScore());
        Assert.assertTrue( s.isOpenFrame() );
    }

    @Test
    public void parseAnSpare() throws InvalidEntryFormatException{
        DataEntry entry1 = new DataEntry();
        entry1.parseValue("Marc 2");
        DataEntry entry2 = new DataEntry();
        entry2.parseValue("Marc 8");
        Frame s = service.parse(entry1, entry2 );

        Assert.assertEquals("2  /", s.printScore());
        Assert.assertTrue( s.isSpare() );
    }

    @Test
    public void parseLastFrame() throws InvalidEntryFormatException{
        DataEntry entry1 = new DataEntry();
        entry1.parseValue("Marc 2");
        DataEntry entry2 = new DataEntry();
        entry2.parseValue("Marc 8");
        DataEntry entry3 = new DataEntry();
        entry3.parseValue("Marc 10");
        Frame s = service.parseLastFrame(entry1, entry2, entry3);

        Assert.assertEquals("2 / X", s.printScore());
        Assert.assertTrue( s.isLastFrame() );
    }
}
