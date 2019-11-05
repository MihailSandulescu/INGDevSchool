package com.ing.tech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class BankDatabase {

    private static BankDatabase instance = null;
    public ArrayList<Account> bankAccounts;

    private BankDatabase() throws Exception {
       bankAccounts = new ArrayList<Account>();
       String line;

       File f = new File("/home/mihai/devschool-12/course-2/src/BankDatabase.txt");
       BufferedReader br = new BufferedReader(new FileReader(f));

       while((line = br.readLine()) != null){
           String [] values = line.split(",");
           bankAccounts.add(new Account(values[0],values[1],Long.parseLong(values[2])));
       }
    }

    public static BankDatabase getInstance(){
        if (instance == null) {
            try {
                instance = new BankDatabase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    public void addUser(Account a){
        bankAccounts.add(a);
    }
}
