package app;

/**
 * Ex0220_02
 */
public class Ex0220_02 {

    public static void main(String[] args) {


        Plus p = new Plus();
        p.x = 10;
        p.y= 20;
        p.z = 30;


        //p.x = add(p.x, p.y, p.z);
        add(p);
        System.out.println("p.x : " + p.x);

        // Str s = new Str();
        // s.x= "abc";
        // s.y= "def";

        // s.x = merge(s.x, s.y);

        // //merge(s);
        // //s.x => abc + def
        // System.out.println(s.x);

    }//main

    //x,y,z 세 개의 값을 더하여 리턴, p.x에 값을 넣으세요.
    static int add(int x, int y, int z){

        return x+y+z;
    }
    //리턴없이 주소값을 받아서 3개 합을 구하여 p.x에 값을 넣으세요.
    static void add(Plus p){
        p.x = p.x+p.y+p.z;
    }



    // //merge 메소드 리턴값을 만들어서 2개의 변수값을 합쳐보세요.
    // static String merge(String x, String y) {
    //     return x + y;
    // }
    // //void로 주소값을 넘겨서 합쳐보세요.
    // static void merge(Str str){
    //     str.x = str.x +str.y;
    // }


}//class

class Str{
    String x;
    String y;
}

class Plus{
    int x;
    int y;
    int z;
}