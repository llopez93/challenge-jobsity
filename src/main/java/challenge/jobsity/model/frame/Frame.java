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

    public abstract Integer getPinFalls();
    public abstract String printScore();

}
