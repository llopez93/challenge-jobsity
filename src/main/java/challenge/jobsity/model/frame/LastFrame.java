package challenge.jobsity.model.frame;

public class LastFrame extends Frame{
    private Integer roll3;

    public LastFrame(Integer roll1, Integer roll2, Integer roll3) {
        super();
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
    }

    @Override
    public boolean isLastFrame() {
        return true;
    }
}
