class FizzBuzz {
    private int n;
    int number = 1;
    Object lock = new Object();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (number <= n) {
            synchronized (lock) {
                if (number % 3 != 0 || number % 5 == 0) {
                    lock.wait();
                    continue;
                }

                printFizz.run();
                number += 1;
                lock.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (number <= n) {
            synchronized (lock) {
                if (number % 5 != 0 || number % 3 == 0) {
                    lock.wait();
                    continue;
                }

                printBuzz.run();
                number += 1;
                lock.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (number <= n) {
            synchronized (lock) {
                if (number % 15 != 0) {
                    lock.wait();
                    continue;
                }

                printFizzBuzz.run();
                number += 1;
                lock.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (number <= n) {
            synchronized (lock) {
                if (number % 5 == 0 || number % 3 == 0) {
                    lock.wait();
                    continue;
                }

                printNumber.accept(number);
                number += 1;
                lock.notifyAll();
            }
        }
    }
}