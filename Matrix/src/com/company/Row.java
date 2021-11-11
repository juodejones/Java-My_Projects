package com.company;

import java.util.ArrayList;

public class Row {

    ArrayList<Integer> rowList;

    public Row() {
        this.rowList = new ArrayList<>();
    }

    public void addElement(int num) {
        this.rowList.add(num);
    }

    public ArrayList<Integer> getRowList() {
        return rowList;
    }
}
