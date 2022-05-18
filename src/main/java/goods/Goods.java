package goods;

//принцип открытости/закрытости (класс открыт для расширения и наследования)
public abstract class Goods {

    protected String name;
    protected int cost;
    protected int rating;

    public Goods(String name, int cost, int rating) {
        this.name = name;
        this.cost = cost;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  name +
                " - цена: " + cost +
                ", рейтинг: " + rating +
                ';';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
