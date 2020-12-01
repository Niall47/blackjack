package com.company;

import java.util.Random;
import java.util.Stack;

public class Deck{
    char ace = 'A';
    char two = '2';
    char three = '3';
    char four = '4';
    char five = '5';
    char six = '6';
    char seven = '7';
    char eight = '8';
    char nine = '9';
    char ten = 'T';
    char jack = 'J';
    char queen = 'Q';
    char king = 'K';
    char hearts = 'H';
    char diamonds = 'D';
    char clubs = 'C';
    char spades = 'S';
    public final char[] value = new char[13];
    private char[] suites = new char[4];
    public Stack<Card> deck;

//    enum Card {
//        ACE,
//        TWO,
//
//    }
//    for each Card.values do |sdsaf|

    public Deck(){

        value[0] = ace;
        value[1] = two;
        value[2] = three;
        value[3] = four;
        value[4] = five;
        value[5] = six;
        value[6] = seven;
        value[7] = eight;
        value[8] = nine;
        value[9] = ten;
        value[10] = jack;
        value[11] = queen;
        value[12] = king;
        suites[0] = hearts;
        suites[1] = diamonds;
        suites[2] = clubs;
        suites[3] = spades;

        deck = new Stack<>();

        for (char suite : suites) {
            for (char c : value) {
                deck.add(new Card(c, suite));
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
