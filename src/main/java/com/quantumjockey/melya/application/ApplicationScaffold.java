package com.quantumjockey.melya.application;

import com.quantumjockey.melya.window.initialization.WindowInitializer;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApplicationScaffold {

    // Public Methods

    public static void create(
            Stage primaryApplicationStage,
            String applicationTitle,
            String appIconFile,
            Object mainWindowControllerInstance,
            Class mainApplicationClass,
            Runnable housekeeping
    ) throws Exception {

        // Use resources root default
        String resourcesRoot = "mainwindow/MainWindow";

        createWithResourcesRoot(
                primaryApplicationStage,
                resourcesRoot,
                applicationTitle,
                appIconFile,
                mainWindowControllerInstance,
                mainApplicationClass,
                housekeeping
        );

    }

    public static void createWithResourcesRoot(
            Stage primaryApplicationStage,
            String resourcesRoot,
            String applicationTitle,
            String appIconFile,
            Object mainWindowControllerInstance,
            Class mainApplicationClass,
            Runnable housekeeping
    ) throws Exception {

        // Initialize application's MainWindow
        WindowInitializer init = new WindowInitializer(resourcesRoot + "View.fxml", mainWindowControllerInstance, mainApplicationClass);
        init.appendCssStyles(resourcesRoot + "Styles.css", mainApplicationClass);

        // Create scene for hosting MainWindow content
        primaryApplicationStage.setTitle(applicationTitle);
        primaryApplicationStage.setScene(init.getScene());

        // Set application icon
        if (appIconFile != null && !appIconFile.equals("")) {
            Image applicationIcon = new Image(mainApplicationClass.getResourceAsStream(appIconFile));
            primaryApplicationStage.getIcons().add(applicationIcon);
        }

        // Execute additional tasks, cleanup, etc
        if (housekeeping != null) {
            housekeeping.run();
        }

    }

}
