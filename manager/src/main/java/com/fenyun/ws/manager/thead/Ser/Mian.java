package com.fenyun.ws.manager.thead.Ser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Mian {


	public static void main(String[] args) {
		Queue<String> queue=new LinkedList<>();
		int max=8;

		ClientTread s=new ClientTread(queue,max);

		new Thread(s).start();


		ServiceTread s2=new ServiceTread(queue,max);
		new Thread(s2).start();
	}
}
