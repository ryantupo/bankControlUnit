/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryansPC
 */
import java.lang.StringBuilder;
import java.util.*;

public class AccountListApp {

    String statement;
    int counter;

    public static ArrayList<AccountMain> Accounts = new ArrayList<AccountMain>();

    public static void main(String[] args) {

        AccountMain blahblah = new AccountMain(21383713, "Ryan Tuplin", "blah blah first lane 8653");
        AccountMain blahblah2 = new AccountMain(21383714, "Ryan Tuplin", "blah blah first lane 8653");
        Accounts.add(blahblah);
        Accounts.add(blahblah2);
        PrintAllAccounts();
        closeAccount("21383714");
        PrintAllAccounts();

        
        addTransaction("21383713", 52222.99);
        addTransaction("21383713", 55.99);
        addTransaction("21383713", 533.99);

        //blahblah.printAllTransactions();
        addTransaction("21383713", -55.09);
        System.out.println(printAllTransactions2("21383713"));
        //System.out.println(printAllWithdraws2("21383713"));
    }

    //prints all Accounts
    public static void PrintAllAccounts() {
        Accounts.forEach(account -> {
            System.out.println(account.toString());
        });

    }

    //prints all Accounts
    public static String PrintAllAccounts2() {
        StringBuilder FullAccountList = new StringBuilder("");

        Accounts.forEach(account -> {
            FullAccountList.append(account.toString() + "\n");
        });
        return FullAccountList.toString();
    }

    //delete an account from Accounts
    public static void closeAccount(String accountnumber) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {
                Accounts.remove(i);
                break;
            }
        }

    }

    public static boolean checkAccount(String accountnumber) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    //original print all transaction function
//    //print function for transaction in size order
//    public static void printAllTransactions(String accountnumber) {
//        for (int i = 0; i < Accounts.size(); i++) {
//            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {
//
//                //declare temporary var
//                AccountMain currentAccount = Accounts.get(i);
//
//                //copy list
//                currentAccount.sortedTransactions = (LinkedList) currentAccount.transactions.clone();
//
//                //sort new list 
//                Collections.sort(currentAccount.sortedTransactions);
//
//                //print out each transaction from the new sorted list
//                currentAccount.sortedTransactions.forEach(_item -> {
//
//                    System.out.println(_item);
//
//                });
//            }
//        }
//    }
//    
//        //print function for windraws in size order
//    public static void printAllWithdraws(String accountnumber) {
//        for (int i = 0; i < Accounts.size(); i++) {
//            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {
//
//                //declare temporary var
//                AccountMain currentAccount = Accounts.get(i);
//
//                //copy list
//                currentAccount.sortedWithdraws = (LinkedList) currentAccount.withdraws.clone();
//
//                //sort new list 
//                Collections.sort(currentAccount.sortedWithdraws);
//
//                //print out each transaction from the new sorted list
//                currentAccount.sortedWithdraws.forEach(_item -> {
//                    System.out.println(_item);
//                });
//            }
//
//        }
//
//    }
    //print function for transaction in size order
    public static String printAllTransactions2(String accountnumber) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {

                //declare temporary var
                AccountMain currentAccount = Accounts.get(i);
                
                
//                InsertionSortLinkedList blah = (createSortedList(currentAccount.transactions));
//                blah.printlist(blah.head);
//                
//                
//                //copy list
//                currentAccount.sortedTransactions = (LinkedList) currentAccount.transactions.clone();
//
//                //sort new list 
//                Collections.sort(currentAccount.sortedTransactions);
//
//                //print out each transaction from the new sorted list
//                return statements(currentAccount.sortedTransactions);

                   
                //currentAccount.transactions.createSortedList();

                InsertionSortLinkedList newListy = currentAccount.transactions.createSortedList();
                newListy.insertionSort(newListy.head);
                
                newListy.printlist(newListy.head);



            }
        }

        return null;
    }

    public static String statements(LinkedList<Double> sortedTrans) {
        int counter = 1;

        String statement = "";

        for (Double trans : sortedTrans) {
            statement += String.valueOf(counter) + ": £";
            statement += trans + "\n";
            counter += 1;
        }

        return statement;
    }

//    //print function for windraws in size order
//    public static String printAllWithdraws2(String accountnumber) {
//        for (int i = 0; i < Accounts.size(); i++) {
//            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {
//
//                //declare temporary var
//                AccountMain currentAccount = Accounts.get(i);
//
//                //copy list
//                currentAccount.sortedWithdraws = (LinkedList) currentAccount.withdraws.clone();
//
//                //sort new list 
//                Collections.sort(currentAccount.sortedWithdraws);
//
//                //print out each transaction from the new sorted list
//                return statements(currentAccount.sortedWithdraws);
//            }
//        }
//
//        return null;
//
//    }

    public static void addTransaction(String accountnumber, double newTransaction) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {

                //declare temporary var
                AccountMain currentAccount = Accounts.get(i);

                //LocalDateTime myDateObj = LocalDateTime.now();
                //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                //formattedDate = myDateObj.format(myFormatObj);
                //StringBuilder str = new StringBuilder();
                //str.append(newTransaction);
                //str.append(" ");
                //str.append(formattedDate);
                if (newTransaction > 0) {
                    if (currentAccount.transactions.size() >= 6) {
                        //adds new transaction to balance
                        currentAccount.currentBalance += newTransaction;
                        currentAccount.transactions.removeFirst();
                        currentAccount.transactions.addLast(newTransaction);
                    } else {
                        currentAccount.currentBalance += newTransaction;
                        currentAccount.transactions.addLast(newTransaction);
                    }
                } else if (newTransaction <= 0) {
                    //adds new traction to withdraws
                    if (currentAccount.withdraws.size() >= 6) {

                        currentAccount.currentBalance -= newTransaction;
                        currentAccount.withdraws.removeFirst();
                        currentAccount.withdraws.addLast(newTransaction);

                    } else {
                        currentAccount.currentBalance -= newTransaction;
                        currentAccount.withdraws.addLast(newTransaction);
                    }
                }
            }
        }
    }

}
