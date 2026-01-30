class Foo {
    int num;
    Object lock = new Object();
    public Foo() {
        num = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        while(num < 4){
            synchronized(lock){
                if(num < 1 || num > 1){
                    lock.wait();
                    continue;
                }
                printFirst.run();
                num += 1;
                lock.notifyAll();
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(num < 4){
            synchronized(lock){
                if(num < 2 || num > 2){
                    lock.wait();
                    continue;
                }
                printSecond.run();
                num += 1;
                lock.notifyAll();
            }
        }
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(num < 4){
            synchronized(lock){
                if(num < 3 || num > 3){
                    lock.wait();
                    continue;
                }
                printThird.run();
                num += 1;
                lock.notifyAll();
            }
        }
        
    }
}