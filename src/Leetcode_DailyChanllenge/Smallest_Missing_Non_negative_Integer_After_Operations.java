package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Smallest_Missing_Non_negative_Integer_After_Operations {
    public int findSmallestInteger(int[] nums, int value) {
    int n= nums.length;
    int []arr=new int[value+1];
    for (int i:nums){
        int x=Math.abs(nums[i])%value;
        if (i>=0||x==0){
            arr[x]++;
        }
        else arr[value-x]++;
    }
    for (int i=0;i<n;i++){
        int x=i%value;
        if (arr[x]==0) return i;
        arr[x]--;
    }
    return n;
    }
}
