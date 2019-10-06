package challenge.jobsity.services;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.Game;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FileParserService;
import challenge.jobsity.service.GameParserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * Unit test for GameParserService class.
 */
public class GameParserServiceTest {

    private GameParserService service;
    private ArrayList<DataEntry> normalGame;

    @Before
    public void initData() throws Exception {
        this.service = ServiceFactory.getInstance().getGameParserService();
        FileParserService fileParserService = ServiceFactory.getInstance().getFileParserService();
        this.normalGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("game1.txt").getFile())));
    }

    @Test
    public void parserNormalGame() {
        Game g = service.parseGame(normalGame);
        Assert.assertTrue( (g.getLines().size() == 2) &&
                (g.getLines().stream().allMatch(line -> line.getFrames().size()==10)) );
    }

    //TODO: parsear un juego perfecto y un juego vacio;
}
