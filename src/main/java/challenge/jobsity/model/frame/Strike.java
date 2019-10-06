package challenge.jobsity.model.frame;

import challenge.jobsity.model.frame.Frame;

public class Strike extends Frame {

    public Strike(Integer roll1) {
        this.roll1 = roll1;
    }

    @Override
    public boolean isStrike() {
        return true;
    }

}
