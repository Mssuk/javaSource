package Mall.Product.Washer;

public class FrontLoader extends Washer {
    public FrontLoader(int price ,String name, String color, int size){
        this.price = price;
        this.name = name;
        this.color = color;
        this.size = size;

        bonuspoint = (int)(price *bonusRate) ;
        shape = "드럼";
    }
}
