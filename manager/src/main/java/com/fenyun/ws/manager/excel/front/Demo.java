package com.fenyun.ws.manager.excel.front;


public class Demo {
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++)
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            subSolutions[i] = tmpMax;
        }

        for (int i = 0; i < rodLength + 1; i++) {
            System.out.println(subSolutions[i]);
        }
        return subSolutions[rodLength];
    }

    static int get(int sum){
        char s[]= String.valueOf(sum).toCharArray();
        System.out.println(s);
        int answer[] =new int[33];
        answer[0] = answer[1] = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] == 49) {
                answer[i + 1] = answer[i] + answer[i - 1];
            }
            else if (s[i - 1] == 50 && s[i] < 54) {
                answer[i + 1] = answer[i] + answer[i - 1];
            }
            else {
                answer[i + 1] = answer[i];
            }
            System.out.println(String.valueOf(answer[i]));
        }
        System.out.println(String.valueOf(answer));
        return answer[s.length];
    }

    public static void main(String[] args) {
        //int[] values = new int[]{3, 7, 5, 9, 5};
        //int rodLength = values.length;

        System.out.println(get(12258123));
     //   System.out.println("Max rod value: " + getValue(values, rodLength));
    }
}
