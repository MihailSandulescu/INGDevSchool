package com.ing.tech;

import java.util.Scanner;

public class ATM {
    private static ATM instance = null;
    private static BankDatabase usersDatabase;
    private static Account user;
    private static CashDispenser cashDispenser;

    private ATM() {
        usersDatabase = BankDatabase.getInstance();
        cashDispenser = CashDispenser.getInstance();
    }

    public static ATM getInstance(){
        if (instance == null)
            instance = new ATM();
        return instance;
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        String accNr, PIN;
        boolean flag = false;

        while (!flag) {
            System.out.print("Provide an account number: ");  accNr = sc.nextLine();
            System.out.print("Provide a PIN: "); PIN = sc.nextLine();
            user = new Account(accNr, PIN, Long.parseLong("0"));

            if (!checkLogin()) {
                System.out.println("Invalid data! Try again!");
            } else {
                flag = true;
            }
        }
        System.out.println("Login successful!");

        for (int i = 0; i < usersDatabase.bankAccounts.size(); i++) {
            if (usersDatabase.bankAccounts.get(i).equals(user)) {
                user.setBalance(usersDatabase.bankAccounts.get(i).getBalance());
                break;
            }
        }
    }

    private static boolean checkLogin(){
        for(int i = 0; i < usersDatabase.bankAccounts.size(); i++){
            if((usersDatabase.bankAccounts.get(i)).equals(user)){
                return true;
            }
        }
        return false;
    }

    public static void viewBalance(){
       try {
           System.out.println(user.getBalance());
       } catch(NullPointerException e){
           System.err.println("No user authenticated!");
       }
    }

    public static void deposit(long sum){
        try{
            user.setBalance(user.getBalance() + sum);
            for(int i = 0; i < usersDatabase.bankAccounts.size(); i++) {
                if (usersDatabase.bankAccounts.get(i).equals(user)) {
                    usersDatabase.bankAccounts.get(i).setBalance(user.getBalance() + sum);
                    break;
                }
            }
        }catch(NullPointerException e){
            System.err.println("No user authenticated!");
        }
    }

    public static void withdraw(long sum){

        if(sum > user.getBalance()) {
            System.out.println("Requested sum exceeds balance!");
        }else {
            if(sum > 200 || sum % 20 != 0){
                System.out.println("Invalid amount! Please select a number between 20$ and 200$, multiple of 20!");
            }else {
                if(cashDispenser.getNrOfBills() * 20 < sum){
                    System.out.println("Not enough bills in ATM!");
                } else {
                     try{
                        user.setBalance(user.getBalance() - sum);
                        for(int i = 0; i < usersDatabase.bankAccounts.size(); i++) {
                            if (usersDatabase.bankAccounts.get(i).equals(user)) {
                                usersDatabase.bankAccounts.get(i).setBalance(user.getBalance() - sum);
                                break;
                            }
                        }
                        cashDispenser.removeBills((int)(sum / 20));
                     }catch(NullPointerException e){
                        System.err.println("No user authenticated!");
                     }
                }
            }
        }
    }

    public static void exit(){
        user = null;
        System.out.println("Logout successful! Have a nice day!");
    }
}
