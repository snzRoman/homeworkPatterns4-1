package goods;


public class HouseholdGoods extends Goods {
    Material material;

    public HouseholdGoods(String name, int cost, int rating, Material material) {
        super(name, cost, rating);
        this.material = material;
    }
}
