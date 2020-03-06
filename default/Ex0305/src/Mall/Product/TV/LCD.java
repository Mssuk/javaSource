package Mall.Product.TV;

public class LCD extends TV {

    public LCD(int price ,String name, String color, int inch){
        this.price = price;
        this.name = name;
        this.color = color;
        this.inch = inch;

        bonuspoint = (int)(price *bonusRate) ;
        screen = "LCD";

    }
}
