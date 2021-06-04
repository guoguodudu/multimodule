package com.fenyun.ws.manager.demo;

import com.google.common.base.Splitter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

import static java.lang.Thread.currentThread;

public class ceshi {

    private static volatile  int i=0;

    private static Lock lock=new ReentrantLock();

    private static CountDownLatch latch = new CountDownLatch(3);
    public static  void add(){
        lock.lock();
        i++;
        System.out.println(currentThread().getName() + " start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println(currentThread().getName() + " end");

        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 10000; j++) {
            new Thread(()->ceshi.add()).start();
        }
       // System.out.println(i);
        System.out.println(currentThread().getName() + " start");
        latch.await();
        System.out.println(currentThread().getName() + " end");

        System.out.println(i);
    }
}
