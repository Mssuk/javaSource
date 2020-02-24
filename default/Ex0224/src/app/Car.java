package app;

/**
 * Car
 */
public class Car {

    String color;
    String gearType;
    int door;

    Car(){
        this("white","수동",4);
    }
    Car(String color ,String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}