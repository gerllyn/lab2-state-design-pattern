package statePattern;

public class ClosedState implements AccountState {
    private Account account;

    public ClosedState(Account account) { this.account = account; }

    @Override
    public void deposit(Double amount) {
        System.out.println("You cannot deposit on a closed account! " + account.toString());
    }

    @Override
    public void withdraw(Double amount) {
        System.out.println("You cannot withdraw on a closed account! " + account.toString());
    }

    @Override
    public void suspend() {
        System.out.println("You cannot suspend a closed account!");
    }

    @Override
    public void activate() {
        System.out.println("You cannot activate a closed account!");
    }

    @Override
    public void closed() {
        System.out.println("Account is already closed!");
    }
}
