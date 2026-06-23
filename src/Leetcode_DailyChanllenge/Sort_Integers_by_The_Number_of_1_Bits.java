package Leetcode_DailyChanllenge;

import java.util.Arrays;

public class Sort_Integers_by_The_Number_of_1_Bits {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
           Integer[] temp=new Integer[arr.length];
           for (int i=0;i<n;i++){
               temp[i]=arr[i];
           }
        Arrays.sort(temp,(a, b)->{
            int bit1=Integer.bitCount((Integer) a);
            int bit2=Integer.bitCount((Integer) b);
            if(bit1==bit2) return Integer.compare((Integer) a, (Integer) b);
            return Integer.compare(bit1,bit2);
        });

        for (int i=0;i<n;i++){
            arr[i]=temp[i];
        }
        return arr;
    }
}
