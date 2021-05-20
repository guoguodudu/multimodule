package com.fenyun.ws.manager.thead;

import java.util.*;

public class Test {

	public static void main(String[] args) {

		int numerator=1;
		int denominator=223332332;

		StringBuilder fraction = new StringBuilder();
		// If either one is negative (not both)
		if (numerator < 0 ^ denominator < 0) {
			System.out.println(fraction.append("-"));
		}
		// Convert to Long or else abs(-2147483648) overflows
		long dividend = Math.abs(Long.valueOf(numerator));
		long divisor = Math.abs(Long.valueOf(denominator));
		fraction.append(String.valueOf(dividend / divisor));
		long remainder = dividend % divisor;
		if (remainder == 0) {
			 fraction.toString();
		}
		fraction.append(".");
		Map<Long, Integer> map = new HashMap<>();
		while (remainder != 0) {
			if (map.containsKey(remainder)) {
				fraction.insert(map.get(remainder), "(");
				fraction.append(")");
				break;
			}
			map.put(remainder, fraction.length());
			remainder *= 10;
			fraction.append(String.valueOf(remainder / divisor));
			remainder %= divisor;
		}
		System.out.println(fraction.toString());



		List<Integer> nums=new ArrayList<Integer>(Arrays.asList(3, 4, 3));


		System.out.println(nums.stream().allMatch(integer -> integer==3));;

		//System.out.println(permute(new int[]{1,2,3}));;
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> output = new ArrayList<Integer>();
		for (int num : nums) {
			output.add(num);
		}

		int n = nums.length;
		backtrack(n, output, res, 0);
		return res;
	}

	public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
		// 所有数都填完了
		if (first == n) {
			//System.out.println(output);
			res.add(new ArrayList<Integer>(output));
		}
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(output, first, i);

			System.out.println(output);
			// 继续递归填下一个数
			backtrack(n, output, res, first + 1);
			// 撤销操作
			Collections.swap(output, first, i);
			System.out.println(output);
		}
	}


	public static int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					System.out.println(dp[i-1]);
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}





	public static void reverseString(char[] s) {
		int length = s.length;
		//两个指针一个从第1个，一个从最后一个开始，
		//两两交换
		int left = 0;
		int right = length - 1;
		while (left < right) {
			swap(s, left++, right--);
		}
	}

	private static void swap(char[] array, int i, int j) {
		//第1种交换方式
		System.out.println(i+"----"+j);
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;

		//第2种交换方式
//        array[i] = (char) (array[i] + array[j]);
//        array[j] = (char) (array[i] - array[j]);
//        array[i] = (char) (array[i] - array[j]);

		//第3种交换方式
//        array[i] = (char) (array[i] - array[j]);
//        array[j] = (char) (array[i] + array[j]);
//        array[i] = (char) (array[j] - array[i]);

		//第4种交换方式
//        array[i] ^= array[j];
//        array[j] ^= array[i];
//        array[i] ^= array[j];
	}


}
