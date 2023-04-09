package os.concepts.java.thread;

public class ThreadExample {
    public class TestThread implements Runnable {
        int sequence;

        public TestThread(int sequence) {
            this.sequence = sequence;
        }

        @Override
        public void run() {
            System.out.println(this.sequence + " thread start");

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }

            System.out.println(this.sequence + " thread end.");
        }
    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new TestThread(i));
            t.start();
        }

        System.out.println("--- main method ends ---");
    }
}
