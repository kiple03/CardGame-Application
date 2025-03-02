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

  public String getRandomCard() {
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

  public void returnHandToDeck(String[] hand) {
    for (String card : hand) {
      deckOfCards.put(card, deckOfCards.get(card));
    }
  }

  public String[] getCards(int n) {
    String[] hand = new String[n];
    for (int i = 0; i < n; i++) {
      hand[i] = getRandomCard();
    }
    return hand;
  }

  public HashMap<String, Integer> getDeckOfCards() {
    return deckOfCards;
  }


}
