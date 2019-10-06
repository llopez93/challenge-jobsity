package challenge.jobsity.service;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;

public interface ScoreService {

    void printGameScore(Game g);

    String printLineFramesNumbers(Line line);

    String printLineFrames(Line line);

    String printLineScore(Line line);

}
