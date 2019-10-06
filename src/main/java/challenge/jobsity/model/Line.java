package challenge.jobsity.model;

import challenge.jobsity.model.frame.Frame;

import java.util.ArrayList;

public class Line {

    private ArrayList<Frame> frames;
    private Player player;

    public Line() {
        this.frames = new ArrayList<>();
    }

    public Line(Player player) {
        this.player = player;
        this.frames = new ArrayList<>();
    }

    public Line(ArrayList<Frame> frames, Player player) {
        this.frames = frames;

        this.player = player;
    }

    public void addFrame( Frame f ){
        this.frames.add(f);
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Find next frame in the line and return it. If the function its call with the last frame return null.
     * @param f Actual frame
     * @return The next frame in line or null.
     */
    public Frame nextFrame(Frame f) {
        int i = this.frames.indexOf(f);
        return i != this.frames.size() - 1 ? this.frames.get(i+1) : null;
    }

    public boolean isOnLastFrame(){
        return this.frames.size() == 9;
    }

}
