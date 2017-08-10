package com.example.springbootDemo.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java 8 stream使用
 * Created by wangdi on 2017/8/10.
 */
public class StreamAPIDemo {

    static class Item {
        String itemName;
        long price;

        public Item(String itemName, long price) {
            this.itemName = itemName;
            this.price = price;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "itemName='" + itemName + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Item> shoppingList = new ArrayList<>();
        shoppingList.add(new Item("iPhone 7", 7250L));
        shoppingList.add(new Item("Rolex Watch", 28888L));
        shoppingList.add(new Item("Electric Toothbrush", 388L));
        shoppingList.add(new Item("Kindle Paperwhite", 1098L));
        shoppingList.add(new Item("Coca Cola", 3L));
        shoppingList.stream().forEach(System.out::println);
        //统计
        long itemNum = shoppingList.stream().count();
        System.out.println("Sum of items in the shopping list: " + itemNum);

        long totalPrice = shoppingList.stream().collect(Collectors.summingLong(Item::getPrice));
        System.out.println("Total price: " + totalPrice);

        //过滤排序
        shoppingList.stream().filter(p -> p.getPrice() >= 1000L).forEach(System.out::println);

        shoppingList.stream().sorted(Comparator.comparingLong(Item::getPrice)).forEach(System.out::println);

        //MapReduce
        List<Item> collect = shoppingList.stream().map(p -> new Item(p.getItemName(), p.getPrice() - 100)).collect(Collectors.toList());

        Item cheapestLuxury = shoppingList.stream().map(p -> new Item(p.getItemName(), p.getPrice()-100))
                .filter(p -> p.getPrice() > 1000).reduce((a, b) -> a.getPrice()<b.getPrice()?a:b).get();
        System.out.println(cheapestLuxury);
    }

}
