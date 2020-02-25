package app2;

public class App {
    public static void main(String[] args) {

        Deck d = new Deck();

        // 숙제 : 7장의 카드 뽑아서 출력하기.
        d.pickSeven();

    }
}

class Deck {
    final int CARD_NUM = 52;
    Card[] cdAr = new Card[CARD_NUM];

    Deck() {
        for (int i = 0; i < Card.MAX_KIND; ++i) {
            for (int j = 0; j < Card.MAX_NUM; ++j) {
                cdAr[i * Card.MAX_NUM + j] = new Card(i + 1, j + 1);
            }
        }
    }

    // 카드 뽑기 메소드
    Card pick(int index) {

        return cdAr[index];
    }

    // 랜덤 뽑기
    Card pick() {
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }

    // 셔플
    void shuffle() {
        for (int i = 0; i < 2000; ++i) {
            int num = (int) (Math.random() * CARD_NUM);
            Card temp = cdAr[num];
            cdAr[num] = cdAr[0];
            cdAr[0] = temp;
        }
    }

    void pickSeven() {
        // 아무 카드나 랜덤으로 뽑아서 출력
        for (int i = 0; i < 7; i++) {
            System.out.println(pick());
        }
    }
}

class Card {

    static final int MAX_KIND = 4;
    static final int MAX_NUM = 13;

    int kind;
    int number;

    Card() {

    }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub

        String[] kinds = { "", "하트", "스페이드", "클로버", "다이아몬드" };
        String numbers = "0123456789XJQK";
        return kinds[kind] + " " + numbers.charAt(number);
    }

}