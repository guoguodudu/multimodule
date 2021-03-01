package com.fenyun.ws.manager.thead.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo implements Runnable{



    private static  Object l=new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread=new Thread(new Demo());
        thread.start();
        Thread.sleep(8000L);
        synchronized (l) {
            l.notifyAll();
        }
        Thread.sleep(8000L);

        System.out.println("123");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("456");

    }
}
