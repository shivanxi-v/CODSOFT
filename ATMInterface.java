import java.util.*;

class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        balance = initialBalance;
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && balance >= amount) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public boolean deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            return true;
        }
        return false;
    }

    public double checkBalance() 
    {
        return balance;
    }
}

public class ATMInterface 
{
    private BankAccount account;

    public ATMInterface(BankAccount account) 
    {
        this.account = account;
    }

    public void displayMenu() 
    {
        System.out.println();    
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println();    
    }

    public void run() 
    {
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            displayMenu();
            System.out.print("Enter your choice: ");
            System.out.println();    
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    System.out.println();    
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) 
                    {
                        System.out.println("Withdrew Rs. " + withdrawAmount);
                    } 
                    else 
                    {
                        System.out.println("Withdrawal failed!! "
                        		+ "Insufficient balance or invalid amount");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    System.out.println();    
                    double depositAmount = scanner.nextDouble();
                    if (account.deposit(depositAmount)) 
                    {
                        System.out.println("Deposited Rs. " + depositAmount);
                    } 
                    else 
                    {
                        System.out.println("Deposit failed!! Invalid amount");
                    }
                    break;
                    
                case 3:
                    double balance = account.checkBalance();
                    System.out.println("Your account balance is Rs. " + balance);
                    break;
                    
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. "
                    		+ "Please select a valid option.");
                    break;
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial account balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATMInterface atm = new ATMInterface(userAccount);
        atm.run();
    }
}
