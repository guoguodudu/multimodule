package com.fenyun.ws.manager.thead.Executor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.concurrent.*;

@Repository
@Scope("singleton")
public class ThreadPoolDynamicTasks extends Thread {

    private  BlockingQueue<Runnable> bq = new LinkedBlockingQueue<>();// 可将此队列注入到客户端的子模块中
    private ExecutorService es = new ThreadPoolExecutor(2, 3, 0, TimeUnit.SECONDS, bq);

    ThreadPoolDynamicTasks(){

        init();// 阻塞队列中添加任务
        start();
    }
    private void init() {
        try {
            bq.put(new Runnable() {

                @Override
                public void run() {
                        while (true) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("添加的任务");
                        }

                }
            });
            bq.put(new Runnable() {

                @Override
                public void run() {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("AAAAAA");

                }
            });
            bq.put(new Runnable() {

                @Override
                public void run() {

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("AAAAAA-----------");

                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolDynamicTasks instance = new ThreadPoolDynamicTasks();
        instance.init();// 阻塞队列中添加任务
        instance.start();// 利用线程循环遍历阻塞队列，每执行一个任务就移除一个任务
        instance.getTaskLengSize();// 获取阻塞队列里的任务数量
        try {
            Thread.sleep(3000);
            //instance.addTask();// 在main线程中中途添加阻塞队列
            instance.getTaskLengSize();// 获取阻塞队列里的任务数量
            Thread.sleep(1000);
            instance.getTaskLengSize();// 获取阻塞队列的任务数量
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            for (Runnable runnable : bq) {
                // try {
                // bq.take();
                // } catch (InterruptedException e) {
                // e.printStackTrace();
                // }
                es.execute(runnable);
                bq.remove(runnable);
            }
        }
    }

    public  void addTask(int i) {
        try {

                bq.put(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第" + i + "个线程" + Thread.currentThread().getName());
                        System.out.println("~~~~~~~~~~~" + i);

                    }
                });

            // es.execute(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getTaskLengSize() {
        System.out.println(bq.size());
    }

}