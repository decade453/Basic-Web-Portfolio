// Programming Activity 4: Simple ATM Program with a Generated Receipt
// -------------------------------------------------------------------
// A simple ATM program with a generated receipt.
// -------------------------------------------------------------------
// John Jabez Capistrano
// BS-INFORMATION TECHNOLOGY 1D
// March 6, 2023


import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProgrammingActivity4 {
    
    // The program starts with an initial balance of P 10,000.00 and an empty transaction log. 
    // It presents the user with a menu of operations to choose from. 
    // The user can select Withdraw, Deposit, Check Balance, Print Receipt, or Exit.

    private static double balance = 10000.00;
    private static ArrayList<String> transactionLog = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

       

        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("Please select an operation:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Print Receipt");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:  // If the user selects Withdraw, the program prompts for the amount to withdraw. 
                         // If the amount is greater than the current balance, the program displays an error message. 
                         // Otherwise, the program subtracts the withdrawal amount from the balance, adds the transaction to the log, and displays a success message.

                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= withdrawAmount;
                        transactionLog.add(dateFormat.format(new Date()) + "\tWithdrawal\t\t" + decimalFormat.format(withdrawAmount) + "\t\t" + decimalFormat.format(balance));
                        System.out.println("Withdrawal successful.");
                    }
                    break;
                    
                case 2: // If the user selects Deposit, the program prompts for the amount to deposit. 
                        // The program adds the deposit amount to the balance, adds the transaction to the log, and displays a success message.`

                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    transactionLog.add(dateFormat.format(new Date()) + "\tDeposit\t\t" + decimalFormat.format(depositAmount) + "\t\t" + decimalFormat.format(balance));
                    System.out.println("Deposit successful.");
                    break;
                    
                case 3: // If the user selects Check Balance, the program displays the current balance.

                    System.out.println("Current balance: " + decimalFormat.format(balance));
                    break;
                    
                case 4: // If the user selects Print Receipt, the program writes the transaction log to a text file named receipt.txt in the current directory.

                    String filename = "AMBreceipt.txt";
                    try {
                        FileWriter writer = new FileWriter(filename);
                        writer.write("----------------------*ALIBABA MAURITUS BANK*------------------------\n");
                        writer.write("\n");
                        writer.write("--------------Brgy. Intampilan, Panitan, Capiz, Philippines----------\n");
                        writer.write("----------------------------ATM No.: 12------------------------------\n");
                        writer.write("\n");
                        writer.write("---------------------------------------------------------------------\n");
                        writer.write("\n");
                        writer.write("-----------------------*TRANSACTION HISTORY*-------------------------\n");
                        writer.write("\n");
                        writer.write("Date\t\t\t\tTransaction\t\tAmount\t\tBalance\n");
                        for (String transaction : transactionLog) {
                            writer.write(transaction + "\n");
                        }
                        writer.write("\n");
                        writer.write("---------------------------------------------------------------------\n");
                        writer.write("\n");
                        writer.write("-----------------****THANK YOU FOR USING OUR ATM****-----------------\n");
                        writer.write("\n");
                        writer.write("---------------------------------------------------------------------\n");
                        writer.write("\n");
                        writer.write("----------------------CALL US: (054) 8256-6159-----------------------\n");
                        writer.write("\n");
                        writer.close();
                        System.out.println("Receipt printed to " + filename);
                    } catch (IOException e) {
                        System.out.println("Failed to write receipt."); 
                    }
                    break;
                    
                case 5: // If the user selects Exit, the program exits the program.

                    System.out.println("Program Ended. Thank you for using the ATM! Goodbye!");
                    System.exit(0);
                    
                default: // If the user enters the incorrect choice, the program will show this error message

                    System.out.println("Invalid choice."); 
                    break;
            }
            
            System.out.println();
        }
    }
    
}
