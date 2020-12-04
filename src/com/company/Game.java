package com.company;

import java.util.Scanner;

/**
 * Game Class
 * Controls the deck and tracks player hands and scores
 */
public class Game {
    private Player[] players;
    private Deck deck;

    public Game(String player1) {
        this.deck = new Deck();
        this.players = new Player[2];
        players[0] = new Player("Dealer");
        players[1] = new Player(player1);
    }

    public void startGame() {
        System.out.println("Starting Game...");
        deck.shuffle();
        playHand();
        checkScore();
        while (doesDealerDraw()){
            System.out.println("Dealer takes another card");
            deal(players[0]);
        }
        checkScore();
        showResults(players[0]);
        for (Player player : players){
            if (!(player.getName().startsWith("Dealer"))){
                System.out.println("Offering " + player.getName() + " a choice (currently at: " + player.getHandValue() + ")");
                while (anotherCard()){
                    deal(player);
                }
                showResults(player);
            }
        }
    }

    private void playHand(){
        for (Player player : players) {
            deal(player);
            deal(player);
            showResults(player);
        }
    }

    private boolean doesDealerDraw() {
        return (players[0].getHandValue() <= 17);
    }
    private void showResults(Player player) {
        if (bust(player)){
            System.out.println(player.getName() + " bust out with " + player.getHandValue());
        }else if (blackJack(player)) {
            System.out.println(player.getName() + " got a BlackJack");
        } else {
            System.out.println(player.getName() + " scored " + player.getHandValue());
        }
    }

    private boolean blackJack(Player player){
        boolean jack = false;
        boolean ace = false;
        if (player.getHandValue() == 21){
            for (Card card : player.getHand()) {
                if (card.getValue() == Values.JACK) {
                    jack = true;
                } else if (card.getValue() == Values.ACE){
                    ace = true;
                }
            }
        }
        return (ace && jack);
    }

    private void deal(Player player) {
        player.addCard(deck.takeCard());
    }

    private void checkScore(){
        for (Player player: players) {
            player.getHandValue();
        }
    }

    private boolean bust(Player player) {
        return (player.getHandValue() > 21);
    }

    private boolean anotherCard(){
        System.out.println("Stick or Twist?");
        System.out.println("'S' or 'T");
        String response = "";
        Scanner myObj = new Scanner(System.in);
        while (!validResponse(response)){
            response = myObj.nextLine();
        }
        return response.toLowerCase().startsWith("t");

    }

    private boolean validResponse(String input){
        return input.equalsIgnoreCase("s") ||
                input.equalsIgnoreCase("stick") ||
                input.equalsIgnoreCase("t") ||
                input.equalsIgnoreCase("twist");
    }
}
