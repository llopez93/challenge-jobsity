package challenge.jobsity.game;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.OpenFrame;
import challenge.jobsity.model.frame.Spare;
import challenge.jobsity.model.frame.Strike;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for Game class.
 */
public class GameTest {

    private Line buildLine(String playerName) {
        ArrayList<Frame> frames = new ArrayList<>();
        Player p = new Player(playerName);
        frames.add(new Strike(10));
        frames.add(new Strike(10));
        frames.add(new Spare(5, 5));
        frames.add(new OpenFrame(1, 3));
        frames.add(new Spare(0, 10));
        return new Line(frames, p);
    }

    @Test
    public void findExistentLine() {
        Game game = new Game();
        game.getLines().add(this.buildLine("Homero"));
        game.getLines().add(this.buildLine("Lisa"));
        Player p = new Player("Lisa");

        Assert.assertEquals(p, game.findLineByPlayer(p).getPlayer());
    }

    @Test
    public void findNonExistentLine() {
        Game game = new Game();
        game.getLines().add(this.buildLine("Homero"));
        game.getLines().add(this.buildLine("Lisa"));
        Player p = new Player("Marge");

        Assert.assertNull(game.findLineByPlayer(p));
    }

}
