package org.example._1115.print.foobar.alternately;

class FooBar {
    private int n;
    private int counter;

    public FooBar(int n) {
        this.n = n;
        counter = 0;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while ((counter % 2) == 1)
                wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            counter++;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while ((counter % 2) == 0)
                wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            counter++;
            notifyAll();
        }
    }
}
