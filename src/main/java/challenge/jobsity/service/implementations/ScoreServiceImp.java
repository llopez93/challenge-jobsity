package challenge.jobsity.service.implementations;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;
import challenge.jobsity.model.frame.Frame;
import challenge.jobsity.model.frame.FrameScoreCalculator;
import challenge.jobsity.service.ScoreService;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreServiceImp implements ScoreService {

    @Override
    public void printGameScore(Game g) {
        if (g.getLines().size() > 0) {
            System.out.println("Game score:\n");
            System.out.println(printLineFramesNumbers(g.getLines().get(0)));
            g.getLines().forEach(line -> {
                System.out.println(line.getPlayer().toString());
                System.out.println(printLineFrames(line));
                System.out.println(printLineScore(line));
            });
        } else {
            System.out.println("The game loaded is empty.");
        }
    }

    @Override
    public String printLineFramesNumbers(Line line) {
        return "Frame    ".concat(IntStream.range(1, line.getFrames().size() + 1)
                .mapToObj(value -> String.valueOf(value))
                .collect(Collectors.joining("    ")));
    }

    @Override
    public String printLineFrames(Line line) {
        return "Pinfalls ".concat(line.getFrames().stream().map(frame -> frame.printScore()).collect(Collectors.joining(" ")));
    }

    @Override
    public String printLineScore(Line line) {
        FrameScoreCalculator calculator = new FrameScoreCalculator(line);
        StringBuffer buffer = new StringBuffer().append("Score    ");
        int lineScore = 0;
        for (Frame f : line.getFrames()) {
            lineScore = lineScore + calculator.getFrameScore(f);
            if (lineScore < 10)
                buffer.append(String.valueOf(lineScore).concat("    "));
            else if ( lineScore < 100 )
                buffer.append(String.valueOf(lineScore).concat("   "));
            else
                buffer.append(String.valueOf(lineScore).concat("  "));
        }
        return buffer.toString();
    }
}
