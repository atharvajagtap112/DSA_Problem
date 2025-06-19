package DP.Easy.Subsequence.Rod_Cutting;

import java.util.Arrays;

public class recurr {
    static int fun(int ind,int rodLength,int[] price,int[][]dp){
        if (ind == 0) {
            return rodLength*price[ind];
        }

        if (dp[ind][rodLength]!=-1)return dp[ind][rodLength];
        int notTake=0+fun(ind-1,rodLength,price,dp);
        int take=Integer.MIN_VALUE;
        int wt=ind+1;
        if (wt<=rodLength){
            take=price[ind]+fun(ind,rodLength-wt,price,dp);
        }
        return dp[ind][rodLength]= Math.max(notTake,take);
    }


    public int cutRod(int[] price) {

        int n= price.length;
        int[][] dp=new int[n][n+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return fun(n-1,n,price,dp);
    }
}
