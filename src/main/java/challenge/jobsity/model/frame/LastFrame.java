package challenge.jobsity.model.frame;

import challenge.jobsity.model.TenPinConstants;

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
        return this.roll1.getPinFalls()+this.roll2.getPinFalls()+this.roll3.getPinFalls();
    }

    @Override
    public String printScore() {
        StringBuffer score = new StringBuffer();
        if ( isAnOpenFrame( this.roll1, this.roll2 ))
            return score.append(this.roll1.toString()+" "+this.roll2.toString()+" -").toString();

        if ( isAnSpare( this.roll1, this.roll2 ) )
            return score.append(this.roll1.toString()+" / "+this.printRoll(this.roll3, null)).toString();

        score.append( printRoll(this.roll1, null)+" " );
        score.append( printRoll(this.roll2, this.roll1)+" " );
        score.append( printRoll(this.roll3, this.roll2) );
        return score.toString();
    }

    @Override
    public boolean isLastFrame() {
        return true;
    }

    private boolean isAnSpare( Roll roll1, Roll roll2 ){
        return roll1.getPinFalls()+roll2.getPinFalls() == TenPinConstants.MAX_PINES;
    }

    private boolean isAnStrike( Roll roll ){
        return roll.getPinFalls() == TenPinConstants.MAX_PINES;
    }

    private boolean isAnOpenFrame( Roll roll1, Roll roll2 ){
        return roll1.getPinFalls()+roll2.getPinFalls() < TenPinConstants.MAX_PINES;
    }

    private String printRoll(Roll actual, Roll previous){
        if ( previous == null )
            return actual.getPinFalls()==TenPinConstants.MAX_PINES?"X":actual.toString();
        if ( isAnStrike( previous ) && isAnStrike( actual ))
            return "X";
        if ( isAnSpare( actual , previous ) ){
            return "/";
        }
        return actual.toString();
    }

}
