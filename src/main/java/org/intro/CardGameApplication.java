package org.intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
        root.setCenter(displayMainContent());

    }

    private Node displayMainContent() {
        VBox mainContent = new VBox();
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setPadding(new javafx.geometry.Insets(50));
        mainContent.setSpacing(20);

        StackPane gameFrame = new StackPane();
        gameFrame.setStyle("-fx-background-color: #858383;");
        gameFrame.setMaxHeight(400);
        gameFrame.setMinHeight(400);
        gameFrame.setMaxWidth(600);
        gameFrame.setMinWidth(600);

        HBox resultBox1 = new HBox(40);

        Label sumOfHand = new Label("Sum of Hand: ");
        Label cardsOfHearts = new Label("Cards of Hearts: ");
        resultBox1.getChildren().addAll(sumOfHand, cardsOfHearts);

        HBox resultBox2 = new HBox(40);
        Label isItFlush = new Label("Is it a Flush: ");
        Label isThereQueenOfSpades = new Label("Is there a Queen of Spades: ");
        resultBox2.getChildren().addAll(isItFlush, isThereQueenOfSpades);

        mainContent.getChildren().addAll(gameFrame, resultBox1, resultBox2);

        return mainContent;
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
