package com.quantumjockey.melya.timer;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

public class TimedTask {

    /////////// Public Methods /////////////////////////////////////////////////////////////

    public static void run(Runnable action, long interval) {
        Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Platform.runLater(action);
            }
        }, 0, interval);
    }

}
