package com.company;

public class StockItem extends Cost implements Comparable<StockItem>{

    private final String name;
    private double price;
    private int quantityStock;
    private int reservedStock;
    private int availableStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.availableStock = this.quantityStock = 0;
        this.reservedStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.availableStock = this.quantityStock = quantityStock;
        this.reservedStock = 0;
    }

    public void changeAvailableStock(int quantity) {
        this.availableStock += quantity;
    }

    public int reserve(int quantity) {
        if (quantity > 0 && quantity <= this.getQuantityStock()) {
            this.reservedStock += quantity;
            changeAvailableStock(-quantity);
            return reservedStock;
        }
        return 0;
    }

    public int unReserve(int quantity) {
        if (quantity > 0 && quantity <= this.getReservedStock()) {
            this.reservedStock -= quantity;
            changeAvailableStock(quantity);
            return this.reservedStock;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public int getReservedStock() {
        return reservedStock;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock += quantityStock;
        this.availableStock += quantityStock;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0 ) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 23;
    }

    @Override
    public boolean equals(Object obj) {
//        System.out.println("Entering StockItem.equals");
        if (this == obj) {
            return  true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((StockItem)obj).getName();
        return this.getName().equals(objName);
    }

    @Override
    public int compareTo(StockItem item) {
//        System.out.println("Entering StockItem.compareTo");
        if (this == item) {
            return 0;
        }
        if (item.getPrice() != 0) {
            return this.name.compareTo(item.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " | price : " + splitCost(this.price) /*+ " | quantity -> " + this.quantityStock */+ " | available -> " + this.availableStock;
    }

}
