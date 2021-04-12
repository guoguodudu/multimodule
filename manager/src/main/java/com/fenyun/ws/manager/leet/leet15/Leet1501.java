package com.fenyun.ws.manager.leet.leet15;

public class Leet1501 {

	public static boolean reverse(int[][] t) {

		for (int i = 0; i < 5; i++) {
			boolean flag1 = true; // true 就是有解 横行校验
			boolean flag2 = true; // true 就是有解 竖行校验
			for (int j = 0; j < 5; j++) {
				if (t[i][j] == 0) {
					flag1 = false;
				}if (t[j][i] == 0) {
					flag2 = false;
				}

			}
			if (flag1) {
				return true;
			}if (flag2) {
				return true;
			}

		}

		if(t[0][0]==1&&t[1][1]==1&&t[2][2]==1&&t[3][3]==1&&t[4][4]==1)return true;

		if(t[0][4]==1&&t[1][3]==1&&t[2][2]==1&&t[3][1]==1&&t[4][0]==1)return true;


		return false;
	}

	public static void main(String[] args) {

		int[][] a = {
				{1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{1, 0, 1, 0, 0},
				{1, 0, 0, 1, 0},
				{0, 0, 0, 0, 0}};
		System.out.println(reverse(a));


	}
}
