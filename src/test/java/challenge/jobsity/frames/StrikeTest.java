package challenge.jobsity.frames;

import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.OpenFrame;
import challenge.jobsity.model.frame.Roll;
import challenge.jobsity.model.frame.Strike;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Strike class.
 */
public class StrikeTest {

    @Test
    public void isStrike() {
        Frame s = new Strike(new Roll(10,false));
        Assert.assertTrue( s.isStrike() );
    }

    @Test
    public void isNotStrike(){
        Frame s = new OpenFrame(new Roll(5,false), new Roll(3,false));
        Assert.assertFalse( s.isStrike() );
    }
}
