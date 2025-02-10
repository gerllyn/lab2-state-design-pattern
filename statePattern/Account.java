package statePattern;

public class Account {
    private AccountState accountState;
    private String accountNumber;
    private Double balance;

    public Account(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountState = new ActiveState(this);
    }

    public String getAccountNumber() { return accountNumber; }
    public Double getBalance() { return balance; }
    void setBalance(Double balance) { this.balance = balance; }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    public void deposit(Double amount) { accountState.deposit(amount); }
    public void withdraw(Double amount) { accountState.withdraw(amount); }
    public void suspend() { accountState.suspend(); }
    public void activate() { accountState.activate(); }
    public void closed() { accountState.closed(); }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + " | Balance: $" + balance;
    }
}
