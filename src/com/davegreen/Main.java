package com.davegreen;

public class Main
{

    public static void main(String[] args)
    {
	    CentralBank centralBank = new CentralBank("Bank of America");
	    Branch branch = new Branch();
		
		centralBank.startBankingApp();
	}
}
