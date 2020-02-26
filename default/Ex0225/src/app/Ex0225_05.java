package app;

/**
 * Ex0225_05
 */
public class Ex0225_05 {

    public static void main(String[] args) {
        // Card c = new Card(1, 2);
        Deck d = new Deck(); // 52장의 카드 만들기;
        for (int i = 0; i < d.CARD_NUM; i++) {
            System.out.println(d.pick(i));
        }
        d.shuffle();

        // 7장 뽑아서 출력하기

        System.out.println("-------------------shuffle---------------------");
        for (int i = 0; i < d.CARD_NUM; i++) {
            System.out.println(d.pick(i));
        }

    }
}

class Deck {

    final int CARD_NUM = 52;
    Card[] cardArr = new Card[CARD_NUM];

    Deck() { // kind, number
        for (int i = 0; i < Card.KIND_MAX; i++) {
            for (int j = 0; j < Card.NUM_MAX; j++) {
                cardArr[j + 13 * i] = new Card(i + 1, j + 1);
            }
        }
    }

    // Card 뽑기
    Card pick(int index) {
        return cardArr[index];
    }

    // 랜덤 뽑기
    Card pick() {
        int index = 0;
        index = (int) (Math.random() * 52);
        return pick(index);
    }

    // 카드 섞기
    void shuffle() {
        for (int i = 0; i < 2000; i++) {
            int num = (int) (Math.random() * 52);
            Card temp = cardArr[num];
            cardArr[num] = cardArr[0];
            cardArr[0] = temp;

        }
    }
}

class Card {

    static final int KIND_MAX = 4; // 카드 무늬 개수
    static final int NUM_MAX = 13; // 무늬별 카드 수

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;

    int kind; // 1 = clover 2= heart 3= diamond 4=spade
    int number; // 1,2,3,4,.....9,X,J,Q,K

    Card() {

    }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // 카드 객체 찍기
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String[] kinds = { "", "CLOVER", "HEART", "DIAMOND", "SPADE" };
        String numbers = "0123456789XJQK";
        return kinds[kind] + " " + numbers.charAt(number);
    }

}
