package challenge.jobsity.model.parser;

import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;

import java.util.ArrayList;

public class LineParser {
    private final Integer STRIKE = 10;

    public Line parseLine(ArrayList<DataEntry> entries, Player p) {
        FrameParser frameParser = new FrameParser();
        Line l = new Line(p);
        for (int i = 0; i < entries.size(); i++) {
            DataEntry roll1 = entries.get(i);
            if ( roll1.getPlayer().equals(p) ){
                if (i < entries.size()-2) {
                    DataEntry roll2 = entries.get(i + 1);
                    // TODO: parsear el last frame
                    Frame frame = frameParser.parse(roll1, roll2);
                    l.addFrame(frame);
                    i = frame.isOpenFrame() || frame.isSpare() ? i + 2 : i;
                }
            }
        }
        return l;
    }

}
