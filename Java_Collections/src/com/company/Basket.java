package com.company;
import java.util.Scanner;


import java.util.*;

public class Basket extends Cost {
    private final String name;
    private final Map<StockItem, Integer> list;
    private String outOfStock = "";
    private String removeStock = "";
    private boolean checked = false;
    private boolean sorted = false;
    Map<StockItem, Integer> sortedMap;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockList stockList, String itemName, int quantity) {
        StockItem item = stockList.get(itemName);
        return addToBasket(item, quantity);
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity >= 0)) {
            if (quantity > item.getAvailableStock()) {
                this.outOfStock += ((item.getAvailableStock() == 0) ? (item.getName() + " is Out of stock.") : ("Only " + item.getQuantityStock() +
                        " " + item.getName() + " items in stock. Can't reserve " + quantity + " items." + " Reserving " + item.getAvailableStock() + " items.")) + "\n" ;
                quantity = item.getAvailableStock();
            }
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            item.reserve(quantity);
            checked = false;
            return inBasket;
        }
        return 0;
    }

    public void checkOut() {
        checked = true;
        System.out.println(this);
        clearBasket();
    }

    public int removeItem(StockItem item, int quantity){
        if ((item != null) && (quantity >= 0)) {
            if (quantity > item.getReservedStock()) {
                this.removeStock += (item.getReservedStock() == 0) ? (item.getName() + " was not reserved.") : ("Only " + item.getReservedStock()
                 +" items have been reserved. Can't remove " + quantity + " items") + "\n";
                return 0;
            }
            int toBasket = (list.getOrDefault(item, 0) - quantity);
            if (toBasket == 0) {
                list.remove(item);
            } else {
                list.put(item, toBasket);
            }
            item.unReserve(quantity);
            checked = false;
            return item.getReservedStock();
        }
        return 0;
    }

    public void clearBasket() {
        this.list.clear();
    }

    public Map<StockItem, Integer> sortBasket(String string, String order) {

        String finalString = string.toUpperCase();

        Comparator<StockItem> comparator = new Comparator<StockItem>() {
            @Override
            public int compare(StockItem o1, StockItem o2) {

                boolean asc = true;
                if (order.equalsIgnoreCase("DESCENDING"))
                    asc = false;

                switch(finalString) {
                    case "NAME" :
                        return o1.compareTo(o2);
                    case "PRICE":
                        double price1 = o1.getPrice();
                        double price2 = o2.getPrice();
                        if (asc) {
                            if (price1 < price2)
                                return -1;
                            else if (price1 > price2)
                                return 1;
                        } else {
                            if (price1 < price2)
                                return 1;
                            else if (price1 > price2)
                                return -1;
                        }
                        return o1.compareTo(o2);
                    case "TOTALPRICE" :
                        double totalPrice1 = (o1.getPrice()) * (o1.getReservedStock());
                        double totalPrice2 = (o2.getPrice())* (o2.getReservedStock());
                        if (asc) {
                            if (totalPrice1 < totalPrice2)
                                return -1;
                            else if (totalPrice1 > totalPrice2)
                                return 1;
                        } else {
                            if (totalPrice1 < totalPrice2)
                                return 1;
                            else if (totalPrice1 > totalPrice2)
                                return -1;
                        }
                        return o1.compareTo(o2);
                    case "QUANTITY" :
                        int quantity1 = o1.getReservedStock();
                        int quantity2 = o2.getReservedStock();
                        if (asc) {
                            if (quantity1 < quantity2)
                                return -1;
                            else if (quantity1 > quantity2)
                                return 1;
                        } else {
                            if (quantity1 < quantity2)
                                return 1;
                            else if (quantity1 > quantity2)
                                return -1;
                        }
                        return o1.compareTo(o2);
                }
                return 0;
            }
        };

        sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(this.list);
        sorted = true;
        return sortedMap;
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
            String s = "\nShopping Basket " + name + " contains " + list.size() + " items\n";
            double totalCost = 0;
            Map<StockItem, Integer> referenceMap;
            if (sorted) {
                referenceMap = Collections.unmodifiableMap(sortedMap);
            } else {
                referenceMap = Collections.unmodifiableMap(list);
            }
            for (Map.Entry<StockItem, Integer> item : referenceMap.entrySet()) {
                StockItem currentItem = item.getKey();
                double cost = item.getKey().getPrice() * item.getValue();
                s += currentItem + " after " + item.getValue() + (checked ? " purchased" : " reserved" )+" | Amount -> " + String.format("%.2f", cost) + "\n";
                totalCost += cost;
            }
            s += "Total cost = $" + splitCost(totalCost);
            if (!checked) {
                s = outOfStock + "\n" + removeStock + s;
                 removeStock = outOfStock = "";
            }
            return s + "\n";
    }
}
