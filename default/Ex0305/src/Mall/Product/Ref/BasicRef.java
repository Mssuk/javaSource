package Mall.Product.Ref;

public class BasicRef extends Ref {
    public BasicRef(int price , String name, String color, int liter){
        this.price = price;
        this.name = name;
        this.color = color;
        this.liter = liter;

        bonuspoint = (int)(price *bonusRate) ;
        door = "기본";

    }
}
