package challenge.jobsity.model.frame;

public abstract class Frame {

    protected Integer roll1 = null;
    protected Integer roll2 = null;

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

    // abstract getPoints();

}
