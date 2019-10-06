package challenge.jobsity.service;

import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;

public interface FrameParserService {

    Frame parse(DataEntry roll1, DataEntry roll2);

    Frame parseLastFrame(DataEntry roll1, DataEntry roll2, DataEntry roll3);

    Frame parseStrike(DataEntry roll1);
}
