class FizzBuzz {

    private ReentrantLock lock = new ReentrantLock();
    private Condition isAllowed = lock.newCondition();

    private int n;
    private int current;

    public FizzBuzz(int n) {
        this.n = n;
        this.current =1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try{
            while(current<=n){
                while(current<=n && !(current%3==0 && current%5!=0)){
                    isAllowed.await();
                }
                if(current>n) break;
                printFizz.run();
                current++;
                isAllowed.signalAll();
            }
        }finally{
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try{
             while(current<=n){
                while(current<=n && !(current%3!=0 && current%5==0)){
                    isAllowed.await();
                }
                if(current>n) break;
                printBuzz.run();
                current++;
                isAllowed.signalAll();
            }
        }finally{
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try{
             while(current<=n){
                while(current<=n && !(current%3==0 && current%5==0)){
                    isAllowed.await();
                }
                if(current>n) break;
                printFizzBuzz.run();
                current++;
                isAllowed.signalAll();
            }
        }finally{
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try{
             while(current<=n){
                while(current<=n && !(current%3!=0 && current%5!=0)){
                    isAllowed.await();
                }
                if(current>n) break;
                printNumber.accept(current);
                current++;
                isAllowed.signalAll();
            }
        }finally{
            lock.unlock();
        }
    }
}