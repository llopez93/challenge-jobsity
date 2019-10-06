package challenge.jobsity.service.implementations;

import challenge.jobsity.factory.ServiceFactory;
import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
import challenge.jobsity.model.Player;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.parser.DataEntry;
import challenge.jobsity.service.FrameParserService;
import challenge.jobsity.service.GameParserService;

import java.util.ArrayList;

public class GameParserServiceImp implements GameParserService {

    private final FrameParserService frameParser;

    public GameParserServiceImp() {
        frameParser = ServiceFactory.getInstance().getFrameParserService();
    }

    @Override
    public Game parseGame(ArrayList<DataEntry> entries) {
        Frame frame = null;
        Game game = new Game();
        int i = 0;
        while (i < entries.size()) {
            DataEntry roll1 = entries.get(i);
            if (!onLastFrame(roll1.getPlayer(), game)) {
                DataEntry roll2 = entries.get(i + 1);
                if (this.areSamePlayer(roll1, roll2)) {
                    frame = frameParser.parse(roll1, roll2);
                    i = i + 2;
                } else {
                    frame = frameParser.parseStrike(roll1);
                    i++;
                }
            } else {
                frame = frameParser.parseLastFrame(roll1, entries.get(i + 1), entries.get(i + 2));
                i = i + 3;
            }
            this.addFrameToLine(game, roll1.getPlayer(), frame);
        }
        return game;
    }

    private boolean onLastFrame(Player p, Game g) {
        Line l = g.findLineByPlayer(p);
        return (l != null) && (l.isOnLastFrame());
    }

    private boolean areSamePlayer(DataEntry entry1, DataEntry entry2) {
        return entry1.getPlayer().equals(entry2.getPlayer());
    }

    private void addFrameToLine(Game g, Player p, Frame f) {
        Line l = g.findLineByPlayer(p);
        if (l == null) {
            l = new Line(p);
            g.getLines().add(l);
        }
        l.addFrame(f);
    }
}
