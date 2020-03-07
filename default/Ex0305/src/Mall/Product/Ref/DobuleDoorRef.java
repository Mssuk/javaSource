package Mall.Product.Ref;

public class DobuleDoorRef extends Ref {
    public DobuleDoorRef(int price , String name, String color, int liter){
        this.price = price;
        this.name = name;
        this.color = color;
        this.liter = liter;
        bonuspoint = (int)(price *bonusRate) ;
        door = "양문";
        doubleCooling = true;

    }
}
