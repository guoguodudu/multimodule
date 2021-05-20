package com.fenyun.ws.manager.thead;

import java.util.HashMap;

public class TestTest {

	public static void main(String[] args) {

		int[] nums ={2,2,2,1,2,2,1,1,2,2};int  k = 2;
		int res = 0;
		int s=0; // 奇数的个数
		HashMap<Integer,Integer> map = new HashMap<>();
		//空集合使得奇数个数为0
		map.put(s,1);
		for(int i=0;i<nums.length;i++){
			if(nums[i]%2==1){
				s++;
			}
			if(s-k>=0){
				res +=map.get(s-k);
			}
			if(map.containsKey(s)){
				map.put(s,map.get(s)+1);
			}else{
				map.put(s,1);
			}
		}
		System.out.println(res);
	}
}
