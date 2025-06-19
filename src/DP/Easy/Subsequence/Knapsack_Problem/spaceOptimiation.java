package DP.Easy.Subsequence.Knapsack_Problem;

public class spaceOptimiation {
    static int knapsack(int W, int val[], int wt[]) {
        int[] prev=new int[W+1];
        int n=wt.length;
        for (int i=wt[0];i<=W;i++){
            prev[i]=val[0];
        }

        for (int ind=1;ind<n;ind++){
            int []curr=new int[W+1];
            for (int w=0;w<=W;w++){

                int notTake=prev[w];
                int take=Integer.MIN_VALUE;
                if (wt[ind]<=w){
                    take=val[ind]+prev[w-wt[ind]];
                }
                curr[w]= Math.max(notTake,take);
            }
            prev=curr;
        }
        return prev[W];
    }


}
