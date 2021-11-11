package com.company;

import java.util.*;

public class StockList extends Cost {

    private final TreeMap<String, StockItem> list;
    private boolean sorted = false;
    Map<String, StockItem> sortedMap;

    public StockList() {
        this.list = new TreeMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.getQuantityStock());
                item.changeAvailableStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public boolean sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && inStock.getQuantityStock() >= 0) {
            inStock.adjustStock(-quantity);
/*
            if (inStock.getQuantityStock() == 0) {
                list.remove(inStock.getName());
            }
*/
            return true;
        }
        System.out.println("No stock");
        return false;
    }

    public int reserveStock(String item, int quantity) {
        return this.list.get(item).reserve(quantity);
    }

    public int unReserveStock(String item, int quantity) {
        return this.list.get(item).unReserve(quantity);
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        Map<String, StockItem> referenceMap;
        if (sorted) {
            referenceMap = Collections.unmodifiableMap(sortedMap);
        } else {
            referenceMap = Collections.unmodifiableMap(list);
        }
        for (Map.Entry<String, StockItem> item : referenceMap.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemCost = stockItem.getPrice() * stockItem.getQuantityStock();
            totalCost += itemCost;

            s += stockItem + ", There are " + stockItem.getQuantityStock() + " in stock. Cost of the stocks is " + splitCost(itemCost) + "\n";
        }
        return s + "Total stock value is $" + splitCost(totalCost) +"\n";
    }

    public Map<String, StockItem> getItems() {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, StockItem> sortList(String string, String order) {
        String finalString = string.toUpperCase();

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                boolean asc = true;
                if (order.equalsIgnoreCase("DESCENDING"))
                    asc = false;

                StockItem o1 = list.get(s1);
                StockItem o2 = list.get(s2);
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
                        int quantity1 = o1.getAvailableStock();
                        int quantity2 = o2.getAvailableStock();
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

}
