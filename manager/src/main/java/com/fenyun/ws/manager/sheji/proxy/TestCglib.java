package com.fenyun.ws.manager.sheji.proxy;

import org.apache.tomcat.websocket.BackgroundProcessManager;

public class TestCglib {
	public static void main(String[] args) {
		BookFacadeImpl1 bookFacadeImpl1=new BookFacadeImpl1();

		BookFacadeCglib bookFacadeCglib=new BookFacadeCglib();
		BookFacadeImpl1 backgroundProcessManager=(BookFacadeImpl1) bookFacadeCglib.getInstance(bookFacadeImpl1);

		backgroundProcessManager.addBook();
		backgroundProcessManager.addBook33();
	}

}
