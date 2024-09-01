class Foo {

    private ReentrantLock lock ;
    private Condition isFirstDone;
    private Condition isSecondDone;

    private boolean firstDone;
    private boolean secondDone;

    public Foo() {
        this.lock = new ReentrantLock();
        this.isFirstDone = lock.newCondition();
        this.isSecondDone = lock.newCondition();
        this.firstDone=false;
        this.secondDone=false;
    }

    // printFirst.run() outputs "first". Do not change or remove this line.
    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            printFirst.run();
            firstDone = true;
            isFirstDone.signalAll();
        }finally{
            lock.unlock();
        }
        
    }

    // printSecond.run() outputs "second". Do not change or remove this line.
    public void second(Runnable printSecond) throws InterruptedException {
        
         lock.lock();
        try{
            while(!firstDone){
                isFirstDone.await();
            }
            printSecond.run();
            secondDone = true;
            isSecondDone.signalAll();
        }finally{
            lock.unlock();
        }
        
    }

    // printThird.run() outputs "third". Do not change or remove this line.
    public void third(Runnable printThird) throws InterruptedException {
        
        lock.lock();
        try{
            while(!secondDone){
                isSecondDone.await();
            }
            printThird.run();
        }finally{
            lock.unlock();
        }
        
        
    }
}