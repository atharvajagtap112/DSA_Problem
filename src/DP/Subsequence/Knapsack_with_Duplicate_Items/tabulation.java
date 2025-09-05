package DP.Subsequence.Knapsack_with_Duplicate_Items;

public class tabulation {

    static int knapSack(int val[], int wt[], int capacity) {

        int n = wt.length;
        int[][] dp = new int[n][capacity + 1];

        for (int W = wt[0]; W <= capacity; W++) {
            if (wt[0] <= W) dp[0][W] = (W / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= capacity; W++) {
                int notTake = 0 + dp[ind - 1][W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = val[ind] + dp[ind][W - wt[ind]];
                }
                dp[ind][W] = Math.max(notTake, take);
            }


        }
     return dp[n-1][capacity];
    }
}
