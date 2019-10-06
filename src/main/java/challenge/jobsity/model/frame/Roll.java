package challenge.jobsity.model.frame;

public class Roll {
    private int pinFalls;
    private boolean isFoul = false;

    public Roll() { }

    public Roll(int pinFalls, boolean isFoul) {
        this.pinFalls = pinFalls;
        this.isFoul = isFoul;
    }

    public int getPinFalls() {
        return pinFalls;
    }

    public void setPinFalls(int pinFalls) {
        this.pinFalls = pinFalls;
    }

    public boolean isFoul() {
        return isFoul;
    }

    public void setFoul(boolean foul) {
        isFoul = foul;
    }

    @Override
    public String toString() {
        return this.isFoul ? "F" : Integer.toString( this.pinFalls );
    }
}
