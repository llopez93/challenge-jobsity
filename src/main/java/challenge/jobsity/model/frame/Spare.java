package challenge.jobsity.model.frame;

public class Spare extends Frame {

    public Spare(Roll roll1, Roll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    @Override
    public Integer getPinFalls() {
        return roll1.getPinFalls() + roll2.getPinFalls();
    }

    @Override
    public String printScore() {
        return roll1.toString()+"  /";
    }

    @Override
    public boolean isSpare() {
        return true;
    }
}
