package com.davegreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch
{
    private String name;
    private ArrayList<Customer> customerArrayList;
    private Scanner scanner = new Scanner(System.in);
    
    
    public Branch()
    {
        this.name = name;
        this.customerArrayList = new ArrayList<Customer>();
    }
    
    public Branch(String name)
    {
        this.name = name;
        this.customerArrayList = new ArrayList<Customer>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public ArrayList<Customer> getCustomerArrayList()
    {
        return customerArrayList;
    }
    
    public void addNewCustomer()
    {
        System.out.println("\n> Please now enter how much you would like to open the account with: ");
        
        double openingDeposit = scanner.nextDouble();
        scanner.nextLine();
    
        System.out.println("\n> Please enter the name of the customer you would like to add to the branch: ");
    
        String customerName = scanner.nextLine();
        
        if(findCustomer(customerName) == null)
        {
            customerArrayList.add(new Customer(customerName, openingDeposit));
            System.out.println("\n*** Adding " + customerName + " to the " + this.name + " local branch. ***");
        }
        else
        {
            System.out.println("Error adding customer.");
        }
        
    }
    
//    public boolean addCustomerTransaction(String customerName, double amount)
//    {
//        Customer existingCustomer = findCustomer(customerName);
//
//        if(findCustomer(customerName) != null)
//        {
//            existingCustomer.addTransaction(amount);
//            return true;
//        }
//
//        return false;
//    }
    
    private Customer findCustomer(String customerName)
    {
        if(customerArrayList.isEmpty())
        {
            System.out.println("*** Congratulations " + customerName + " on being our very first customer. ***");
            return null;
        }
        else
        {
            for (int i = 0; i < this.customerArrayList.size(); i++)
            {
                Customer checkedCustomer = this.customerArrayList.get(i);
        
                if (!checkedCustomer.getName().equals(customerName))
                {
                    System.out.println("\n*** No customers with that name on file. ***");
                    return null;
                }
                else if (checkedCustomer.getName().equals(customerName))
                {
                    System.out.println("\n*** " + customerName + " is on file. ***");
                    return checkedCustomer;
                }
            }
        }
        
        return null;
    }
    
    public boolean branchOptions(String localBranch)
    {
        boolean flag = true;
        
        this.name = localBranch;
        
        while(flag)
        {
            System.out.println("\n*** Welcome to the " + localBranch + " branch. ***");
    
            System.out.println("\n> What would you like to do: " +
                                "\n\t 1. Add a new customer." +
                                "\n\t 2. Search for a customer." +
                                "\n\t 3. Remove a customer." +
                                "\n\t 4. Print a list of customers." +
                                "\n\t 5. Go back to the central bank.");
            
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch(userChoice)
            {
                case 1:
                    System.out.println("\n*** You have chosen to add a new customer. ***");
                    addNewCustomer();
                    break;
                case 2:
                    System.out.println("\n*** You have chosen to search for a customer. ***");
                    System.out.println("\n> What is the customers name? ");
                    
                    String customerSearchName = scanner.nextLine();
                    //scanner.nextLine();
                    findCustomer(customerSearchName);
                    break;
                case 3:
                    System.out.println("\n*** You have chosen to remove a customer from the " + localBranch + " branch. ***");
                    break;
                case 4:
                    System.out.println("\n*** You have chosen to print a list of customers from the " + localBranch + " branch. ***");
                    printCustomers();
                    break;
                case 5:
                    System.out.println("\n *** You have chosen to go back to the central bank. ***");
                    flag = false;
                    break;
            }
        }
        
        return false;
    }
    
    public void printCustomers()
    {
        System.out.println("\n> All customer within the " + this.name + " local branch: ");
    
        if(customerArrayList.isEmpty())
        {
            System.out.println("No customers on file.");
        }
        else
        {
            for(int i = 0; i < customerArrayList.size(); i ++)
            {
                Customer checkedCustomer = customerArrayList.get(i);
                System.out.println("\n\t*** " + (i + 1) + ". " + checkedCustomer.getName() + ". ***");
            }
        }
    }
}
