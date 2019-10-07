package challenge.jobsity.service;

import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;

public interface FrameParserService {

    /**
     * Convert the DataEntries to the corresponding Frame class.
     * If all the entries belong to the same player can be an Spare if the pinfalls of the two rolls sum 10 pine falls
     * or an OpenFrame if the sum don´t achive the value of 10.
     * If the first roll achieve 10 pins fall or the two entries do not belong to the same player parse an Strike.
     * @param roll1 First roll of the frame.
     * @param roll2 Second roll of the frame.
     * @return OpenFrame or Spare or Strike.
     */
    Frame parse(DataEntry roll1, DataEntry roll2);

    /**
     * Convert a DataEntry in a LastFrame.
     * @param roll1 First roll of the frame.
     * @param roll2 Second roll of the frame.
     * @param roll3 Third roll of the frame.
     * @return LastFrame frame.
     */
    Frame parseLastFrame(DataEntry roll1, DataEntry roll2, DataEntry roll3);

    /**
     * Convert a DataEntry in a Strike. Warning! No validations for the number of pines falls.
     * @param roll1 The DataEntry to convert.
     * @return Strike frame.
     */
    Frame parseStrike(DataEntry roll1);
}
