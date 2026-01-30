class ZeroEvenOdd {
    private int n;
    private int state;
    private int num;
    Object lock = new Object();
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.state = 0;
        this.num = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(num <= n){
            synchronized(lock){
                if(state != 0){
                    lock.wait();
                    continue;
                }
                printNumber.accept(0);
                state = num % 2 == 0 ? 1 : 2;
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(num <= n){
            synchronized(lock){
                if(state != 1){
                    lock.wait();
                    continue;
                }
                printNumber.accept(num);
                num += 1;
                state = 0;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(num <= n){
            synchronized(lock){
                if(state != 2){
                    lock.wait();
                    continue;
                }
                printNumber.accept(num);
                num += 1;
                state = 0;
                lock.notifyAll();
            }
        }
    }
}