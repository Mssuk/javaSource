package app;

public class App {
    public static void main(String[] args) {
        String[] str ={"hi", "hello"};

        trans(str);
        System.out.println(str);

        str = trans0();
        System.out.println(str);
    }

    static void trans(String[] arr){
        arr = null;
    }
    static String[] trans0(){
        return null;
    }
}