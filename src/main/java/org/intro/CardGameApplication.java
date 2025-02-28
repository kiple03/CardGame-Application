package org.intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.intro.model.DeckOfCards;

public class CardGameApplication extends Application {

    @Override
    public void start(javafx.stage.Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Card Game");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.setTop(displayHeader("Card Game"));
        root.setRight(displayRightSideControls());

    }

    private Node displayHeader(String title) {
        StackPane header = new StackPane();
        header.setStyle("-fx-background-color: #333333;");
        header.setPrefHeight(100);
        header.setMinHeight(100);
        header.setMaxHeight(100);

        Label headerLabel = new Label(title);
        headerLabel.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 24px;");
        header.getChildren().add(headerLabel);
        return header;
    }

    private Node displayRightSideControls() {
        VBox controls = new VBox(20);
        controls.setPrefWidth(200);
        controls.setAlignment(Pos.CENTER);


        Button dealHandButton = new Button("Deal Hand");

        Button checkHandButton = new Button("Check Hand");

        controls.getChildren().addAll(dealHandButton, checkHandButton);

        return controls;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
