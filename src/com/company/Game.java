package com.company;

public class Game {
    private int playerScore;
    private int dealerScore;

    public Game() {
        this.playerScore = 0;
        this.dealerScore = 0;
    }

    public void deal() {
        Deck deck = new Deck();
        deck.shuffle();
    }

}
