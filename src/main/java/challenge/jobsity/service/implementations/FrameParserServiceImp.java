package challenge.jobsity.service.implementations;

import challenge.jobsity.model.frame.*;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FrameParserService;

public class FrameParserServiceImp implements FrameParserService {

    private final int MAX_PIN_FALLs = 10;

    @Override
    public Frame parse(DataEntry roll1, DataEntry roll2) {
        if ((roll1.getRoll().getPinFalls() == this.MAX_PIN_FALLs) || !(roll1.getPlayer().equals(roll2.getPlayer())))
            return this.parseStrike(roll1);
        if (roll1.getRoll().getPinFalls() + roll2.getRoll().getPinFalls() == this.MAX_PIN_FALLs) {
            return new Spare(roll1.getRoll(), roll2.getRoll());
        }
        return new OpenFrame(roll1.getRoll(), roll2.getRoll());
    }

    @Override
    public Frame parseLastFrame(DataEntry roll1, DataEntry roll2, DataEntry roll3) {
        return new LastFrame(roll1.getRoll(),roll2.getRoll(),roll3.getRoll());
    }

    @Override
    public Frame parseStrike(DataEntry roll1) {
        return new Strike(roll1.getRoll());
    }
}
