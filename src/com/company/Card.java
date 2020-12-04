package com.company;

public class Card{
    private final Values value;
    private final Suits suit;

    public Card(Values value, Suits suit) {
        this.value = value;
        this.suit = suit;
    }

    public Values getValue() {
        return value;
    }

    @Override
    public String toString(){
        return (value.toString() + " of " + suit.toString());
    }
}
