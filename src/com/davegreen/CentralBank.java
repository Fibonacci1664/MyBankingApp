package com.davegreen;

import java.util.ArrayList;
import java.util.Scanner;

public class CentralBank
{
    private String name;
    private ArrayList<Branch> branches;
    private Scanner scanner = new Scanner(System.in);
    private Branch branch = new Branch();
    
    public CentralBank()
    {
        this.name = name;
        this.branches = branches;
        this.scanner = scanner;
        this.branch = branch;
        this.branches = new ArrayList<Branch>();
    }
    
    public CentralBank(String name)
    {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    
    public boolean addNewBranch()
    {
        System.out.println("\n> Please enter the name of the branch you wish to add: ");
        
        String newBranchInput = scanner.nextLine();
    
        if(findBranch(newBranchInput) == null)
        {
            this.branches.add(new Branch(newBranchInput));
            System.out.println("\n*** You have added " + newBranchInput + " to the branches available to the central bank. ***");
            
            return true;
        }
    
        return false;
    }
    
//    public boolean addCustomer()
//    {
//        boolean isBranch = branchSelector();
//
//        if(isBranch)
//        {
//            branch.addNewCustomer();
//        }
//
//        return false;
//    }
    
//    public boolean addCustomerTransaction(String branchName, String customerName, double amount)
//    {
//        Branch branch = findBranch(branchName);
//
//        if(branch != null)
//        {
//            return branch.addCustomerTransaction(customerName, amount);
//        }
//
//        return false;
//    }
    
    private Branch findBranch(String branchName)
    {
        for(int i = 0; i < this.branches.size(); i ++)
        {
            Branch checkedBranch = this.branches.get(i);
            
            if(checkedBranch.getName().equals(branchName))
            {
                //System.out.println("\t*** Error, the " + branchName + " branch already exists ***");
                return checkedBranch;
            }
        }
        
        return null;
    }
    
    public boolean listCustomersByBranch()
    {
        String userChoice = branchSelector();
        
        System.out.println("Customers for " + userChoice + " are as follows: ");
        
        ArrayList<Customer> branchCustomers = branch.getCustomerArrayList();
        
        for(int i = 0; i < branchCustomers.size(); i ++)
        {
            Customer branchCustomer = branchCustomers.get(i);
            System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
        }
        
        return true;
    }
    
    public boolean listCustomersTransactionsByBranch(String branchName)
    {
        Branch branch = findBranch(branchName);
    
        if(branch != null)
        {
            System.out.println("> Customers for branch " + branch.getName());
        
            ArrayList<Customer> branchCustomers = branch.getCustomerArrayList();
        
            for(int i = 0; i < branchCustomers.size(); i ++)
            {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("> Customer: " + branchCustomer.getName() + " their transactions are as follows: ");
                
                ArrayList<Double> transactions = branchCustomer.getTransactions();
                
                for(int j = 0; j < transactions.size(); j ++)
                {
                    System.out.println("\n\t[" + (j + 1) + "] Amount " + transactions.get(j));
                }
                
            }
        
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean printListOfBranches()
    {
        System.out.println("\n> Bank of America Branches List: ");
    
        //System.out.println(branches);       // This will just simply print out the memory locations of the assigned elements.
                                            // not the values that have been assigned to those memory locations.
        
                                            // This for loop will print out the actual values of the elements.
       if(branches.size() > 0)
       {
           for (int i = 0; i < this.branches.size(); i ++)
           {
               System.out.println("\n\t" + (i + 1) + ". " + this.branches.get(i).getName());
           }
    
           return true;
       }
       else
       {
           System.out.println("\n*** There are no branches available at this time. ***");
           return false;
       }
    }
    
    public void startBankingApp()
    {
        boolean flag = true;
        
        while(flag)
        {
            System.out.println("\n> What would you like to do: " +
                    "\n\t 1. Search branches." +
                    "\n\t 2. Add new branch. " +
                    "\n\t 3. Print a list of all branches." +
                    "\n\t 4. Select a branch to work with.");
    
            int userChoice = scanner.nextInt();
            scanner.nextLine();
    
            switch (userChoice)
            {
                case 1:
                    System.out.println("\n*** You have chosen to search for a branch. ***");
                    break;
                case 2:
                    System.out.println("\n*** You have chosen to add a new branch. ***");
                    addNewBranch();
                    break;
                case 3:
                    System.out.println("\n*** You have chosen to print out a list of all the branches.");
                    printListOfBranches();
                    break;
                case 4:
                    System.out.println("*** You have chosen to select a branch to work with.");
                    String chosenBranch = branchSelector();
                    
                    for(int i = 0; i < this.branches.size(); i ++)
                    {
                        Branch checkedBranch = this.branches.get(i);
        
                        if(checkedBranch.getName().equals(chosenBranch))
                        {
                            branch.branchOptions(chosenBranch);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("\n*** Error ***");
            }
        }
    }
    
    public String branchSelector()
    {
        printListOfBranches();
    
        if(branches.isEmpty())
        {
            return " ";
        }
        
        System.out.println("\n> Please select from the list which branch you would like to work with: ");
        
        String input = scanner.nextLine();
        
        while(findBranch(input) == null)
        {
            System.out.println("*** That branch does not exist, please choose from the list above. ***");
            input = scanner.nextLine();
        }
        
        if(findBranch(input) != null)
        {
            System.out.println("*** You have chosen to work with the " + input + " branch. ***");
            return input;
        }
        
        return "Error";
    }
}