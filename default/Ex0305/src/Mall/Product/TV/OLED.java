package Mall.Product.TV;

public class OLED extends TV implements hdr {

    public OLED(int price ,String name, String color, int inch){
        this.price = price;
        this.name = name;
        this.color = color;
        this.inch = inch;

        bonuspoint = (int)(price *bonusRate) ;
        screen = "OLED";

    }
    @Override
    public String toString() {
        return super.toString() + " | <기능:"+ hdr + ">";
    }
}
