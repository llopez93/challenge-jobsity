package challenge.jobsity.game;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.*;
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
        frames.add(new Strike(new Roll(10,false)));
        frames.add(new Strike(new Roll(10,false)));
        frames.add(new Spare(new Roll(5,false), new Roll(5,false)));
        frames.add(new OpenFrame(new Roll(1,false), new Roll(3,false)));
        frames.add(new Spare(new Roll(0,true), new Roll(10,false)));
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
