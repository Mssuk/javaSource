package app;

/**
 * Ex0226_04
 */
class Card {
    // 변수
    int kind;
    int number;

    static final int MAX_KIND = 4; // kind
    static final int MAX_NUM = 13; // 숫자 13까지

    public enum Kind {
        NONE, HEART, DIAMOND, SPADE, CLOVER
    }

    Card() {
        this(Kind.CLOVER.ordinal(), 1);
        // this((int)(Math.random()*4)+1, 1);
    }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub

        String numbers = "0123456789XJQK";
        return String.format("%s %s", Kind.values()[kind], numbers.charAt(number));
    }

}