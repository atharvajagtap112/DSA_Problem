package DP.Easy.Subsequence;

import java.util.Arrays;

public class Count_Subsets_with_Sum_K {
   static int MOD = 1000000007;
    static int fun1(int ind,int[] arr,int target){
    if (target==0) return 1;

    if (ind==0) return arr[ind]==target?1:0;

    int notTake=fun1(ind-1,arr,target);
    int take=0;
    if (arr[ind]<=target){
        take=fun1(ind-1,arr,target-arr[ind]);
    }


    return (notTake+take)%MOD;
}

    public static int findWays1(int num[], int tar) {
        return fun1(num.length-1,num,tar);
    }

    static int fun(int ind,int[] arr,int target,int[][]dp){
        if (target==0) return 1;

        if (ind==0) return arr[ind]==target?1:0;
        if (dp[ind][target]!=-1) return dp[ind][target];

        int notTake=fun(ind-1,arr,target,dp);
        int take=0;
        if (arr[ind]<=target){
            take=fun(ind-1,arr,target-arr[ind],dp);
        }


        return  dp[ind][target]=(notTake+take)%MOD;
    }

    public static int findWays(int num[], int tar) {
        int n=num.length;
        int [][]dp=new int[n+1][tar+1];
        for (int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(num.length-1,num,tar,dp);
    }
}
