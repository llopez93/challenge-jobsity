package challenge.jobsity.model.frame;

import challenge.jobsity.model.frame.Frame;

public class OpenFrame extends Frame {

    public OpenFrame(Integer roll1, Integer roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    @Override
    public boolean isOpenFrame() {
        return true;
    }

}
