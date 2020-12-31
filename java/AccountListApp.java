
/**
 *
 * @author ryansPC
 * Date : 31/12/2020
 */
import java.lang.StringBuilder;
import java.util.*;

public class AccountListApp {

    String statement;
    int counter;

    public static ArrayList<AccountMain> Accounts = new ArrayList<AccountMain>();

    public static void main(String[] args) {
        //used for debugging
    }

    //prints all Accounts
    //standard version for debugging
    public static void PrintAllAccounts() {
        Accounts.forEach(account -> {
            System.out.println(account.toString());
        });

    }

    //prints all Accounts
    //returns all accounts for Gui use
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

    //function to check if an account exsists in Accounts
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

    //return function for transaction in size order
    public static String printAllTransactions2(String accountnumber) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {

                //declare temporary var
                AccountMain currentAccount = Accounts.get(i);

                //Collections version
//                InsertionSortLinkedList blah = (createSortedList(currentAccount.transactions));
//                blah.printlist(blah.head);
//                
//                //copy list
//                currentAccount.sortedTransactions = (LinkedList) currentAccount.transactions.clone();
//
//                //sort new list 
//                Collections.sort(currentAccount.sortedTransactions);
//
//                //print out each transaction from the new sorted list
//                return statements(currentAccount.sortedTransactions);
//                currentAccount.transactions.createSortedList();

                //custom sorting alg version
                
                InsertionSortLinkedList newListy = currentAccount.transactions.createSortedList();
                newListy.insertionSort(newListy.head);

                return newListy.printlist(newListy.head);

            }
        }

        return null;
    }

    //print function for windraws in size order
    public static String printAllWithdraws2(String accountnumber) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {

                //declare temporary var
                AccountMain currentAccount = Accounts.get(i);

                //Collections sorting version
//                //copy list
//                currentAccount.sortedWithdraws = (LinkedList) currentAccount.withdraws.clone();
//
//                //sort new list 
//                Collections.sort(currentAccount.sortedWithdraws);
//
//                //print out each transaction from the new sorted list
//                return statements(currentAccount.sortedWithdraws);
//                
//                
                //custom sorting alg version
                InsertionSortLinkedList newListyWithdraws = currentAccount.withdraws.createSortedList();
                newListyWithdraws.insertionSort(newListyWithdraws.head);

                return newListyWithdraws.printlist(newListyWithdraws.head);

            }
        }

        return null;

    }

    //function to add a transaction to transactions rotating old out and new items
    //to the end of the 6 length lists
    public static void addTransaction(String accountnumber, double newTransaction) {
        for (int i = 0; i < Accounts.size(); i++) {
            if ((String.valueOf(Accounts.get(i).getAccountNumber())).equals(accountnumber)) {

                //declare temporary var
                AccountMain currentAccount = Accounts.get(i);

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
