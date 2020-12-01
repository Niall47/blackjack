package com.company;

public class Card{
    private final Object faceValue;
    private final Object suit;

    public Card(Values value, Enum<Suits> suit) {
        this.faceValue = value;
        this.suit = suit;
    }

    public String toString() {
        return faceValue + " of " + suit;
    }
}
