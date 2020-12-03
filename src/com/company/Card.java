package com.company;

public class Card{
    private final Values faceValue;
    private final Suits suit;

    public Card(Values value, Suits suit) {
        this.faceValue = value;
        this.suit = suit;
    }

    public Values getFaceValue() {
        return faceValue;
    }

    public String toString(){
        return (faceValue.toString() + " of " + suit.toString());
    }
}
