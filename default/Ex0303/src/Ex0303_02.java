/**
 * Ex0303_02
 */
public class Ex0303_02 {

    public static void main(String[] args) {

        A a = new A();
        a.methodA(new D());

    }
}

interface I {
    public void methodB();
}

class A {
    public void methodA(I i) {
        System.out.println("methodA 메소드가 호출");
        i.methodB();
    }
}

class D implements I {
    public void methodB() {
        System.out.println("methodB 메소드가 호출");
    }
}

/*
*/