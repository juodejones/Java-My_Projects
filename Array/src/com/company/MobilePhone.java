package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<String> nameList = new ArrayList<>();
    private ArrayList<String> numberList = new ArrayList<>();
    
    public int getIndexName(String word ) {
        return nameList.indexOf(word);
    }

    public int getIndexNumber (String word) { return numberList.indexOf(word); }

    public void addContact(String name, String number) {
        nameList.add(name);
        numberList.add(number);
    }

    public void modifyContactName (String oldName, String newName) {
        if (nameList.contains(oldName)) {
            nameList.set(getIndexName(oldName), newName);
        } else {
            System.out.println("No such contact is present ");
        }
    }

    public void modifyContactNumber (String contactName, String newNumber) {
        if (nameList.contains(contactName)) {
            numberList.set(getIndexName(contactName), newNumber);
        } else {
            System.out.println("No such contact is present ");
        }
    }
    
    public void removeContact ( String word ) {
        if (nameList.contains(word)) {
            numberList.remove(getIndexName(word));
            nameList.remove(word);
        } else if (numberList.contains(word)) {
            nameList.remove(getIndexNumber(word));
            numberList.remove(word);
        } else {
            System.out.println("No such contact is present ");
        }
    }

    public void printContactList () {
        for (int i = 0; i< nameList.size(); i++) {
            if ((nameList.get(i).equals("null")) || (numberList.get(i).equals("null"))){
                break;
            } else {
                System.out.println(nameList.get(i) + ":" + numberList.get(i));
            }
        }
    }

    public void searchContactList ( String string ) {
        if (nameList.contains(string)) {
            int i = getIndexName(string);
            System.out.println(nameList.get(i) + ":" + numberList.get(i));
        } else if (numberList.contains(string)) {
            int i = getIndexNumber(string);
            System.out.println(nameList.get(i) + ":" + numberList.get(i));
        } else {
            System.out.println("No such contact is found");
        }
    }
}
