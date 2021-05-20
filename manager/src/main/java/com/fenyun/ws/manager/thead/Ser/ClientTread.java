package com.fenyun.ws.manager.thead.Ser;

import java.util.Queue;

public class ClientTread implements Runnable {

	Queue<String> queue;
	private int masx;

	public ClientTread(Queue<String> queue, int masx) {
		this.queue = queue;
		this.masx = masx;
	}

	@Override
	public void run() {
		while(true){
			synchronized (queue){
				if(queue.isEmpty()){
					//如果消息队列为空了
					try {
						queue.wait(); //阻塞当前线程
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("消费者消费消息："+queue.remove());
				queue.notify(); //唤醒处于阻塞状态下的生产者
			}
		}
	}
}
