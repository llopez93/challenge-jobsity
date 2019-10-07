package challenge.jobsity;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
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


public class FoulGameTest {

    private GameParserService service;
    private ScoreService scoreService;
    private ArrayList<DataEntry> onePlayerFoulGame;
    private ArrayList<DataEntry> twoPlayersFoulGame;

    @Before
    public void initData() throws Exception {
        this.service = ServiceFactory.getInstance().getGameParserService();
        this.scoreService = ServiceFactory.getInstance().getScoreService();
        FileParserService fileParserService = ServiceFactory.getInstance().getFileParserService();
        this.onePlayerFoulGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("one-player-foul-game.txt").getFile())));
        this.twoPlayersFoulGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("two-player-foul-game.txt").getFile())));
    }

    @Test
    public void showScoreOnePlayerFoulGame() {
        System.out.println("Show score for foul game with one player: \n");
        Game g = service.parseGame(onePlayerFoulGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertEquals(1, g.getLines().size());
        Line line = g.getLines().get(0);
        Assert.assertEquals(new Player("Carl"), line.getPlayer());
        Assert.assertTrue(line.getFrames().get(0).getFirstRoll().isFoul());
    }

    @Test
    public void showScoreTwoPlayerFoulGame() {
        System.out.println("Show score for foul game with two players: \n");
        Game g = service.parseGame(twoPlayersFoulGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertEquals(2, g.getLines().size());
        Line line = g.getLines().get(0);
        Assert.assertEquals(new Player("Marge"), line.getPlayer());
        Assert.assertTrue(line.getFrames().get(0).getFirstRoll().isFoul());
    }
}
