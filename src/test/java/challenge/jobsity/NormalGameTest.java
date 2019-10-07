package challenge.jobsity;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.Game;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FileParserService;
import challenge.jobsity.service.GameParserService;
import challenge.jobsity.service.ScoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class NormalGameTest {

    private GameParserService service;
    private ScoreService scoreService;
    private ArrayList<DataEntry> normalGame;

    @Before
    public void initData() throws Exception {
        this.service = ServiceFactory.getInstance().getGameParserService();
        this.scoreService = ServiceFactory.getInstance().getScoreService();
        FileParserService fileParserService = ServiceFactory.getInstance().getFileParserService();
        this.normalGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("game1.txt").getFile())));
    }

    @Test
    public void showScoreNormalGame() {
        System.out.println("Show score for normal game: \n");
        Game g = service.parseGame(normalGame);
        scoreService.printGameScore(g);


        Assert.assertEquals(2, g.getLines().size());
        Assert.assertEquals(new Player("Jeff"), g.getLines().get(0).getPlayer());
        Assert.assertEquals(new Player("John"), g.getLines().get(1).getPlayer());

        Assert.assertTrue(g.getLines().stream().allMatch(line -> line.getFrames().size() == 10));
    }
}
