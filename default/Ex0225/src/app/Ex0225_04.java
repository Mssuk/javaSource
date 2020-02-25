package app;

/**
 * Ex0225_04
 */
public class Ex0225_04 {

    public static void main(String[] args) {


        Data d1 = new Data();
        System.out.println(d1);


        // CaptionTV c1= new CaptionTV();
        // c1.channel = 7;
        // c1.channelUp(); // 8
        // c1.channelUp(); // 9
        // c1.channelDown(); // 8 
        // System.out.println("현재 채널 " +  c1.channel);
        // c1.caption = true;
        // c1.displayCap("Hello World!");
        
        // TV t1;

    }
}

class TV {
    boolean power; // 전원 on -true , off - false
    int channel;
    int volume;

    void power() {
        power = !power;
    }

    void channelUp() {

        // 100번이 넘어가면 다시 1번으로
        ++channel;
        channel = (channel % 100);
    }

    void channelDown() {
        --channel;
        // -1이면 100번임
        if (channel < 0) {
            channel = 100;
        }
    }
}

class CaptionTV extends TV {

    boolean caption;

    void displayCap(String text) {
        if (caption == true) {
            System.out.println("caption ON");
            System.out.println(text);
        }
    }
}

class Data {
    int x=10 ;
    int y=10;


    public String toString(){

        return new String(x+y+"");
    }

}
