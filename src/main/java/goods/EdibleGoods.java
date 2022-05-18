package goods;

public class EdibleGoods extends Goods{
    int shelfLife;

    public EdibleGoods(String name, int cost, int rating, int shelfLife) {
        super(name, cost, rating);
        this.shelfLife = shelfLife;
    }
}
