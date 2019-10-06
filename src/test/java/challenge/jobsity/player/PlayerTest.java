package challenge.jobsity.player;

import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.OpenFrame;
import challenge.jobsity.model.frame.Strike;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Player class.
 */
public class PlayerTest {

    @Test
    public void checkName() {
        Player p = new Player("Foo");
        Assert.assertEquals( "Foo", p.getName() );
    }

    @Test
    public void getName(){
        Player p = new Player("Homero");
        p.setName("Marge");
        Assert.assertEquals( "Marge", p.getName() );
    }
}
