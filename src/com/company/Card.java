package com.company;

public class Card{

    private final char faceValue;
    private final char suit;
    private int pointValue;

    public Card(char value, char suit){
        this.faceValue = value;
        this.suit = suit;
        this.pointValue = calculatePointValue(value);
    }

    private int calculatePointValue(char faceValue){
        switch (faceValue) {
            case 'A': return 1;
            case '2': case '3': case '4': case '5': case '6': case '7' :case '8': case '9':
                return Integer.parseInt(String.valueOf(faceValue));
            case 'T': case 'J': case 'Q': case 'K':
                return 10;
            default:
                throw new IllegalStateException("Unexpected value: " + faceValue);
        }

    }
    public char getValue() {
        return faceValue;
    }

    public char getSuit() {
        return suit;
    }

    public int getPointValue() {
        return pointValue;
    }

    public String toString() {
        String str = String.valueOf(faceValue) + suit;
        return str;
    }
}
