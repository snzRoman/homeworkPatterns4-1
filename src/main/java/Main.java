import customerInteraction.ConsoleListener;
import customerInteraction.Listener;
import goods.*;
import shop.Order;
import shop.Stock;

public class Main {

    public static void main(String[] args) {
        fillStock();
        controlOrder();
    }

    public static void controlOrder(){
        // Ждем заказа
        while(true){
            Listener listener = ConsoleListener.getInstance();
            listener.answer("Вы хотите сделать заказ?");
            if (listener.listen().toLowerCase().equals("да")){
                Order order = new Order();
                order.createOrder();
            }else {
                listener.answer("Надеемся вы к нам вернетесь");
                break;
            }
        }
    }

    public static void fillStock(){
        Stock.fillStore(new EdibleGoods("Bread", 20, 5, 2), 50);
        Stock.fillStore(new EdibleGoods("Milk", 50, 4, 5), 10);
        Stock.fillStore(new EdibleGoods("Eggs", 100, 5, 15), 25);
        Stock.fillStore(new EdibleGoods("Bisсuit", 250, 3, 100), 5);
        Stock.fillStore(new ElectronicsGoods("ApplePhone", 100_000, 4, 1000), 4);
        Stock.fillStore(new ElectronicsGoods("XiomiPhone", 50_000, 5, 1500), 13);
        Stock.fillStore(new ElectronicsGoods("SamsungPhone", 70_000, 4, 1600), 3);
        Stock.fillStore(new HouseholdGoods("Knife", 1000, 5, Material.METAL), 6);
        Stock.fillStore(new HouseholdGoods("Cutting board", 500, 4, Material.WOOD), 17);
        Stock.fillStore(new HouseholdGoods("Bowl", 120, 3, Material.PLASTIC), 25);

    }
}
