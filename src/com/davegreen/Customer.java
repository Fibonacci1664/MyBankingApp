package com.davegreen;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private ArrayList<Double> transactions;
    
    public Customer(String name, double openingDeposit)
    {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(openingDeposit);
    }
    
    public void addTransaction(double amount)
    {
        this.transactions.add(amount);
    }
    
    public String getName()
    {
        return name;
    }
    
    public ArrayList<Double> getTransactions()
    {
        return transactions;
    }
}
