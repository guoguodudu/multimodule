package com.fenyun.ws.manager.demo.test;

import java.security.SecureRandom;

public class Top1000 {
	public static int N = 10; //Top1000

	public static int LEN = 100; //1亿个整数

	public static int arrs[] = new int[LEN];

	public static int result[] = new int[N]; //在内存维护一个长度为N的小顶堆

	public static int len = result.length;

	//堆中元素的有效元素 heapSize<=len
	public static int heapSize = len;

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		//生成随机数组
		for (int i = 0; i < LEN; i++) {
			arrs[i] = random.nextInt(40);
		}

		//构建初始堆
		for (int i = 0; i < N; i++) {
			result[i] = arrs[i];
		}
		print();
		//构建小顶堆
		long start = System.currentTimeMillis();

		buildMinHeap();
		print();
		for (int i = N; i < LEN; i++) {
			if (arrs[i] > result[0]) {
				result[0] = arrs[i];
				minHeap(0);
			}
		}
		System.out.println(LEN + "个数，求Top" + N + "，耗时" + (System.currentTimeMillis() - start) + "毫秒");
		print();
	}

	/**
	 * 自底向上构建小堆
	 */
	public static void buildMinHeap() {
		int size = len / 2 - 1; //最后一个非叶子节点
		for (int i = size; i >= 0; i--) {
			minHeap(i);
		}
	}

	/**
	 * i节点为根及子树是一个小堆
	 *
	 * @param i
	 */
	public static void minHeap(int i) {
		int l = left(i);
		int r = right(i);
		int index = i;
		if (l < heapSize && result[l] < result[index]) {
			index = l;
		}

		if (r < heapSize && result[r] < result[index]) {
			index = r;
		}

		if (index != i) {
			int t = result[index];
			result[index] = result[i];
			result[i] = t;
			//递归向下构建堆
			minHeap(index);
		}
	}

	public static int getlen() {
		return len;
	}

	/**
	 * 返回i节点的左孩子
	 *
	 * @param i
	 * @return
	 */
	public static int left(int i) {
		return 2 * i;
	}

	/**
	 * 返回i节点的右孩子
	 *
	 * @param i
	 * @return
	 */
	public static int right(int i) {
		return 2 * i + 1;
	}

	/**
	 * 打印
	 */
	public static void print() {
		for (int a : result) {
			System.out.print(a + ",");
		}
		System.out.println();
	}
}
