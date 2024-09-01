import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition printNumberCondition = lock.newCondition();
    private final Condition printBuzzCondition = lock.newCondition();
    private final Condition printFizzCondition = lock.newCondition();
    private final Condition printFizzBuzzCondition = lock.newCondition();

    private int n;
    private int current;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {
            while (current <= n) {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    printFizzCondition.await();
                }
                if (current > n) break;
                System.out.println(current);
                printFizz.run();
                current++;
                signalDecision();
            }
            signalAll();
        } finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (current <= n) {
                while (current <= n && !(current % 3 != 0 && current % 5 == 0)) {
                    printBuzzCondition.await();
                }
                if (current > n) break;
                System.out.println(current);
                printBuzz.run();
                current++;
                signalDecision();
            }
            signalAll();
        } finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (current <= n) {
                while (current <= n && !(current % 3 == 0 && current % 5 == 0)) {
                    printFizzBuzzCondition.await();
                }
                if (current > n) break;
                System.out.println(current);
                printFizzBuzz.run();
                current++;
                signalDecision();
            }
            signalAll();
        } finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (current <= n) {
                while (current <= n && !(current % 3 != 0 && current % 5 != 0)) {
                    printNumberCondition.await();
                }
                if (current > n) break;
                System.out.println(current);
                printNumber.accept(current);
                current++;
                signalDecision();
            }
            signalAll();
        } finally {
            lock.unlock();
        }
    }
    private void signalAll() {
        printFizzBuzzCondition.signal();
        printFizzCondition.signal();
        printBuzzCondition.signal();
        printNumberCondition.signal();
    }

    private void signalDecision() {
        if (current % 3 == 0 && current % 5 == 0) {
            printFizzBuzzCondition.signal();
        } else if (current % 3 == 0) {
            printFizzCondition.signal();
        } else if (current % 5 == 0) {
            printBuzzCondition.signal();
        } else {
            printNumberCondition.signal();
        }
    }
}
