package Mall.Product.TV;

public class OLED extends TV {

    public OLED(int price ,String name, String color, int inch){
        this.price = price;
        this.name = name;
        this.color = color;
        this.inch = inch;
        hdr = true;

        bonuspoint = (int)(price *bonusRate) ;
        screen = "OLED";

    }
}
