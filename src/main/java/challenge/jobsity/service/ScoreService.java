package challenge.jobsity.service;

import challenge.jobsity.model.Game;
import challenge.jobsity.model.Line;

public interface ScoreService {

    void printGameScore(Game g);

    /**
     * Generate a string with the numbers of all frames of the line.
     * @param line Object to generate frame numbers.
     * @return A string with the format: Frame   1    2   3...N
     */
    String printLineFramesNumbers(Line line);

    /**
     * Generate a string with the pine falls of each frame, can be an open frame (4  5), an spare(4  /), strike (X) or the last frame (X  4  /).
     * @param line Object to retrieve all frames.
     * @return A string with the format: Pinfalls   X    2  4...N
     */
    String printLineFrames(Line line);

    /**
     * Generate a string with the score of each frame. the value is added for each turn.
     * @param line Object to retrieve the score.
     * @return A string with the format: Score   20    25...N
     */
    String printLineScore(Line line);

}
