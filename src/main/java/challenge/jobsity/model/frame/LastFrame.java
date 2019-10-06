package challenge.jobsity.model.frame;

public class LastFrame extends Frame{
    private Roll roll3;

    public LastFrame(Roll roll1, Roll roll2, Roll roll3) {
        super();
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
    }

    @Override
    public Integer getPinFalls() {
        return 0;
    }

    @Override
    public String printScore() {
        // TODO: Ver como se escribe la puntuación
        return "FINAL FRAME";
    }

    @Override
    public boolean isLastFrame() {
        return true;
    }
}
