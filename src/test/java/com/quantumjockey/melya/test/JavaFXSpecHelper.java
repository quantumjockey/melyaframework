package com.quantumjockey.melya.test;

import javafx.embed.swing.JFXPanel;
import javax.swing.*;

public class JavaFXSpecHelper {

    public static void initToolkit() {
        SwingUtilities.invokeLater(() -> new JFXPanel());
    }

}
