package challenge.jobsity.services;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.service.FrameParserService;

/**
 * Unit test for FrameParserService class.
 */
public class FrameServiceTest {

    private FrameParserService service;

    public FrameServiceTest() {
        this.service = ServiceFactory.getInstance().getFrameParserService();
    }
    /**

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
    */

    // TODO: Implementar estos test.
}
