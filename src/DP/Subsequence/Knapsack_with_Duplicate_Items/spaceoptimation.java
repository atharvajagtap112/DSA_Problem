package DP.Subsequence.Knapsack_with_Duplicate_Items;

public class spaceoptimation {
    static int knapSack(int val[], int wt[], int capacity) {

        int n = wt.length;
        int[] prev = new int[capacity + 1];

        for (int W = wt[0]; W <= capacity; W++) {
            if (wt[0] <= W) prev[W] = (W / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            int[]cur=new int[capacity+1];
            for (int W = 0; W <= capacity; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = val[ind] + cur[W - wt[ind]];
                }
                cur[W] = Math.max(notTake, take);
            }

         prev=cur;
        }
        return prev[capacity];
    }
}
