package com.company;

import java.util.ArrayList;

public class Bank {

    private String bankName;
    ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<>();
    }

    public boolean newBranch(String branchName) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addTransaction(customerName, amount);
        }
        return false;
    }

    public Branch findBranch(String branchName) {
        for (int i=0; i< branches.size(); i++) {
            Branch checkBranch = this.branches.get(i);
            if (checkBranch.getBranchName().equals(branchName)) {
                return this.branches.get(i);
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details in branch " + branch.getBranchName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer [" + (i+1) + "] :" + branchCustomer.getCustomerName());
                if (showTransactions) {
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j=0; j<transactions.size(); i++) {
                        System.out.println("Transaction [" + (j+1) + "]" + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}
