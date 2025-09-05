package DP.Longest_Increasing_Subsequence;

import java.util.Arrays;

public class memoiation {
    public int fun(int ind,int prev,int[] nums,int[][] dp){
        if (ind== nums.length) return 0;


        if (dp[ind][prev+1]!=-1)return dp[ind][prev+1];

        int notTake=fun(ind+1,prev,nums,dp);
        int take=0;
        if (prev==-1||nums[ind]>nums[prev]){
            take=1+fun(ind+1,ind,nums,dp);
        }

        return dp[ind][prev+1]= Math.max(take,notTake);
    }
    public int lengthOfLIS(int[] nums) {
         int n=nums.length;
        int [][] dp=new int[n][n+1];

        for (int i=0;i<n+2;i++){
            Arrays.fill(dp[i],-1);
        }


        return fun(0,-1,nums,dp);
    }
}
