package com.company;

public class Player{
    private String name;
    private Card[] hand;
    private int handValue;


    public Player(String name) {
        this.name = name;
        this.hand = new Card[6];
        this.handValue = 0;
    }

    public String getName() {
        return name;
    }

    public Card[] getHand() {
        return hand;
    }

    public int getHandValue() {
        handValue = 0;
        boolean ace =  false;
        for (Card card : hand) {
            if (card != null) {
                if (card.getFaceValue() == Values.ACE) {
                    ace = true;
                }
                handValue += card.getFaceValue().getPointValue();
            }
            if (ace && handValue <= 10) {
                handValue += 10;
            }
        }
        return handValue;
    }

    public void addCard(Card card){
        for (int i = 0; i < hand.length; i++){
            if (hand[i] == null) {
                hand[i] = card;
                break;
            }
        }
        System.out.println(name + " got " + card.toString());
    }
}
