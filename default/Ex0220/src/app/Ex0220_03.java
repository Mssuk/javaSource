package app;

/**
 * Ex0220_03
 */
public class Ex0220_03 {

    public static void main(String[] args) {

        Arith a = new Arith();
        a.x = 60;
        a.y = 10;
        a.z = 2;
        int add = 0;
        int sub = 0;
        int mult = 0;
        int div = 0;


        // <문제 1> void
        System.out.println("문제 1");
        rule(a.x, a.y, a.z);


        ///////////////////////////////////////
        // <문제 2> return
        int[] rules = new int[4];
        rules = rule(a, rules);
        add = rules[0];
        sub = rules[1];
        mult = rules[2];
        div = rules[3];
        
        System.err.println("|||||||||||||||||");
        System.out.println("문제 2");
        System.out.println("------[ADD]------");
        System.out.println(add);
        System.out.println("------[SUB]------");
        System.out.println(sub);
        System.out.println("------[MUL]------");
        System.out.println(mult);
        System.out.println("------[DIV]------");
        System.out.println(div);
        System.out.println("-----------------");


        /////////////////////////////////////////////////////////////////////////////////
        // System.out.println("-ADD-");
        // a.result = add(a.x, a.y, a.z);
        // System.out.println("result: " + a.result);
        // add(a);
        // System.out.println("result: " + a.result);

        // System.out.println("------------------------------------");

        // System.out.println("-SUBTRACT-");
        // a.result = sub(a.x, a.y, a.z);
        // System.out.println("result: " + a.result);
        // sub(a);
        // System.out.println("result: " + a.result);

        // System.out.println("------------------------------------");

        // System.out.println("-MULTIPLY-");
        // a.result = mul(a.x, a.y, a.z);
        // System.out.println("result: " + a.result);
        // mul(a);
        // System.out.println("result: " + a.result);

        // System.out.println("------------------------------------");

        // System.out.println("-DIVIDE-");
        // a.result = div(a.x, a.y, a.z);
        // System.out.println("result: " + a.result);
        // div(a);
        // System.out.println("result: " + a.result);

        // System.out.println("------------------------------------");

    } // main

    //문제 1
    static void rule(int x, int y, int z){

        System.out.println("------[ADD]------");
        System.out.println(add(x,y,z));
        System.out.println("------[SUB]------");
        System.out.println(sub(x,y,z));
        System.out.println("------[MUL]------");
        System.out.println(mul(x,y,z));
        System.out.println("------[DIV]------");
        System.out.println(div(x,y,z));
        System.out.println("-----------------");
    }

    //문제 2
    static int[] rule(Arith a, int[] r){

        add(a);
        r[0] = a.result;
        sub(a);
        r[1] = a.result;
        mul(a);
        r[2] = a.result;
        div(a);
        r[3] = a.result;
        
        return r;
    }

//////////////////////////////////////////////////////////////
    static int add(int x, int y, int z) {
        int result = 0;
        result = x + y + z;
        return result;
    }

    static void add(Arith a) {

        a.result = a.x + a.y + a.z;
    }

    static int sub(int x, int y, int z) {
        int result = 0;
        result = x - y - z;
        return result;
    }

    static void sub(Arith a) {
        a.result = a.x - a.y - a.z;
    }

    static int mul(int x, int y, int z) {
        int result = 0;
        result = x * y * z;
        return result;
    }

    static void mul(Arith a) {
        a.result = a.x * a.y * a.z;
    }

    static int div(int x, int y, int z) {
        int result = 0;
        result = x / y / z;
        return result;
    }

    static void div(Arith a) {
        a.result = a.x / a.y / a.z;
    }

} // class

class Arith {
    int x;
    int y;
    int z;
    int result;
}