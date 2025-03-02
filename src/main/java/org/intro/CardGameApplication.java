package org.intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.intro.model.DeckOfCards;

public class CardGameApplication extends Application {

    private DeckOfCards deckOfCards = new DeckOfCards();
    private StackPane gameFrame = new StackPane();
    private String[] cards;

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

        gameFrame = new StackPane();
        gameFrame.setStyle("-fx-background-color: #858383;");
        gameFrame.setMaxHeight(400);
        gameFrame.setMinHeight(400);
        gameFrame.setMaxWidth(600);
        gameFrame.setMinWidth(600);

        HBox resultBox1 = new HBox(40);

        Label sumOfHandLabel = new Label();
        Label cardsOfHeartsLabe = new Label();
        resultBox1.getChildren().addAll(sumOfHandLabel, cardsOfHeartsLabe);

        HBox resultBox2 = new HBox(40);
        Label isItFlushLabel = new Label();
        Label isThereQueenOfSpadesLabel = new Label();
        resultBox2.getChildren().addAll(isItFlushLabel, isThereQueenOfSpadesLabel);

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
        dealHandButton.setOnAction(e -> {
            System.out.println("Dealing Hand");
            cards = null;
            cards = deckOfCards.getCards(5);

            showHand(cards);
        });

        Button checkHandButton = new Button("Check Hand");
        checkHandButton.setOnAction(e -> {
            System.out.println("Checking Hand");
            checkHand();
        });

        controls.getChildren().addAll(dealHandButton, checkHandButton);

        return controls;
    }

    private void checkHand() {

        int sum = 0;
        int hearts = 0;
        boolean flush = true;
        boolean queenOfSpades = false;

        for (String card : cards) {
            char type = card.charAt(0);
            int cardValue = Integer.parseInt(card.substring(1)) ;

            if (type == 'H') {
                hearts++;
            }

            if (cardValue == 12 && type == 'S') {
                queenOfSpades = true;
            }

            sum += cardValue;
        }

        if (hearts != 5) {
            flush = false;
        }

        updateLabels(sum, hearts, flush, queenOfSpades);

    }

    private void updateLabels(int sum, int hearts, boolean flush, boolean queenOfSpades) {

        Node mainContent = ((BorderPane) gameFrame.getScene().getRoot()).getCenter();
        HBox resultBox1 = (HBox) ((VBox) mainContent).getChildren().get(1);
        HBox resultBox2 = (HBox) ((VBox) mainContent).getChildren().get(2);

        Label sumOfHandLabel = (Label) resultBox1.getChildren().get(0);
        Label cardsOfHeartsLabel = (Label) resultBox1.getChildren().get(1);
        Label isItFlushLabel = (Label) resultBox2.getChildren().get(0);
        Label isThereQueenOfSpadesLabel = (Label) resultBox2.getChildren().get(1);

        // Update the labels with the results
        sumOfHandLabel.setText("Sum of Hand: " + sum);
        cardsOfHeartsLabel.setText("Cards of Hearts: " + hearts);
        isItFlushLabel.setText("Is it a Flush: " + flush);
        isThereQueenOfSpadesLabel.setText("Is there a Queen of Spades: " + queenOfSpades);
    }


    private void showHand(String[] cards) {
        HBox hand = new HBox(20);
        hand.setAlignment(Pos.CENTER);

        for (String card : cards) {
            hand.getChildren().add(getCardImage(card));
        }

        gameFrame.getChildren().clear();
        gameFrame.getChildren().add(hand);

        deckOfCards.returnHandToDeck(cards);
    }

    private ImageView getCardImage(String card) {
        String cardName = card + ".png";
        Image image = new Image(getClass().getResourceAsStream("/cardImages/" + cardName));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(100);
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }


}
