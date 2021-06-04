package com.fenyun.ws.manager.demo;

import java.util.*;

public class Dmi {
    public static void main(String[] args) {


        int[] nums = {1, 8,1,2,1,1}; int k=9;

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            int ans = 0;
            int temp = 0;
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i] - k);
                if (map.containsKey(nums[i] - k)) {
                    ans += map.get(nums[i] - k);
                }
                temp = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
                map.put(nums[i], temp);
                System.out.println(map);
            }
            System.out.println(ans);
        }




    public int[] twoSum(int[] nums, int target) {
        int[] r= new int[2];
        for(int i=0,length=nums.length;i<length;i++){
            for (int j=i+1;j<length;j++){
                if(target==nums[i]+nums[j]){
                    r[0]=i;
                    r[1]=j;
                    return r;
                }
            }
        }
        return null;
    }
}
