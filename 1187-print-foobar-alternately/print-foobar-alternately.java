class FooBar {

    private ReentrantLock lock ;
    private Condition alter;
    private boolean isFoo;
    private int n;

    public FooBar(int n) {
        this.n = n;
        this.isFoo = false;
        this.lock = new ReentrantLock();
        this.alter = lock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {       
        
        for (int i = 0; i < n; i++) {
                lock.lock();
                while(isFoo){
                    alter.await();
                }
        	    // printFoo.run() outputs "foo". Do not change or remove this line.
        	    printFoo.run();
                isFoo = true;
                alter.signal();
                lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
                lock.lock();
                while(!isFoo){
                    alter.await();
                }
        	    // printBar.run() outputs "bar". Do not change or remove this line.
        	    printBar.run();
                isFoo = false;
                alter.signal();
                lock.unlock();
        }
    }
}