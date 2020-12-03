package com.company;

import java.util.Random;
import java.util.Stack;

/**
 * Deck Class
 */
public class Deck {

    public Stack<Card> deck;

    /**
     * Iterates through the values for each suit and adds the cards to the deck
     */
    public Deck(){
        deck = new Stack<>();
        for (Suits suit : Suits.values()) {
            for (Values value : Values.values()){
                deck.add(new Card(value, suit));
            }
        }
    }


    /**
     * Shuffles the Deck
    */
    public void shuffle(){
        Random random = new Random();
        for (int i=0; i<999; i++){
            int x = random.nextInt(deck.size());
            int y = random.nextInt(deck.size());
            Card card = deck.get(x);
            deck.removeElementAt(x);
            deck.insertElementAt(card, y);
        }
    }

    /**
     * Removes the top-most card from the deck and returns it
     */
    public Card takeCard(){
        Card card = deck.get(0);
        deck.removeElementAt(0);
        return card;
    }
}
