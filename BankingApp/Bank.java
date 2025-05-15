import java.io.*;
import java.util.*;

public class Bank {
    private List<Account> accounts;
    private final String DATA_FILE = "accounts.txt";

    public Bank() {
        accounts = new ArrayList<>();
        loadAccounts();
    }

    public void loadAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                accounts.add(new Account(data[0], data[1], Double.parseDouble(data[2])));
            }
        } catch (IOException e) {
            System.out.println("No data file found. Starting fresh.");
        }
    }

    public void saveAccounts() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE))) {
            for (Account acc : accounts) {
                pw.println(acc.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving account data.");
        }
    }

    public Account findAccount(String accNum) {
        for (Account acc : accounts) {
            if (accNum.equals(acc.getAccountNumber())) return acc;
        }
        return null;
    }

    public void createAccount(String accNum, String name, double balance) {
        accounts.add(new Account(accNum, name, balance));
        saveAccounts();
    }
}
