package app;

/**
 * Ex0226_05
 */
public class Ex0226_05 {
    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println(d.x);

        Time t = new Time();
        t.t = 10;

    }

}

class Data {
    int x;
}

class Time {
    protected int t;

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

}