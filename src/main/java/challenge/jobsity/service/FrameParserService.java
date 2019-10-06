package challenge.jobsity.service;

import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;

public interface FrameParserService {

    public Frame parse(DataEntry roll1, DataEntry roll2);

    public Frame parseLastFrame(DataEntry roll1, DataEntry roll2, DataEntry roll3);

    public Frame parseStrike(DataEntry roll1);
}
