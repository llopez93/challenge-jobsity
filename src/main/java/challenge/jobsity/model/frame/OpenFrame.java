package challenge.jobsity.model.frame;

public class OpenFrame extends Frame {

    public OpenFrame(Roll roll1, Roll roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    @Override
    public Integer getPinFalls() {
        return roll1.getPinFalls() + roll2.getPinFalls();
    }

    @Override
    public String printScore() {
        return roll1.toString().concat("  ").concat(roll2.toString());
    }

    @Override
    public boolean isOpenFrame() {
        return true;
    }

}
