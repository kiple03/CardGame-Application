package org.intro;

import javafx.application.Application;
import org.intro.model.DeckOfCards;

public class CardGameApplication {

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.dealCards(60);
    }


}
