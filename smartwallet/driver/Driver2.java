package smartwallet.driver;

import java.util.*;
import smartwallet.model.*;

/**
 * @author 12S24035 Josua Sianturi
 */
public class Driver2 {
    
    public static void main(String[] _args) {
        ArrayList<Account> accountArray = new ArrayList<>();
        ArrayList<Transaction> transactionArray = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();

            // Berhenti membaca input
            if (input.equals("---")) {
                break;
            }

            String[] tempCommand = input.split("#");
            
            if (tempCommand[0].equals("create-account")) {
                // Format: create-account#Owner#AccountName#Type
                String tempOwner = tempCommand[1];
                String tempAccountName = tempCommand[2];
                String tempType = tempCommand[3]; 

                // Membuat akun baru (Pastikan constructor Account sudah menerima tipe akun)
                Account account = new Account(tempOwner, tempAccountName, tempType);
                accountArray.add(account);
            
            } else if (tempCommand[0].equals("deposit")) {
                // Format: deposit#AccountName#Amount#PostedAt#Note
                String tempAccountName = tempCommand[1];
                double tempAmount = Double.parseDouble(tempCommand[2]);
                String tempPostedAt = tempCommand[3];
                String tempNote = tempCommand[4];

                for (Account account : accountArray) {
                    if (account.getAccountName().equals(tempAccountName)) {
                        // Idealnya, panggil method di model Account yang sudah memiliki
                        // kalkulasi penambahan saldo (dan bonus 1.5 jika ada).
                        // contoh: account.deposit(tempAmount);
                        
                        Transaction transaction = new Transaction(account, tempAmount, tempPostedAt, tempNote);
                        transactionArray.add(transaction);
                        break;
                    }                    
                }

            } else if (tempCommand[0].equals("withdraw")) {
                // Format: withdraw#AccountName#Amount#PostedAt#Note
                String tempAccountName = tempCommand[1];
                double tempAmount = Double.parseDouble(tempCommand[2]);
                String tempPostedAt = tempCommand[3];
                String tempNote = tempCommand[4];

                for (Account account : accountArray) {
                    if (account.getAccountName().equals(tempAccountName)) {
                        // Panggil method di model Account untuk mengurangi saldo
                        // contoh: account.withdraw(tempAmount);
                        
                        Transaction transaction = new Transaction(account, -tempAmount, tempPostedAt, tempNote);
                        transactionArray.add(transaction);
                        break;
                    }                    
                }
            }
        }

        // Menampilkan output (Kondisi akhir akun)
        for (Account account : accountArray) {
            System.out.println(account.toString());
        }

        scan.close();
    }
}