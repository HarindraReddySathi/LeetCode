class H2O {
    ReentrantLock lock;
    Condition h;
    Condition o;
    int hydrogen;
    int oxygen;


    public H2O() {
        lock = new ReentrantLock();
        h = lock.newCondition();
        o = lock.newCondition();
        hydrogen = 0;
        oxygen = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();

        try {
            while (oxygen == 0 && hydrogen == 2) {
                h.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            hydrogen++;
            releaseHydrogen.run();
            
            if (hydrogen == 2 && oxygen == 1) {
                hydrogen = 0;
                oxygen = 0;
                o.signal();
                h.signal();
            }
            
        } finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();

        try {
            while (oxygen == 1 && hydrogen < 2) {
                o.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            oxygen++;
            releaseOxygen.run();
            
            if (hydrogen == 2 && oxygen == 1) {
                hydrogen = 0;
                oxygen = 0;
                h.signal();
                o.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}