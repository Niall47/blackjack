package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Game Class
 * Controls the deck and tracks player hands and scores
 */
public class Game {
    private List<Player> players;
    private Deck deck;
    private Player dealer;

    public Game(String player1) {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.dealer = new Player("Dealer");
        players.add(new Player(player1));
    }

    public void startGame() {
        System.out.println("Starting Game...");
        deck.shuffle();
        playHand();
        while(!gameOver()){
            if (doesDealerDraw()){
                System.out.println("Dealer takes another card");
                deal(dealer);
            }
            showResults(dealer);
            for (Player player : players){
                while (!gameOver() && !bust(player)){
                    if (anotherCard(player)){
                        deal(player);
                    } else {
                        break;
                    }
                }
                showResults(player);
            }
        }
    }

    private void playHand(){
        deal(dealer);
        deal(dealer);
        showResults(dealer);
        for (Player player : players) {
            deal(player);
            deal(player);
            showResults(player);
        }
    }

    private boolean gameOver() {
        boolean bust = false;
        if (bust(dealer)) bust = true;
//        This wants to be rewritten when we start having more than one player
        for (Player player : players){
            if (bust(player)) bust = true;
        }
        return bust;
    }

    private boolean doesDealerDraw() {
        return (dealer.getHandValue() <= 17);
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
                if (card.getValue() == Values.JACK) jack = true;
                else if (card.getValue() == Values.ACE) ace = true;
            }
        }
        return (ace && jack);
    }

    private void deal(Player player) {
        player.addCard(deck.takeCard());
    }

    private boolean bust(Player player) {
        return (player.getHandValue() > 21);
    }

    private boolean anotherCard(Player player){
        System.out.println(player.getName() + " is at " + player.getHandValue() + " with " + player.getHand().size() + " cards");
        System.out.println("Stick or Twist? (use 's' or 't'");
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
