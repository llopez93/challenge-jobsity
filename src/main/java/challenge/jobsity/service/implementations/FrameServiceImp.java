package challenge.jobsity.service.implementations;

import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.OpenFrame;
import challenge.jobsity.model.frame.Spare;
import challenge.jobsity.model.frame.Strike;
import challenge.jobsity.service.FrameService;

public class FrameServiceImp implements FrameService {

    @Override
    public Frame createFrame(String number,String roll1, String roll2, String roll3) throws NumberFormatException{
        Frame f;
        if ( roll2 == null ) {
            return new Strike(Integer.parseInt(roll1) );
        } else if ( roll3 == null ){
            return Integer.parseInt(roll1)+Integer.parseInt(roll2) == 10 ?
                    new Spare(Integer.parseInt(roll1), Integer.parseInt(roll2)) :
                    new OpenFrame(Integer.parseInt(roll1), Integer.parseInt(roll2));
        } else {
            return null;
        }
    }
}
