package app;

import java.util.Random;

/**
 * Deck
 */
class Deck {
    static int TOTAL_NUM = 52;
    Card[] cardDeck = new Card[52];

    Deck() {
        for (int i = 0; i < Card.MAX_KIND; ++i) {
            for (int j = 0; j < Card.MAX_NUM; ++j) {
                cardDeck[(i * Card.MAX_NUM) + j] = new Card(i + 1, j + 1);
            }
        }
    }

    // 메소드 1
    Card pick(int idx) {
        return cardDeck[idx];
    }

    // 메소드 2
    Card pick() {
        int index = 0;
        Random ran = new Random();
        index = ran.nextInt(TOTAL_NUM);
        return pick(index);

    }

    // 셔플
    void shuffle() {
        for (int i = 0; i < TOTAL_NUM; ++i) {
            int index = (int) (Math.random() * TOTAL_NUM);
            Card temp = cardDeck[i];
            cardDeck[i] = cardDeck[index];
            cardDeck[index] = temp;
        }
    }

}