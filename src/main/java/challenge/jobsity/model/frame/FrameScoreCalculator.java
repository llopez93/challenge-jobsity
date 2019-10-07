package challenge.jobsity.model.frame;

import challenge.jobsity.model.Line;

/**
 * A class to decide the score of a Frame contemplating the bonus related with the Frame type,
 */
public class FrameScoreCalculator {

    private Line line;

    public FrameScoreCalculator(Line line) {
        this.line = line;
    }

    /**
     * Gives the Score of the frame. The value can have bonus points depending the Frame type.
     * @param frame Frame to calculate the score.
     * @return The score.
     */
    public int getFrameScore(Frame frame) {
        if (frame.isLastFrame())
            return frame.getPinFalls();
        else
            return frame.isSpare() || frame.isStrike() ? calculateBonus(frame) + frame.getPinFalls() : frame.getPinFalls();
    }

    /**
     * Aply the bonus according to the Frame Type.
     * @param frame Frame to calculate the score.
     * @return Bonus score.
     */
    private int calculateBonus(Frame frame) {
        return frame.isSpare() ? spareBonus(frame) : strikeBonus(frame);
    }

    private int strikeBonus(Frame frame) {
        Frame nextFrame = line.nextFrame(frame);
        if (nextFrame.isStrike())
            return nextFrame.getPinFalls() + line.nextFrame(nextFrame).getFirstRoll().getPinFalls();
        else if (nextFrame.isLastFrame())
            return nextFrame.getFirstRoll().getPinFalls() + nextFrame.getSecondRoll().getPinFalls();
        else
            return nextFrame.getPinFalls();
    }

    private int spareBonus(Frame frame) {
        Frame nextFrame = line.nextFrame(frame);
        return nextFrame.getFirstRoll().getPinFalls();
    }

}
