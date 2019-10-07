package challenge.jobsity;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FileParserService;
import challenge.jobsity.service.GameParserService;
import challenge.jobsity.service.ScoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class PerfectGameTest {

    private GameParserService service;
    private ScoreService scoreService;
    private ArrayList<DataEntry> perfectGame;
    private ArrayList<DataEntry> twoPlayersPerfectGame;

    @Before
    public void initData() throws Exception {
        this.service = ServiceFactory.getInstance().getGameParserService();
        this.scoreService = ServiceFactory.getInstance().getScoreService();
        FileParserService fileParserService = ServiceFactory.getInstance().getFileParserService();
        this.perfectGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("perfect-game.txt").getFile())));
        this.twoPlayersPerfectGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("two-players-perfect-game.txt").getFile())));
    }

    @Test
    public void showScorePerfectGame() {
        System.out.println("Show score for perfect game: \n");
        Game g = service.parseGame(perfectGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertEquals(1, g.getLines().size());
        Line line = g.getLines().get(0);
        Assert.assertEquals(new Player("Carl"), line.getPlayer());
        Assert.assertTrue(line.getFrames().stream().allMatch(frame -> frame.isLastFrame() || frame.isStrike()));
    }

    @Test
    public void showScoreTwoPlayersPerfectGame() {
        System.out.println("Show score for perfect game of two players: \n");
        Game g = service.parseGame(twoPlayersPerfectGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertEquals(2, g.getLines().size());
        Line line = g.getLines().get(0);
        Assert.assertEquals(new Player("Carl"), line.getPlayer());
        Assert.assertTrue(line.getFrames().stream().allMatch(frame -> frame.isLastFrame() || frame.isStrike()));

        Line line2 = g.getLines().get(1);
        Assert.assertEquals(new Player("Robert"), line2.getPlayer());
        Assert.assertTrue(line2.getFrames().stream().allMatch(frame -> frame.isLastFrame() || frame.isStrike()));

    }
}
