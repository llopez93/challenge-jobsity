package challenge.jobsity.frames;

import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.OpenFrame;
import challenge.jobsity.model.frame.Strike;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Strike class.
 */
public class StrikeTest {

    @Test
    public void isStrike() {
        Frame s = new Strike(10);
        Assert.assertTrue( s.isStrike() );
    }

    @Test
    public void isNotStrike(){
        Frame s = new OpenFrame(5,3);
        Assert.assertFalse( s.isStrike() );
    }
}
