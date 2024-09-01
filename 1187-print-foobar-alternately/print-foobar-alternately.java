class FooBar {

    private boolean isFoo;
    private int n;

    public FooBar(int n) {
        this.n = n;
        this.isFoo = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {       
        
        for (int i = 0; i < n; i++) {

            synchronized(this){
                 while(isFoo){
                    wait();
                }
        	    // printFoo.run() outputs "foo". Do not change or remove this line.
        	    printFoo.run();
                isFoo = true;
                notify();
            }
               
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
             synchronized(this){
                while(!isFoo){
                    wait();
                }
        	    // printBar.run() outputs "bar". Do not change or remove this line.
        	    printBar.run();
                isFoo = false;
                notify();
             }
        }
    }
}