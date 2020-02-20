package app;

/**
 * Ex0220_01
 */
public class Ex0220_01 {

    public static void main(String[] args) {
        Data d = new Data(); // 객체 선언
        d.x = 10;
        d.y = 100;

        //d.x = change(d.x, d.y); // d.x + d.y
        //System.out.println("main :" + d.x);

        // d.y = change(d.x, d.y); //d.x - d.y;
        // System.out.println(d.y+" 는 x-y 의 값입니다.");


        // change3(d); //y의 값이 2000
        // System.out.println("d.y: " + d.y);


        // System.out.println("----------------------------");
        // d.y= change3(d.y); //y의 값이 2000
        // System.out.println("d.y: " + d.y);


        // System.out.println("------------------------");
        // change(d);
        // System.out.println("main :"+ d.x);

    }// main

    static int change(int x) {
        x = 1000;
        System.out.println("change :" + x);
        return x;
    }

    static void change(Data d) {
        d.x = 1000;
        System.out.println("change :" + d.x);
    }

    static int change(int x, int y) {
        int result = 0;
        result =  x - y;
        return result;
    }

    //change3 -> void로 y의 값 2천으로
    static void change3(Data d){
        d.y = 2000;
    }
    static int change3(int y){
        y = 2000;
        return y;
    }

}// class

class Data {
    int x;
    int y;
}