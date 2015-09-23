package com.quantumjockey.melya.timer;

import java.util.Timer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BasicTimer {

    /////////// Fields (Controller) /////////////////////////////////////////////////////////

    private int timerSeconds;
    private Timer timer;

    /////////// Properties //////////////////////////////////////////////////////////////////

    private IntegerProperty secondsElapsedFromStart = new SimpleIntegerProperty();

    public final int getSecondsElapsedFromStart() {
        return this.secondsElapsedFromStart.get();
    }

    public final void setSecondsElapsedFromStart(int secondsElapsedFromStart) {
        this.secondsElapsedFromStart.set(secondsElapsedFromStart);
    }

    public IntegerProperty secondsElapsedFromStartProperty() {
        return this.secondsElapsedFromStart;
    }

    /////////// Constructor /////////////////////////////////////////////////////////////////

    public BasicTimer() {
        this.timer = new java.util.Timer();
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void start() {
        this.timerSeconds = 0;
        TimedTask.runWithTimer(this.timer, () -> {
            this.setSecondsElapsedFromStart(timerSeconds);
            timerSeconds++;
        }, 1000);
    }

    public void end() {
        this.timer.cancel();
        this.timer.purge();
        this.timer = new Timer();
    }

}
