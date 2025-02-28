package org.intro;

import javafx.application.Application;

public class CardGameApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        primaryStage.setTitle("Card Game");
        primaryStage.show();
    }

}
