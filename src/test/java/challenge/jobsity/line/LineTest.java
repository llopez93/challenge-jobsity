package challenge.jobsity.line;

import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.OpenFrame;
import challenge.jobsity.model.frame.Spare;
import challenge.jobsity.model.frame.Strike;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for Line class.
 */
public class LineTest {

    private Line buildLine() {
        ArrayList<Frame> frames = new ArrayList<>();
        Player p = new Player("Homero");
        frames.add(new Strike(10));
        frames.add(new Strike(10));
        frames.add(new Spare(5, 5));
        frames.add(new OpenFrame(1, 3));
        frames.add(new Spare(0, 10));
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
