package Mall.Product.Washer;

public class TopLoader extends Washer {
    public TopLoader(int price ,String name, String color, int size){
        this.price = price;
        this.name = name;
        this.color = color;
        this.size = size;

        bonuspoint = (int)(price * bonusRate) ;
        shape = "통돌이";

    }
}
