package statePattern;

public class ActiveState implements AccountState {
    private Account account;

    public ActiveState(Account account) { this.account = account; }

    @Override
    public void deposit(Double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposited $" + amount + ". " + account.toString());
    }

    @Override
    public void withdraw(Double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdrew $" + amount + ". " + account.toString());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public void suspend() {
        account.setAccountState(new SuspendedState(account));
        System.out.println("Account is suspended!");
    }

    @Override
    public void activate() {
        System.out.println("Account is already activated!");
    }

    @Override
    public void closed() {
        if (account.getBalance() == 0) {
            account.setAccountState(new ClosedState(account));
            System.out.println("Account is closed!");
        } else {
            System.out.println("Cannot close account with non-zero balance.");
        }
    }
}
