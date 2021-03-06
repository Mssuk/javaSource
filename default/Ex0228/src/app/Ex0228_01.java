package app;

/**
 * Ex0228_01
 * 
 * 
 *           
 * 
 * 
 * 
 * 
 */
public class Ex0228_01 {

    public static void main(String[] args) {
        Parent1 p1 = new Child1();
        Child1 c1 = new Child1();

        System.out.println(p1.getX());
        p1.method();

        System.out.println(c1.getX());
        c1.method();
    }
}

class Parent1{
    private int x= 100;

    int getX(){
        return x;
    }

    void method(){
        System.out.println("부모 클래스 메소드");
    }
}

class Child1 extends Parent1 {
    private int x = 200;
    int getX(){
        return x;
    }
    void method(){
        System.out.println("자식 클래스 메소드");
    }
}