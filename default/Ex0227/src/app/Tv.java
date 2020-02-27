package app;

/**
 * Tv
 */
public class Tv {

    boolean power;
    int channel;

    void power(){
        power = !power;
    };

    void channelUp(){
        channel++;
    }
    void channelDown(){
        channel--;
    }
}