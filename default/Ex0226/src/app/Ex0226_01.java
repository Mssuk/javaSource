package app;

/**
 * Ex0226_01
 */
class Parent {
    int x= 20;

    Parent() {
        System.out.println("나는 부모");
    }

}

class Child extends Parent {
    int x = 50;

    Child() {
        System.out.println("나는 자식");
    }
    void method(){
        int x= 100;
        System.out.println("local X =" + x); 
        System.out.println("instance X=" + this.x);  
        System.out.println("parents X=" + super.x); 
    }
}

public class Ex0226_01 {

    public static void main(String[] args) {
        Child c = new Child();
        c.method();
    
    }
}