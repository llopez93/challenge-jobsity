package challenge.jobsity.services;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.service.FrameService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Strike class.
 */
public class FrameServiceTest {

    private FrameService service;

    public FrameServiceTest() {
        this.service = ServiceFactory.getInstance().getFrameService();
    }

    @Test
    public void parseAnStrike() {
        Frame s = service.createFrame("1","10",null,null);
        Assert.assertTrue( s.isStrike() );
    }

    @Test
    public void parseAnOpenFrame(){
        Frame s = service.createFrame("1","7","1",null);
        Assert.assertTrue( s.isOpenFrame() );
    }

    @Test
    public void parseAnSpare(){
        Frame s = service.createFrame("1","7","3",null);
        Assert.assertTrue( s.isSpare() );
    }
}
