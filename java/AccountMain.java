/**
 *
 * @author ryansPC
 * Date : 31/12/2020
 */

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
    
    
    //Collections standard version-----------

    //create another list to then sort transactions (they need to be saved in order of placed)    
    //public LinkedList<Double> transactions = new LinkedList<Double>();
    //public LinkedList<Double> withdraws = new LinkedList<Double>();
    
    //create another list to then sort transactions (they need to be saved in order of placed)    
    //LinkedList<Double> sortedTransactions = new LinkedList<Double>();
    //LinkedList<Double> sortedWithdraws = new LinkedList<Double>();
    
    
    
    //Custom sorting and data structure version--------
    
    public CustomListLinky transactions = new CustomListLinky();
    public CustomListLinky withdraws = new CustomListLinky();
    
    public CustomListLinky sortedTransactions = new CustomListLinky();
    public CustomListLinky sortedWithdraws = new CustomListLinky();
    
    
    
    
    public AccountMain(int accountNumber, String accountHolderName, String accountHolderAddress) {
        
        //information from user
        AccNumber = accountNumber;
        AccName = accountHolderName;
        AccAddress = accountHolderAddress;
        
        //create date varible corrosponding to time and day the new AccountMain is made
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate = myDateObj.format(myFormatObj);
        OpeningDate = formattedDate;
        
        //all accounts start at 0 balance
        currentBalance = 0.00;

    }
    
    //self explanatory return functions-------
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
    //-------------------------------------------
    
    //set functions for changing of details --------
    public void setAccountName(String NewName) {
        AccName = NewName;
    }

    public void setAccountAddress(String NewAdress) {
        AccAddress = NewAdress;
    }
    
    //-----------------------------------------------
    
    
    //basic print all accounts for debugging
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
    //for all account use
    public String printAllAccounts2() {
        return("--------------------------------------\n"
        +"Account Number:" + AccNumber + "\n"
        +"Account Holders Name:" + AccName + "\n"
        +"Account Holders Address:" + AccAddress + "\n"
        +"Account Opening Date:" + OpeningDate + "\n"
        +"Account Current Balance:" + currentBalance + "\n"
        +"--------------------------------------");

    }
    
    //toString for returning full account infortmation
    //for this singular account
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
