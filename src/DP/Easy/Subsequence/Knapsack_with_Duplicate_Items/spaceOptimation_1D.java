package DP.Easy.Subsequence.Knapsack_with_Duplicate_Items;

public class spaceOptimation_1D {
    static int knapSack(int val[], int wt[], int capacity) {

        int n = wt.length;
        int[] prev = new int[capacity + 1];

        for (int W = wt[0]; W <= capacity; W++) {
            if (wt[0] <= W) prev[W] = (W / wt[0]) * val[0];
        }

        for (int ind = 1; ind < n; ind++) {

            for (int W = 0; W <= capacity; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if (wt[ind] <= W) {
                    take = val[ind] + prev[W - wt[ind]];
                }
                prev[W] = Math.max(notTake, take);
            }


        }
        return prev[capacity];
    }
}
