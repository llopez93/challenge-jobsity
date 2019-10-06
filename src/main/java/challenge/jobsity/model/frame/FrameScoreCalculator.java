package challenge.jobsity.model.frame;

import challenge.jobsity.model.Line;

public class FrameScoreCalculator {

    private Line line;

    public FrameScoreCalculator(Line line) {
        this.line = line;
    }

    public int getFrameScore(Frame frame) {
        if (frame.isLastFrame())
            return frame.getPinFalls();
        else
            return frame.isSpare() || frame.isStrike() ? calculateBonus(frame) + frame.getPinFalls() : frame.getPinFalls();
    }

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

    private int lastFrameBonus(Frame frame) {
        return 0;
    }


}
