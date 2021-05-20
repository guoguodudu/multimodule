package com.fenyun.ws.manager.thead.Ser;

import lombok.Synchronized;

import java.util.List;
import java.util.Queue;

public class ServiceTread implements Runnable {

	Queue<String> queue;
	private int masx;

	ServiceTread(Queue<String> queue, int masx) {
		this.queue = queue;
		this.masx = masx;

	}

	@Override
	public void run() {

		int i=0;
		while(true){
			i++;
			synchronized (queue){ //同一把锁.
				if(queue.size()==masx){
					//如果生产满了
					try {
						queue.wait(); //一定会释放锁.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("生产者生产消息:"+i);
				queue.add("生产消息："+i);
				queue.notify(); //唤醒处于阻塞状态下的线程
				queue.notifyAll();
			}
		}
	}
}
