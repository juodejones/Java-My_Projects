package com.company;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    ArrayList<Customer> customers;

    public Branch(String name) {
        this.branchName = name;
        this.customers = new ArrayList<>();
    }

    public boolean newCustomer( String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;
    }

    public boolean addTransaction( String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransactions(amount);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName) {
        for (int i = 0; i< customers.size(); i++) {
            Customer checkCustomer = this.customers.get(i);
            if (checkCustomer.getCustomerName().equals(customerName)) {
                return this.customers.get(i);
            }
        }
        return null;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
