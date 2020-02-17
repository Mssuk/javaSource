package app;

/**
 * Tv2
 */
public class Tv2 {

    int volume;
    void volumeUp(){
        volume++;
        System.out.println("볼륨 업. 현재 볼륨:"+ volume);
    
    }
    void volumeDown(){
        volume--;
        System.out.println("볼륨 다운. 현재 볼륨:"+ volume);
    
    }
}