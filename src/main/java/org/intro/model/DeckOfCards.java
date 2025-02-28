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

  private String getRandomCard() {
    if (deckOfCards.isEmpty()) {
      return "No more cards in the deck";
    }

    Random random = new Random();

    List<String> availableCards = new ArrayList<>(deckOfCards.keySet());

    int randomIndex = random.nextInt(availableCards.size());
    String randomCard = availableCards.get(randomIndex);

    deckOfCards.remove(randomCard);

    return randomCard;
  }

  public void dealCards(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(getRandomCard());
    }
  }

}
