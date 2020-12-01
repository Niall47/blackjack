package com.company;

public class Game {
    private int playerScore;
    private int dealerScore;
    private Deck deck;

    public Game() {
        this.playerScore = 0;
        this.dealerScore = 0;
        this.deck = new Deck();
    }

    public void deal() {
        Deck deck = new Deck();
        System.out.println(deck.deck.firstElement().toString());
        deck.shuffle();
        System.out.println(deck.deck.firstElement().toString());
    }
}
