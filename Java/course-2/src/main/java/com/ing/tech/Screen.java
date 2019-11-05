package com.ing.tech;

import java.util.Scanner;

public class Screen {

    private static Scanner sc = new Scanner(System.in);
    private static ATM machine = ATM.getInstance();
    private BankDatabase bd;
    private static char handle;
    private static long sum;

    public static void start(){

        System.out.println("Welcome to the ATM!");
        System.out.println("Please enter your credentials.");
        System.out.println("");
        machine.login();

        do{
            System.out.println("");
            System.out.println("Select an operation by entering the indicated character: ");
            System.out.println("b: View balance");
            System.out.println("d: Deposit");
            System.out.println("w: Withdraw");
            System.out.println("e: Exit");
            System.out.println("");
            System.out.print("Your selection: ");
            handle = sc.next().charAt(0);

            switch (handle) {
                case 'b':
                    machine.viewBalance();
                    break;
                case 'd':
                    System.out.print("Enter sum to be deposited: ");
                    sum = sc.nextLong();
                    machine.deposit(sum);
                    break;
                case 'w':
                    System.out.print("Enter sum to be withdrawn: ");
                    sum = sc.nextLong();
                    machine.withdraw(sum);
                    break;
                case 'e':
                    machine.exit();
                    break;
                default:
                    System.out.println("Invalid input! Please try again!");
            }

        }while(handle != 'e');
    }

}
