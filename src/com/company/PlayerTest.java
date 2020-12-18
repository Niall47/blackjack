package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player testPlayer;
    List<Card> testHand;
    Card testCard = new Card(Values.FOUR, Suits.DIAMONDS);

    @BeforeEach
    void setUp() {
        testPlayer = new Player("testPlayer");
    }

    @Test
    void getName() {
        assertSame("testPlayer", testPlayer.getName());
    }

    @Test
    void getHand() {
        testHand = new ArrayList<>();
        testHand.add(testCard);
        testPlayer.addCard(testCard);
        assertEquals(testPlayer.getHand(), testHand);
    }

    @Test
    void getHandValue() {
        testPlayer.addCard(testCard);
        assertEquals(testPlayer.getHandValue(), 4);
    }

    @Test
    void addCard() {
        testHand = new ArrayList<>();
        testHand.add(testCard);
        assertNotEquals(testHand, testPlayer.getHand());
        testPlayer.addCard(testCard);
        assertEquals(testHand, testPlayer.getHand());
    }
}