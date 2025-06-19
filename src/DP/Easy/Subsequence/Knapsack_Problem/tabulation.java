package DP.Easy.Subsequence.Knapsack_Problem;

import java.util.Arrays;

public class tabulation {
    static int knapsack(int W, int val[], int wt[]) {
        int n=wt.length;
        int[][] dp=new int[n][W+1];


        for (int i=wt[0];i<=W;i++){
            dp[0][i]=val[0];
        }

        for (int ind=1;ind<n;ind++){
            for (int w=0;w<=W;w++){

                int notTake=dp[ind-1][w];
                int take=Integer.MIN_VALUE;
                if (wt[ind]<=w){
                    take=val[ind]+dp[ind-1][w-wt[ind]];
                }
                dp[ind][w]= Math.max(notTake,take);
            }
        }
        return dp[n-1][W];
    }

}
