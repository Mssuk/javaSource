package Mall.Product.Ref;

public class DobuleDoorRef extends Ref implements doubleCooling {
    public DobuleDoorRef(int price , String name, String color, int liter){
        this.price = price;
        this.name = name;
        this.color = color;
        this.liter = liter;

        bonuspoint = (int)(price *bonusRate) ;
        door = "양문";

    }

    @Override
    public String toString() {
        return super.toString() + " | <기능:"+ doubleCooling + ">";
    }
}
