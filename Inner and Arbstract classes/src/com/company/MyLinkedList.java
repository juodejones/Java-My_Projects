package com.company;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {

        if (this.root == null) {
            this.root = newItem; //The list is empty.
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);

            if (comparison < 0) {
                //New item is greater hence move rightwards
                if (currentItem.next() != null) {
                    //Moving to next item
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                //New item is lesser hence move leftwards
                if (currentItem.previous() != null) {
                    //Moving to previous item
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                } else {
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, hence not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {

        ListItem currentItem = this.root;
        int comparison = currentItem.compareTo(item);
        if (comparison == 0) {
            if (currentItem == this.root) {
                currentItem = currentItem.next();
            } else {
                currentItem.previous().setNext(currentItem.next());
                if (currentItem.next() != null) {
                    currentItem.next().setNext(currentItem.previous());
                }
            }
            return true;
        } else if (comparison < 0) {
            currentItem = currentItem.next();
        } else {
            return false;
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if (root == null) {
            System.out.println("The list is empty.");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
