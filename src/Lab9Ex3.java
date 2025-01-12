public class Lab9Ex3 {
    public static void main(String[] args) {
        Account account = new Account("Jan Kowalski", 1000, "123-456-789");

        try {
            System.out.println("Attempting transfer...");
            account.transfer(1500);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Current balance: " + account.getBalance());
        }
    }
}

class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void transfer(int amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException("Insufficient funds to complete the transfer!");
        } else {
            balance -= amount;
            System.out.println("Transfer completed. New account balance: " + balance);
        }
    }
}


