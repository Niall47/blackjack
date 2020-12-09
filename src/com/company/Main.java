package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("BlackJack");
        System.out.println("How many players");
        ArrayList<String> players = new ArrayList<>();
        Scanner myObj = new Scanner(System.in);
        int numberOfPlayers = myObj.nextInt();

        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Player Name?");
            players.add(myObj.next());
        }
        Game game = new Game(players);
        game.startGame();
    }
}
