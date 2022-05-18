package shop;

import customerInteraction.ConsoleListener;
import customerInteraction.Listener;
import goods.Goods;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private HashMap<String, Integer> order = new HashMap<>();
    private int orderPrice;

    public void createOrder(){
        Listener listener = ConsoleListener.getInstance();
        listener.answer("Вот ассортимент нащего магазина");
        Stock.getStock().stream()
                        .forEach(System.out::println);
        listener.answer("Что вы хотите заказать");
        listener.answer("Введите название товара и количество через запятую");
        listener.answer("В конце заказа напишите \"end\"");
        while(true){
            String answer = listener.listen();
            if (answer.toLowerCase().equals("end")) break;
            else{
                orderProcessor(answer);
            }
        }
        listener.answer("Вот ваш заказ:");
        for (Map.Entry<String, Integer> map : order.entrySet()) {
            listener.answer(map.getKey() + " в количестве " + map.getValue());
        }
        listener.answer("Общая стоимость заказа - " + orderPrice);
    }

    private void orderProcessor(String answer) {
        String productName = answer.split(",")[0].trim();
        int productQuantity = Integer.parseInt(answer.split(",")[1].trim());
        if (Stock.buyGoods(productName, productQuantity)){
            order.put(productName, productQuantity);
            orderPrice += Stock.getProductPrice(productName) * productQuantity;
        }else{
            Listener listener = ConsoleListener.getInstance();
            listener.answer("Такого товара нет");
        }
    }

}
