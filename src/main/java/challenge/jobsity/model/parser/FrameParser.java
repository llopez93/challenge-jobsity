package challenge.jobsity.model.parser;

import challenge.jobsity.model.frame.*;

public class FrameParser {
    private final int STRIKE = 10;

    public Frame parse(DataEntry roll1, DataEntry roll2) {
        /**
        if ((roll1.getPinFalls() == this.STRIKE && roll2.getPinFalls() == this.STRIKE)
                || !(roll1.getPlayer().equals(roll2.getPlayer())))
            return new Strike(roll1.getPinFalls());
        */
        if ((roll1.getPinFalls() == this.STRIKE ) || !(roll1.getPlayer().equals(roll2.getPlayer())))
            return new Strike(roll1.getPinFalls());
        if (roll1.getPinFalls() + roll2.getPinFalls() == this.STRIKE) {
            return new Spare(roll1.getPinFalls(), roll2.getPinFalls());
        }
        return new OpenFrame(roll1.getPinFalls(), roll2.getPinFalls());
    }

    public Frame parseLastFrame(DataEntry roll1, DataEntry roll2, DataEntry roll3) {
        return new LastFrame(roll1.getPinFalls(),roll2.getPinFalls(),roll3.getPinFalls());
    }
}
