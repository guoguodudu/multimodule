package com.fenyun.ws.manager.thead.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);
    Semaphore bar = new Semaphore(0);

    private BlockingQueue<Integer> bar1 = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> foo2 = new LinkedBlockingQueue<>(1);


    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo2.put(i);
            printFoo.run();
            bar1.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo2.take();
            printBar.run();
            bar1.take();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar=new FooBar(4);
        Runnable runnable1=()->{
            System.out.println("1");
        };

        Runnable runnable2=()->{
            System.out.println("2");
        };
        Runnable runnable3=()->{
            try {
                fooBar.foo(runnable1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnable4=()->{
            try {
                fooBar.bar(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread=new Thread(runnable3);

        Thread thread2=new Thread(runnable4);

        thread.start();
        thread2.start();


    }
}
