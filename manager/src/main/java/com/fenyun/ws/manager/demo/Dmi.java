package com.fenyun.ws.manager.demo;

import java.util.*;

public class Dmi {
    public static void main(String[] args) {
        String url="/accountingcore/u";
        int tempLength=url.indexOf('/',1)==-1?url.length():url.indexOf('/',1);
        String temp=url.substring(1,tempLength);


        System.out.println(temp);


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
