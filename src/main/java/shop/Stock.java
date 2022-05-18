package shop;

import customerInteraction.ConsoleListener;
import customerInteraction.Listener;
import goods.Goods;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Stock {
    private static HashMap<Goods, Integer> stock = new HashMap<>();

    public static Set<Goods> getStock() {
        return stock.keySet();
    }

    //DRY
    public static void fillStore(Goods goods, Integer count){
        if (stock.containsKey(goods)){
            stock.put(goods, stock.get(goods) + count);
        }else{
            stock.put(goods, count);
        }
    }

    //DRY
    public static int getProductPrice(String name){
        int price = 0;
        for (Map.Entry<Goods, Integer> map : stock.entrySet()) {
            if (map.getKey().getName().toLowerCase().equals(name.toLowerCase())){
                price = map.getKey().getCost();
            }
        };
        return price;
    }

    //DRY
    public static boolean buyGoods(String name, int quantity){
        boolean allGood = false;
        Listener listener = ConsoleListener.getInstance();
        for (Map.Entry<Goods, Integer> map : stock.entrySet()) {
            if(map.getKey().getName().toLowerCase().equals(name.toLowerCase())){
                if (map.getValue() >= quantity){
                    stock.put(map.getKey(), map.getValue() - quantity);
                    allGood = true;
                    break;
                }else{
                    listener.answer("Такого количества на складе нет");
                }
            }
        }
        return allGood;
    }


}
