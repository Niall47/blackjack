package com.company;

import java.util.Random;
import java.util.Stack;

public class Deck{

    public Stack<Card> deck;

    public Deck(){
        deck = new Stack<>();
        for (Suits suit : Suits.values()) {
            for (Values value : Values.values()){
                deck.add(new Card(value, suit));
            }
        }
    }

    public void shuffle(){
        Random random = new Random();
        for (int i=0; i<999; i++){
            int x = random.nextInt(51);
            int y = random.nextInt(51);
            Card card = deck.get(x);
            deck.removeElementAt(x);
            deck.insertElementAt(card, y);
        }
    }

    public Card top(){
        return deck.pop();
    }
}
