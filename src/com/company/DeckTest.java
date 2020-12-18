package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void shuffle() {
        assertEquals(deck.takeCard().toString(), new Card(Values.KING, Suits.HEARTS).toString());
        deck.shuffle();
        assertNotEquals(deck.takeCard().toString(), new Card(Values.KING, Suits.HEARTS).toString());
    }

    @Test
    void takeCard() {
        deck.shuffle();
        Card card = deck.takeCard();
        assertSame(card.getClass(), Card.class);
        assertNotEquals(deck.deck.size(), 52);
    }
}