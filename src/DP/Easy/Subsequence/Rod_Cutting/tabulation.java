package DP.Easy.Subsequence.Rod_Cutting;

import java.util.Arrays;

public class tabulation {
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
       for (int rodlength=0;rodlength<=n;rodlength++){
           dp[0][rodlength]=rodlength*price[0];
       }


       for (int ind=1;ind<n;ind++){
           for (int rodLength=0;rodLength<=n;rodLength++){
               int notTake=0+dp[ind-1][rodLength];
               int take=Integer.MIN_VALUE;
               int wt=ind+1;
               if (wt<=rodLength){
                   take=price[ind]+dp[ind][rodLength-wt];
               }
             dp[ind][rodLength]= Math.max(notTake,take);
           }
       }
        return dp[n-1][n];
    }
}
