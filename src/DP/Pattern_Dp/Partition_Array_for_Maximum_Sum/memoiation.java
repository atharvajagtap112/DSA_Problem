package DP.Pattern_Dp.Partition_Array_for_Maximum_Sum;

import java.util.Arrays;

public class memoiation {
    public int fun(int i,int k,int[] arr,int n,int[]dp){
        if (i==n)return 0;

        if (dp[i]!=-1)return dp[i];

        int largestSum=0;
        int max=(int)-1e9;
        int cnt=0;
        for (int j=i;j<Math.min(i+k,n);j++) {
            max = Math.max(max, arr[j]);
            cnt++;
            int sum = cnt * max + fun(j + 1, k, arr, n,dp);
            largestSum = Math.max(largestSum, sum);
        }
        return dp[i]=largestSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(0,k,arr,n,dp);
    }
}
