package org.example._1114.print.in.order;

class Foo {
    private boolean firstRan;
    private boolean secondRan;

    public Foo() {
        firstRan = false;
        secondRan = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        notifyAll();
        firstRan = true;
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (!firstRan)
            wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondRan = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (!secondRan)
            wait();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
