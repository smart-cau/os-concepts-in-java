package os.concepts.java.thread;

import java.util.ArrayList;

public class ThreadExample {
    public class TestThread implements Runnable {
        int amount;
        Account account;

        public TestThread(Account account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            long threadId = Thread.currentThread().getId();
            System.out.println(String.format("thread id %d start", threadId));

            /*try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            } */
            account.withdraw(this.amount);

            System.out.println(String.format("thread id %d end", threadId));
        }
    }

    public void start() {
        long processId = ProcessHandle.current().pid();
        System.out.println("--- Process Id: " + processId);
        ArrayList<Thread> threads = new ArrayList<>();
        Account account = new Account();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new TestThread(account, 100));
            t.start();
            threads.add(t);
        }

        for (int index = 0; index < threads.size(); index++) {
            Thread t = threads.get(index);
            try {
                t.join(); // t thread가 종료할 때까지 대기
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        System.out.println("--- start method ends ---");
    }
}
