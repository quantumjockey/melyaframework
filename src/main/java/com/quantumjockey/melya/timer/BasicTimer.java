package com.quantumjockey.melya.timer;

import java.util.Timer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BasicTimer {

    /////////// Fields (Controller) /////////////////////////////////////////////////////////

    private int timerSeconds;
    private Timer timer;

    /////////// Properties //////////////////////////////////////////////////////////////////

    private IntegerProperty secondsElapsedFromConnectionStart = new SimpleIntegerProperty();

    public final int getSecondsElapsedFromConnectionStart() {
        return this.secondsElapsedFromConnectionStart.get();
    }

    public final void setSecondsElapsedFromConnectionStart(int secondsElapsedFromConnectionStart) {
        this.secondsElapsedFromConnectionStart.set(secondsElapsedFromConnectionStart);
    }

    public IntegerProperty secondsElapsedFromConnectionStartProperty() {
        return this.secondsElapsedFromConnectionStart;
    }

    /////////// Constructor /////////////////////////////////////////////////////////////////

    public BasicTimer() {
        this.timer = new java.util.Timer();
    }

    /////////// Public Methods //////////////////////////////////////////////////////////////

    public void start() {
        this.timerSeconds = 0;
        TimedTask.runWithTimer(this.timer, () -> {
            this.setSecondsElapsedFromConnectionStart(timerSeconds);
            timerSeconds++;
        }, 1000);
    }

    public void end() {
        this.timer.cancel();
        this.timer.purge();
        this.timer = new Timer();
    }

}
