package challenge.jobsity.services;

import challenge.jobsity.exception.InvalidEntryFormatException;
import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FileParserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Unit test for FileService class.
 */
public class FileServiceTest {

    private FileParserService service;
    private File normalGame;
    private File invalidGame;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void initData() {
        this.service = ServiceFactory.getInstance().getFileParserService();
        this.normalGame = new File(ClassLoader.getSystemResource("game1.txt").getFile());
        this.invalidGame = new File(ClassLoader.getSystemResource("invalid-game.txt").getFile());
    }

    @Test
    public void parserNormalGameFile() throws InvalidEntryFormatException, IOException {
        List<DataEntry> entries = this.service.parseFile( this.normalGame );
    }

    @Test(expected = InvalidEntryFormatException.class)
    public void parserInvalidFile() throws InvalidEntryFormatException, IOException {
        List<DataEntry> entries = this.service.parseFile( this.invalidGame );
    }
}
