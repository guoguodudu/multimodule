package com.fenyun.ws.manager;

public class ExcelDome {

		public static void main(String[] args)throws InterruptedException {

			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("i am1 " + Thread.currentThread());
				}
			});

			t.start();
        t.join();
			System.out.println("i am " + Thread.currentThread());
		}

}
