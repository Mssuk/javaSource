package app;

/**
 * Ex0221_02
 */
public class Ex0221_02 {

    public static void main(String[] args) {
        // for kind -클로버, 하트, 다이아몬드, 스페이드
        // number 1-13 총 52개 만들어서 넣기

        String[] kind = { "클로버", "하트", "다이아몬드", "스페이드" };
        Card[] deck = new Card[52];
        String num="123456789XJQK";

        for (int i = 0; i < kind.length; ++i) {
            for (int j = 0; j < 13; ++j) {
                deck[i * 13 + j] = new Card(kind[i], num.charAt(j));      
            }
        }

        for (int i = 1; i <= deck.length; ++i) {
            System.out.print(deck[i - 1].kind + deck[i - 1].number + " ");
            if (i % 13 == 0) {
                System.out.println();
            }
        }

        // Card c = new Card();
        // c.kind = "클로버";
        // c.number = 1;
        // System.out.println("기본생성자: "+ c.kind+ c.number);

        // Card c2= new Card("하트", 2);
        // System.out.println("매개변수가 있는 생성자: "+ c2.kind + c2.number);
    }
}