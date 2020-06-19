package com.fenyun.ws.manager.demo;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Demo {

    private Integer age;
    private String bankCard;
    private String passTime;
    private String person;
    private String transactionNo;
    private String type;

    public static int massage(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int dp0 = 0, dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempDp0 = dp0, tempDp1 = dp1;
            System.out.println("i=" + i + " dp0=" + dp0 + " dp1=" + dp1);
            dp0 = Math.max(tempDp0, tempDp1);
            dp1 = tempDp0 + nums[i];
        }
        return dp0 > dp1 ? dp0 : dp1;

    }

    public static void main(String[] args) {

        String con="-1";
        System.out.println(con.contains("-"));

    }

    public static int numsadd4(int n) {

        int sum=n;
        boolean bool=(n!=0) && ((sum+=numsadd4(n-1))!=0);
        return sum ;
    }

    public static int[] numsadd(int[] nums) {

        if (nums == null && nums.length <= 1) return null;

        int[] res = new int[nums.length];

        int result = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result *= nums[i - 1];
            res[i] = result;
        }
        result = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result *= nums[i + 1];
            res[i] *= result;

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }

    public static int nums(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : nums) {

            if (!set.remove(num)) {
                continue;
            }

            int count = 1;

            int tmp = num;

            while (set.remove(--num)) {
                count += 1;
            }

            while (set.remove(++tmp)) {
                count += 1;
            }

            res = Math.max(res, count);


            if (res >= set.size()) {
                break;
            }
        }

        return res;
    }
}
