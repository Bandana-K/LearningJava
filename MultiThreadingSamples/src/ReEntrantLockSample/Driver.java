package ReEntrantLockSample;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

        final Bank bank = new Bank();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                	bank.transferFrom1to2();
                } catch (InterruptedException ignored) {}
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                	bank.transferFrom2to1();
                } catch (InterruptedException ignored) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        bank.finished();
	}

}
