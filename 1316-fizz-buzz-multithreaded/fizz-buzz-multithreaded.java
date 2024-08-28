class FizzBuzz {
    private int n;
    private int cur;

    public FizzBuzz(int n) {
        this.n = n;
        this.cur = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        
        synchronized (this) {
            while(cur<=n){
                if(cur%3==0 && cur%5!=0){
                    printFizz.run();
                    cur++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while(cur<=n){
                if(cur%3!=0 && cur%5==0){
                    printBuzz.run();
                    cur++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        
        synchronized (this) {
            while(cur<=n){
                if(cur%3==0 && cur%5==0){
                    printFizzBuzz.run();
                    cur++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while(cur<=n){
                if(cur%3!=0 && cur%5!=0){
                    printNumber.accept(cur);
                    cur++;
                    notifyAll();
                }else{
                    wait();
                }
            }
        }
    }
}