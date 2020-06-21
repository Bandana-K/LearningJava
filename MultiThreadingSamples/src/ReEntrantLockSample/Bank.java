package ReEntrantLockSample;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	
	   private Account acc1 = new Account();
	    private Account acc2 = new Account();
	    private Lock lock1 = new ReentrantLock();
	    private Lock lock2 = new ReentrantLock();

	    //don't hold several locks at once. 
	    //If you do, always acquire the locks in the same order, try to get the both locks
	    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
	        while (true) {
	            // Acquire locks
	            boolean gotFirstLock = false;
	            boolean gotSecondLock = false;
	            try {
	                /**
	                 * tryLock() which will only acquire a lock if it’s available
	                 * and not already acquired by another thread and tryLock(long
	                 * time,TimeUnit unit), which will try to acquire a lock and, if
	                 * it's unavailable wait for the specified timer to expire
	                 * before giving up
	                 */
	                gotFirstLock = firstLock.tryLock();
	                gotSecondLock = secondLock.tryLock();
	            } finally {
	                if (gotFirstLock && gotSecondLock) return;
	                else if (gotFirstLock) firstLock.unlock();
	                else if (gotSecondLock) secondLock.unlock();
	            }
	            // Locks not acquired
	            Thread.sleep(1);
	        }
	    }

	    //firstThread runs
	    public void transferFrom1to2() throws InterruptedException {
	        Random random = new Random();
	        for (int i = 0; i < 10000; i++) {
	            acquireLocks(lock1, lock2);
	            try {
	                Account.transfer(acc1, acc2, random.nextInt(100));
	            } finally {
	                lock1.unlock();
	                lock2.unlock();
	            }
	        }
	    }

	    //SecondThread runs
	    public void transferFrom2to1() throws InterruptedException {
	        Random random = new Random();
	        for (int i = 0; i < 10000; i++) {
	            acquireLocks(lock2, lock1);
	            try {
	                Account.transfer(acc2, acc1, random.nextInt(100));
	            } finally {
	                lock1.unlock();
	                lock2.unlock();
	            }
	        }
	    }

	    //When both threads finish execution, finished runs
	    public void finished() {
	        System.out.println("Account 1 balance: " + acc1.getBalance());
	        System.out.println("Account 2 balance: " + acc2.getBalance());
	        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	    }

}
