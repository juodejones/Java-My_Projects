package com.company;

import java.util.ArrayList;

public class SmartPhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public SmartPhone (String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    public boolean addContact(Contact contact) {
        if ( findContact(contact.getName()) >= 0 ) {
                return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position <0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0 ) {
            return myContacts.get(position);
        }
        return null;
    }

    public boolean removeContact (Contact contact) {
        int position = findContact((contact));
        if (position <0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(position);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (int i=0; i < myContacts.size(); i++) {
            System.out.println((i+1) + "." + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public void start() {
        System.out.println("Phone is switching ON...");
    }

    public void shutdown() {
        System.out.println("Shutting down Mobile Phone...");
    }
}
