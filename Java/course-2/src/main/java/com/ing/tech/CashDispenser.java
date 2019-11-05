package com.ing.tech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CashDispenser {
    public static CashDispenser instance = null;
    private static int nrOfBills;

    private CashDispenser() throws Exception{
        File f = new File("/home/mihai/devschool-12/course-2/src/CashDispenser.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));

        nrOfBills = br.read();

    }

    public static CashDispenser getInstance() {
        if(instance == null){
            try {
                instance = new CashDispenser();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static int getNrOfBills() {
        return nrOfBills;
    }

    public static void removeBills(int nr) {
        CashDispenser.nrOfBills -= nr;
    }
}
