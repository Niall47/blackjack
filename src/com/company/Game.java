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
    }

    public void playHand(){
        for (Player player : players) {
            deal(player);
            deal(player);
            if (bust(player)){
                System.out.println(player.getName() + " bust out with" + player.getHandValue());
                break;
            } else{
                System.out.println(player.getName() + " scored " + player.getHandValue());
            }
        }

    }

    public void deal(Player player) {
        player.addCard(deck.takeCard());
    }

    public void checkScore(){
        for (Player player: players) {
            player.getHandValue();
        }
    }

    public boolean bust(Player player) {
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
