package challenge.jobsity.services;

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

/**
 * Unit test for GameParserService class.
 */
public class ScoreServiceTest {

    private GameParserService service;
    private ScoreService scoreService;
    private ArrayList<DataEntry> normalGame;
    private ArrayList<DataEntry> perfectGame;
    private ArrayList<DataEntry> onePlayerFoulGame;
    private ArrayList<DataEntry> twoPlayersFoulGame;
    private ArrayList<DataEntry> emptyGame;

    @Before
    public void initData() throws Exception {
        this.service = ServiceFactory.getInstance().getGameParserService();
        this.scoreService = ServiceFactory.getInstance().getScoreService();
        FileParserService fileParserService = ServiceFactory.getInstance().getFileParserService();
        this.normalGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("game1.txt").getFile())));
        this.perfectGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("perfect-game.txt").getFile())));
        this.onePlayerFoulGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("one-player-foul-game.txt").getFile())));
        this.twoPlayersFoulGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("two-player-foul-game.txt").getFile())));
        this.emptyGame = new ArrayList<>(fileParserService.parseFile(new File(ClassLoader.getSystemResource("empty-game.txt").getFile())));
    }

    @Test
    public void showScoreNormalGame() {
        System.out.println("Show score for normal game: \n");
        Game g = service.parseGame(normalGame);
        scoreService.printGameScore(g);

        Assert.assertTrue( (g.getLines().size() == 2) &&
                (g.getLines().stream().allMatch(line -> line.getFrames().size()==10)) );
    }

    @Test
    public void showScorePerfectGame() {
        System.out.println("Show score for perfect game: \n");
        Game g = service.parseGame(perfectGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertTrue( (g.getLines().size() == 1) &&
                (g.getLines().get(0).getPlayer().equals( new Player("Carl"))) );
    }

    @Test
    public void showScoreOnePlayerFoulGame() {
        System.out.println("Show score for foul game with one player: \n");
        Game g = service.parseGame(onePlayerFoulGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertTrue( (g.getLines().size() == 1) &&
                (g.getLines().get(0).getPlayer().equals( new Player("Carl"))) );
    }

    @Test
    public void showScoreTwoPlayerFoulGame() {
        System.out.println("Show score for foul game with two players: \n");
        Game g = service.parseGame(twoPlayersFoulGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertTrue( (g.getLines().size() == 2) &&
                (g.getLines().get(0).getPlayer().equals( new Player("Marge"))) );
    }

    @Test
    public void showScoreEmptyGame() {
        System.out.println("Show score for empty game: \n");
        Game g = service.parseGame(emptyGame);
        scoreService.printGameScore(g);
        System.out.println(" ");

        Assert.assertEquals( 0, g.getLines().size());
    }
}
