package com.fenyun.ws.manager.thead;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest {
	public static void main(String[] args) {

		String s="aaaa33";

		System.out.println(partition(s).toString());

	}


	//结果集
	public static  List<List<String>>  res = new ArrayList<>();
	//当前路径
	public static  List<String> path = new ArrayList<>();
	//回文串判断表 isPalindrome[i][j]=s[i...j]
	public static  boolean[][] isPalindrome;

	public  static List<List<String>>  partition(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		isPalindrome = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			isPalindrome[i][i] = true;
		}
		//回文状态转移dp[i][j]=arr[i]==arr[j]&&dp[i+1][j-1]
		for (int j = 1; j < len; j++) {
			for (int i = 0; i < j; i++) {
				if (j - i < 3) {
					isPalindrome[i][j] = arr[i] == arr[j];
				} else {
					isPalindrome[i][j] = arr[i] == arr[j] && isPalindrome[i + 1][j - 1];
				}
			}
		}
		//深度优先搜索
		DFS(s, 0, s.length() - 1, isPalindrome);
		return res;
	}

	//N叉树深度优先搜索
	private static void DFS(String s, int start, int end, boolean[][] isPalindrome) {
		if (start > end) {
			List<String> l = new ArrayList<>();
			l.addAll(path);
			res.add(l);
			return;
		}
		//N叉树分支遍历
		for (int len = 1; len <= end - start + 1; len++) {

			if (!isPalindrome[start][start + len - 1]) continue;
			//路径添加本分段
			path.add(s.substring(start, start + len));
			//下层继续深度优先搜索
			DFS(s, start + len, end, isPalindrome);
			//路径删除本分段
			path.remove(path.size() - 1);
		}
	}

}
