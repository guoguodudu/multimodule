package com.fenyun.ws.manager.thead.Ser;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

class FooBar {

	private int n;
	private BlockingQueue<Integer> zero = new LinkedBlockingQueue<>(1);
	private BlockingQueue<Integer> one = new LinkedBlockingQueue<>(1);

	private BlockingQueue<Integer> two = new LinkedBlockingQueue<>(1);
	public FooBar(int n) {
		this.n = n;
	}
	public void foo(IntConsumer  printFoo) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			zero.put(i);
			printFoo.accept(0);
			if(i%2==1)
			{
				one.put(1);
			}else {
				two.put(1);
			}

		}
	}

	public void bar(IntConsumer printBar) throws InterruptedException {
		for (int i = 1; i < n; i=i+2) {
			one.take();
			printBar.accept(i);
			zero.take();

		}
	}

	public void barO(IntConsumer  printBar) throws InterruptedException {
		for (int i = 2; i < n; i=i+2) {
			two.take();
			printBar.accept(i);
			zero.take();
		}
	}



	public static void main(String[] args) {
		FooBar fooBar = new FooBar(10);


		new Thread(()->{

			try {
				fooBar.bar(System.out::println);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		},"zero").start();



		new Thread(()->{

			try {
				fooBar.foo(System.out::println);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		},"one").start();


		new Thread(()->{

			try {
				fooBar.barO(System.out::println);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		},"one").start();

//		ExecutorService service = Executors.newFixedThreadPool(2);
//		service.submit(() ->{
//			try {
//				fooBar.foo(()->{
//					System.out.println("foo");
//				});
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		});
//		service.submit(() ->{
//			try {
//				fooBar.bar(()->{
//					System.out.println("bar");
//				});
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		});
		;
		//service.isShutdown();
	}
}
