package app;

/**
 * Tv
 */
public class Tv {
    String color; //tv 색상
    boolean power; //전원
    int channel; //채널
    void power(){
        if(power == true){
            System.out.println("전원을 off합니다.");
        } else{
            System.out.println("전원을 변경합니다.");
        }
        power= !power;
    }
    void channelUp(){
        System.out.println("채널을 1 증가합니다.");
        channel++;
        System.out.println("현재채널: "+channel);
    }
    void channelDown(){
        System.out.println("채널을 1 감소합니다.");
        channel--;
        System.out.println("현재채널: "+channel);
    }
    
}