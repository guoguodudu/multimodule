package com.fenyun.ws.manager.demo.test;

import java.util.Stack;

import static com.fenyun.ws.manager.demo.StaticDemo.*;

public class Test {


    public static void main(String[] args) {


        int[] num = new int[]{5,2,3,4,3};
        System.out.println(new Test().getMax(num));


        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> sumstack = new Stack<Integer>();
        int i = 0;
        int tempsum = 0;
        int result = 0;
        while (i < num.length) {
            if (stack.size() == 0 || num[i] > stack.lastElement()) {// 如果数组的元素大于栈顶  put it into the stack

                stack.add(num[i]);
                sumstack.add(tempsum); // accumlate add
                tempsum = 0;
                i++;

            } else { // small than top ele of stack; pop out, and cal the accumate result
                int temp = stack.pop(); // the top ele
                tempsum += (temp + sumstack.pop());  // accumate add
                result = Math.max(tempsum * temp, result); // if the max one, otherwise swap

            }

        }

        System.out.println(result);

    }




    public int getMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        //求前缀和数组
        int[] sum = new int[numbers.length + 1];
        for (int i = 1; i <= numbers.length; i++) {
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        for(int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]) {
                int index = stack.pop();
                int left = i;
                int right = i;
                if (stack.isEmpty()) {
                    left = 0;
                } else {
                    left = index;
                }
                //用 O（1）取到前缀和
                max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left = numbers.length;
            int right = numbers.length;
            if (stack.isEmpty()) {
                left = 0;
            } else {
                left = index;
            }
            max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
        }
        return max;
    }
}
