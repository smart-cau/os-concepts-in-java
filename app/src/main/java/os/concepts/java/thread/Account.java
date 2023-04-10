package os.concepts.java.thread;

public class Account {
    private int balance;

    public Account() {
        this.balance = 1000;
    }

    public synchronized void withdraw(int amount) {
        if (this.balance < amount ) {
            System.out.println(Thread.currentThread().getId() + " Balance is not enough!");
            return;
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.balance -= amount;
        System.out.println(Thread.currentThread().getId() + " withdraw " + amount + ". Balance left: " + balance);
    }

    
}
