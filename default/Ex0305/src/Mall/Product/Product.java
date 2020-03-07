package Mall.Product;

public abstract class Product {

    protected double bonusRate;
    protected int price;
    protected int bonuspoint;
    protected String name;
    protected String color;

    public String getName() {
        return name;
    }

    public int getBonuspoint() {
        return bonuspoint;
    }

    public int getPrice() {
        return price;
    }

    public abstract <T> T GetType();
}
