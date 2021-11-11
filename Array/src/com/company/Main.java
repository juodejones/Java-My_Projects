package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    private static SmartPhone mobilePhone= new SmartPhone("807 231 3659");

    public static void main(String[] args) {

    }

    //PRINTING AN ARRAY MAIN
    public static void printArrayMain() {
        int[] intArray = getInput(5);
        int[] sortedArray = sortArray(intArray);
        printArray(intArray);
        System.out.println("\nSorted Array is\n");
        printArray(sortedArray);
    }

    //GETTING AN ARRAY FROM THE USER
    public static int[] getInput(int number ) {
        int[] array = new int[number];
        System.out.println("Enter the " + number + " elements of the array");
        for ( int i=0; i<number; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    //PRINTING AN ARRAY
    public static void printArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("Element " + i + " is, " + array[i]);
        }
    }

    //SORTING AN ARRAY
    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i=0; i< sortedArray.length; i++) {
            sortedArray[i] = array[i];
        }
        int temp;
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < array.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }

    //FINDING THE MINIMUM ELEMENT IN THE ARRAY
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i=1; i< array.length; i++) {
            if ( array[i] < min ) {
                min = array[i];
            }
        }
        return min;
    }

    //REVERSING AN ARRAY
    public static void reverseArray(int[] array) {
        int i = 0, j = array.length-1;
        int[] reversedArray = new int[array.length];
        while ( i < array.length ) {
            reversedArray[j] = array[i];
            i++; j--;
        }
        System.out.println("Reversed array = " + Arrays.toString(reversedArray));
    }

    //REVERSE ARRAY MAIN
    public static void reverseArrayMain() {
        System.out.println("Enter the number of elements in the array :");
        int count = scanner.nextInt();
        int[] myIntArray = getInput(count);
        //        System.out.println("Minimum element in the array = " + findMin(myIntArray));
        reverseArray(myIntArray);
    }

    //GROCERY LIST METHODS
    //GROCERY LIST MAIN
    public static void grocerListMain() {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    /*public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");

    }*/

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Current item name: ");
        String itemNo = scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem);
        } else {
            System.out.println(searchItem + ", not on file.");
        }
    }

    public static void processArrayList() {

        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);

    }

    //MOBILE PHONE CONTACTS

    //MOBILE PHONE CONTACTS MAIN
    public static void mobilePhoneContactsMain() {
        MobilePhone phoneContacts =  new MobilePhone();
        printInstructions();
        int choice = 0;
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    phoneContacts.printContactList();
                    break;
                case 2:
                    System.out.println("Enter contact name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter contact number:");
                    String number = scanner.nextLine();
                    phoneContacts.addContact(name, number);
                    break;
                case 3:
                    System.out.println("Enter the contact name or number:");
                    String word = scanner.nextLine();
                    phoneContacts.searchContactList(word);
                    break;
                case 4:
                    System.out.println("Enter the saved contact name:");
                    String oldName = scanner.nextLine();
                    System.out.println("Enter the New name:");
                    String newName = scanner.nextLine();
                    phoneContacts.modifyContactName(oldName, newName);
                    break;
                case 5:
                    System.out.println("Enter the contact name whose number is to be changed:");
                    String contactName = scanner.nextLine();
                    System.out.println("Enter the New number:");
                    String newNumber = scanner.nextLine();
                    phoneContacts.modifyContactNumber(contactName, newNumber);
                    break;
                case 6:
                    System.out.println("Enter the contact name or number to be removed:");
                    String data = scanner.nextLine();
                    phoneContacts.removeContact(data);
                    break;
                case 7:
                    quit = true;
                    System.out.println("Exiting mobile phone Contacts...");
            }
        }
    }


    public static void printInstructions() {

        System.out.println("\nEnter ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact");
        System.out.println("\t 3 - To search a contact.");
        System.out.println("\t 4 - To modify a contact name.");
        System.out.println("\t 5 - To modify a contact number.");
        System.out.println("\t 6 - To remove a contact name or number.");
        System.out.println("\t 7 - To quit the application.");

    }

    //SMART PHONE CONTACTS WITH CLASSES

    //SMART PHONE CONTACTS MAIN
    public static void smartPhoneContactsMain() {
        boolean quit = false;
        mobilePhone.start();
        int choice = 0;
        printActions();
        while (!quit) {
            System.out.println("Enter your choice (6 - to show choices) : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    mobilePhone.shutdown();
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Enter a valid Choice.");
                    printActions();
            }
        }
    }

    public static void printActions() {
        System.out.println("Enter \n" +
                "\t 0 - To shutdown the phone.\n " +
                "\t 1 - To print the list of contacts.\n" +
                "\t 2 - To add a new contact.\n" +
                "\t 3 - To update an existing contact.\n" +
                "\t 4 - To remove an existing contace.\n" +
                "\t 5 - To query if a contact exists.\n" +
                "\t 6 - To print a list of available actions.");
    }

    public static void printContacts() {
        mobilePhone.printContacts();
    }

    public static void addNewContact() {
        System.out.println("Enter Contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Contact number: ");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phoneNumber);
        if (mobilePhone.addContact(newContact)) {
            System.out.println("New Contact: " + newContact.getName() + " -> " + newContact.getPhoneNumber() + " has been added.");
        } else {
            System.out.println("Contact cannot be added, " + newContact.getName() + " is already present");
        }
    }

    public static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String oldName = scanner.nextLine();
        Contact queryContact = mobilePhone.queryContact(oldName);
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number" );
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.queryContact(newContact) == null) {
            System.out.println("Contact with this name is already present.");
        } else {
            mobilePhone.updateContact(queryContact, newContact);
            System.out.println("Contact has been successfully updated");
        }
    }

    public static void removeContact() {
        System.out.println("Enter the contact name to be removed: ");
        String contactName = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(contactName);
        mobilePhone.removeContact(contact);
    }

    public static void queryContact() {
        System.out.println("Enter the contact name: ");
        String contactName = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(contactName);
        if (contact == null) {
            System.out.println("Contact with name " + contactName + ", is not present.");
        } else {
            System.out.println("Contact with name " + contactName + ", is present.");
        }
    }

    public static void bankAppMain() {
        Bank bank = new Bank("National Australia Bank");

        bank.newBranch("Adelaide");

        bank.addCustomer("Adelaide", "Tim", 50.05);
        bank.addCustomer("Adelaide", "Mike", 175.34);
        bank.addCustomer("Adelaide", "Percy", 220.12);

        bank.addTransaction("Adelaide", "Tim", 44.22);
        bank.addTransaction("Adelaide", "Tim", 12.44);
        bank.addTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
    }
}