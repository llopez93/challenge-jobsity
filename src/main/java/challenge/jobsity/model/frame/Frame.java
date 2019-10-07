package challenge.jobsity.model.frame;

public abstract class Frame {

    protected Roll roll1 = null;
    protected Roll roll2 = null;

    public Frame() {}

    public boolean isStrike() {
        return false;
    }
    public boolean isSpare(){
        return false;
    }
    public boolean isOpenFrame(){
        return false;
    }
    public boolean isLastFrame(){
        return false;
    }

    /**
     * Gives the score achieved in the frame.
     * @return The score of the frame.
     */
    public abstract Integer getPinFalls();

    /**
     * Gives a String with the score of the frame. The score have variations depending on the type of Frame.
     * @return The score
     */
    public abstract String printScore();

    public Roll getFirstRoll() {
        return roll1;
    }
    public Roll getSecondRoll() {
        return roll2;
    }

}
