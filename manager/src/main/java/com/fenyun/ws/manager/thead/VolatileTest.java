package com.fenyun.ws.manager.thead;

public class VolatileTest {
	public static void main(String[] args) {
		int[] nums={1,1,2,2,9,2,4,4,4,4,4,4,4};

		int num=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]==num){
				count++;
			}else {
				count--;
				if(count==0){
					num=nums[i];
					count++;
				}
			}
		}


	}
}
