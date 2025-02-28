package org.intro.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

  private final char[] types = {'S', 'H', 'D', 'C'};
  private HashMap<String, Integer> deckOfCards = new HashMap<>();

  public DeckOfCards() {
    for (char type : types) {
      for (int i = 1; i < 14; i++) {
        String card = type + Integer.toString(i);
        deckOfCards.put(card, i); ;
      }
    }
  }

  public void displayDeck() {
    for (char type : types) {
      for (int i = 1; i < 14; i++) {
        System.out.println(type + Integer.toString(i));
      }
    }
  }

}
