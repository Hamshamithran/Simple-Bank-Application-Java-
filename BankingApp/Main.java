import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Acc No: ");
                    String acc = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Initial Deposit: ");
                    double init = sc.nextDouble();
                    bank.createAccount(acc, name, init);
                    break;
                case 2:
                    System.out.print("Enter Acc No: ");
                    acc = sc.nextLine();
                    Account a = bank.findAccount(acc);
                    if (a != null) {
                        System.out.print("Amount to deposit: ");
                        a.deposit(sc.nextDouble());
                        bank.saveAccounts();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Acc No: ");
                    acc = sc.nextLine();
                    a = bank.findAccount(acc);
                    if (a != null) {
                        System.out.print("Amount to withdraw: ");
                        double amt = sc.nextDouble();
                        if (!a.withdraw(amt)) System.out.println("Insufficient balance.");
                        bank.saveAccounts();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Acc No: ");
                    acc = sc.nextLine();
                    a = bank.findAccount(acc);
                    if (a != null) System.out.println("Balance: " + a.getBalance());
                    else System.out.println("Account not found.");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
