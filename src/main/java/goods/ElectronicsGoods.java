package goods;

public class ElectronicsGoods extends Goods{
    int power;

    public ElectronicsGoods(String name, int cost, int rating, int power) {
        super(name, cost, rating);
        this.power = power;
    }
}
