package challenge.jobsity.model.frame;

public class Strike extends Frame {

    public Strike(Roll roll1) {
        this.roll1 = roll1;
    }

    @Override
    public Integer getPinFalls() {
        return this.roll1.getPinFalls() ;
    }

    @Override
    public String printScore() {
        return "   X";
    }

    @Override
    public boolean isStrike() {
        return true;
    }

}
