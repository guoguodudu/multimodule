package com.fenyun.ws.manager.thead.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MyThreadPool
 * @Description: TODO
 * @Author 25216
 * @Date 2020/5/26
 * @Version V1.0
 **/
public class MyThreadPool {

    private ExecutorService exe;
    private static final int POOL_SIZE = 4;

    public MyThreadPool() {
        exe = Executors.newFixedThreadPool(POOL_SIZE);
    }

    public void doTask() {
        int i = 0;
        while (i < 50) {
            exe.execute(new MyThread(i, exe));
            i++;
        }
    }

    class MyThread implements Runnable
    {
        int id;
        ExecutorService exe;
        MyThread(int id, ExecutorService exe) {
            this.exe = exe;
            this.id = id;
        }
        public void run() {
            System.out.println(id + "start");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(id + "pass 5 second");
            System.out.println("exe info:" + exe.toString());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(id + "end");
        }
    }

    public static void main(String[] args) {
        new MyThreadPool().doTask();
    }
}