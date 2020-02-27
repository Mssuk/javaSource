package app;

public class App {
    public static void main(String[] args) throws Exception {
       T1 t1 = new T1();
       System.out.println(t1.s);
       T2 t2 = new T2();
       System.out.println(t2.s);
       T1 t3 = new T1(); 
       System.out.println(t1.s);
       System.out.println(t3.s);
    }
}

class T1 {
    String s = "A";

}

class T2 extends T1{

    T2(){
        this.s= "B";
    }
}