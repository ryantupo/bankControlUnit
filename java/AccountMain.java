/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryansPC
 */
//Account general details:
//1. Account number
//2. Account holder name
//3. Account holder address
//4. Opening Date
//5. Current balance.
//Transaction details:
//1. Transaction type (i.e. deposit, withdrawal)
//2. Transaction amount
//3. Transaction date.
//manage accounts
//hold last 6 transactions with some coollections framework
// save onto disk ? 
//1. Create a new account and add it to the system. - done
//2. Display on the computer screen a list of the existing accounts with the account general details. - done
//3. Delete a closed account from the system, given the account number. - done
//4. Update the system with details of any new transaction of existing accounts. Note that for each
//account only the information of the last six transactions is maintained by the system. - done
//5. Given an account number, display on the computer screen details of the account's last six
//transactions being sorted by transaction amounts. Note that all transaction amounts are positive
//numbers regardless whether a transaction is a deposit or withdrawal. - done 
//6. Provide an appropriate system user interface that allows testing of the above methods.
//Account general details:
//1. Account number
//2. Account holder name
//3. Account holder address
//4. Opening Date
//5. Current balance.
//Transaction details:
//1. Transaction type (i.e. deposit, withdrawal)
//2. Transaction amount
//3. Transaction date.
import java.util.*; //imports all util
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class AccountMain {

    private int AccNumber;
    private String AccName;
    private String AccAddress;
    private String OpeningDate;
    public double currentBalance;
    private String formattedDate;

    //public LinkedList<Double> transactions = new LinkedList<Double>();
    //public LinkedList<Double> withdraws = new LinkedList<Double>();
    
    public CustomListLinky transactions = new CustomListLinky();
    public CustomListLinky withdraws = new CustomListLinky();

    //create another list to then sort transactions (they need to be saved in order of placed)    
    //LinkedList<Double> sortedTransactions = new LinkedList<Double>();
    //LinkedList<Double> sortedWithdraws = new LinkedList<Double>();
    
    public CustomListLinky sortedTransactions = new CustomListLinky();
    public CustomListLinky sortedWithdraws = new CustomListLinky();
    
    
    
    
    public AccountMain(int accountNumber, String accountHolderName, String accountHolderAddress) {

        AccNumber = accountNumber;
        AccName = accountHolderName;
        AccAddress = accountHolderAddress;

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = myDateObj.format(myFormatObj);
        OpeningDate = formattedDate;
        currentBalance = 0.00;

    //    //fill list of transaction with "null"
    //    for (int i = 0; i <= 6; i++) {
    //        transactions.add(null);
    //        withdraws.add(null);
     //   }

    }

    public int getAccountNumber() {
        return AccNumber;
    }

    public String getAccountName() {
        return AccName;
    }

    public String getAccountAddress() {
        return AccAddress;
    }

    public String getAccountOpeningDate() {
        return OpeningDate;
    }

    public double getAcccountCurrentAccount() {
        return currentBalance;
    }

    public void setAccountName(String NewName) {
        AccName = NewName;
    }

    public void setAccountAddress(String NewAdress) {
        AccAddress = NewAdress;
    }

    public void printAllAccounts() {
        System.out.println("--------------------------------------");
        System.out.println("Account Number:" + AccNumber);
        System.out.println("Account Holders Name:" + AccName);
        System.out.println("Account Holders Address:" + AccAddress);
        System.out.println("Account Opening Date:" + OpeningDate);
        System.out.println("Account Current Balance:" + currentBalance);
        System.out.println("--------------------------------------");

    }
    
    //return print statement for pop ups
    //for when adding the new account for example
        public String printAllAccounts2() {
        return("--------------------------------------\n"
        +"Account Number:" + AccNumber + "\n"
        +"Account Holders Name:" + AccName + "\n"
        +"Account Holders Address:" + AccAddress + "\n"
        +"Account Opening Date:" + OpeningDate + "\n"
        +"Account Current Balance:" + currentBalance + "\n"
        +"--------------------------------------");

    }

    @Override
    public String toString() {

        return "--------------------------------------\n"
                + "Account Number:" + this.AccNumber + "\n"
                + "Account Holders Name:" + this.AccName + "\n"
                + "Account Holders Address:" + this.AccAddress + "\n"
                + "Account Opening Date:" + this.OpeningDate + "\n"
                + "Account Current Balance:" + this.currentBalance + "\n"
                + "--------------------------------------";

    }

}
