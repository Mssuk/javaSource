package app;

import app.Card.Kind;

/**
 * User
 */
public class User {

    String name;
    Card[] myCard = new Card[7]; // 카드 7장 갖고 있음.
    int idxCnt = 0; // 인덱스 카운트

    User(String name) {
        this.name = name;
    }

    void inputCard(Card card) {
        myCard[idxCnt] = card;
        idxCnt++;
    }

    // 해당 모양 카운트해주는 메소드
    int showMyCard(Kind kds) {
        int count = 0;

        for (int i = 0; i < myCard.length; ++i) {
            if (myCard[i] == null) {
                continue;
            }
            if (kds.ordinal() == myCard[i].kind) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub

        String str = String.format("%s 가 갖고 있는 카드입니다..", name);
        for (Card card : myCard) {
            if (card != null)
                str += " <<" + card + ">>";
        }

        return str;
    }
}