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

    public Game(ArrayList<String> playersToAdd) {
        this.deck = new Deck();
        this.players = new ArrayList<>();
        this.dealer = new Player("Dealer");
        for (String player : playersToAdd){
            players.add(new Player(player));
        }
    }

    public void startGame() {
        System.out.println("Starting Game...");
        deck.shuffle();
        playHand();
        while(!gameOver() && !bust(dealer) && !dealer.out){
            for (Player player : players){
                while (!gameOver() || !bust(player) || !player.out){
                    if (!player.out  && player.getHandValue() < 21 && anotherCard(player)){
                        deal(player);
                    } else {
                        player.out = true;
                        break;
                    }
                    if (gameOver() || bust(player)) {
                        player.out = true;
                        break;
                    }
                }
                showResults(player);
            }
            if (doesDealerDraw()){
                System.out.println("Dealer takes another card");
                deal(dealer);
                if (bust(dealer)) {dealer.out = true;}
            } else {
                dealer.out = true;
            }
            showResults(dealer);
        }
        announceWinner();
    }

    private void announceWinner(){
        for (Player player : players) {
            if (!bust(dealer) && (dealer.getHandValue() > player.getHandValue())) {
                System.out.println(dealer.getName() + " wins with " + dealer.getHandValue());
            } else if (!bust(player) && player.getHandValue() > dealer.getHandValue()) {
                System.out.println(player.getName() + " wins with " + player.getHandValue());
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
        boolean gg = false;
        for (Player player : players){
            if ((bust(player) || player.out) && (bust(dealer)) || dealer.out) {
                gg = true;
            }
        }
        return gg;
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
        boolean answer = false;
        System.out.println(player.getName() + " is at " + player.getHandValue() + " with " + player.getHand().size() + " cards");
        System.out.println("Stick or Twist? (use 's' or 't'");
        Scanner myObj = new Scanner(System.in);
        String response = "";
        while (!validResponse(response)){
            response = myObj.nextLine();
        }
        if (response.toLowerCase().startsWith("t")){
            answer = true;
        } else {
            answer = false;
            player.out = true;
        }
        return answer;
    }

    private boolean validResponse(String input){
        return input.equalsIgnoreCase("s") ||
                input.equalsIgnoreCase("stick") ||
                input.equalsIgnoreCase("t") ||
                input.equalsIgnoreCase("twist");
    }
}
