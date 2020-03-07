package Mall.Product.Washer;

public class DryFrontLoader extends  FrontLoader{

    public DryFrontLoader(int price ,String name, String color, int size){
        super(price, name, color, size);
        bonuspoint = (int)(price *bonusRate) ;
        shape = "건조드럼";
        sterilization = true;
    }

}
