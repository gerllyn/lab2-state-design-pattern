package statePattern;

public interface AccountState {
    void deposit(Double amount);
    void withdraw(Double amount);
    void suspend();
    void activate();
    void closed(); 
}
