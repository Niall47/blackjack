package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player{
    private String name;
    private List<Card> hand;
    private int handValue;
    public boolean out;


    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.handValue = 0;
        this.out = false;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        handValue = 0;
        boolean ace =  false;
        boolean ten = false;
        for (Card card : hand) {
            if (card != null) {
                if (card.getValue() == Values.ACE) {
                    ace = true;
                } else if (card.getValue().getPointValue() == 10 ) {
                    ten = true;
                }
                handValue += card.getValue().getPointValue();
            }
        }
        if (ace && ten){
            handValue = 21;
        }else if (ace && handValue < 10) {
            handValue += 10;
        }
        return handValue;
    }

    public void addCard(Card card){
        hand.add(card);
        System.out.println(name + " got " + card.toString());
    }
}
