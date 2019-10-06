package challenge.jobsity.line;

import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for Line class.
 */
public class LineTest {

    private Line buildLine() {
        ArrayList<Frame> frames = new ArrayList<>();
        Player p = new Player("Homero");
        frames.add(new Strike(new Roll(10,false)));
        frames.add(new Strike(new Roll(10,false)));
        frames.add(new Spare(new Roll(5,false), new Roll(5,false)));
        frames.add(new OpenFrame(new Roll(1,false), new Roll(3,false)));
        frames.add(new Spare(new Roll(0,true), new Roll(10,false)));
        return new Line(frames, p);
    }

    @Test
    public void checkPlayer() {
        Player p = new Player("Homero");
        Line line = new Line(p);
        Assert.assertEquals(new Player("Homero"), line.getPlayer());
    }

    @Test
    public void nextFrame() {
        Line line = this.buildLine();
        Frame f = line.getFrames().get(2);
        Assert.assertEquals(line.getFrames().get(3), line.nextFrame(f));
    }

    @Test
    public void lastFrame() {
        Line line = this.buildLine();
        Frame lastFrame = line.getFrames().get(line.getFrames().size() - 1);
        Assert.assertNull(line.nextFrame(lastFrame));
    }


}
