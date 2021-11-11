package com.company;

public class Cost {

    public String splitCost(double price) {
        String costString = "";
        int cost = ((int)(price*100))/100;

        if (cost > 999999 ) {
            costString = splitCost(cost/100000) + "," + cost%1000000;
        } else if (cost > 999) {
            costString = (cost/1000) + "," + cost%1000;
        } else {
            costString = Integer.toString(cost);
        }
        int point = (int)((price*100)%100);
        return costString + "." + ((point<10) ? point+"0" : point);
    }
}
