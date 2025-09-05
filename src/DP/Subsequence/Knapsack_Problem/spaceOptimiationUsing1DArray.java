package DP.Subsequence.Knapsack_Problem;

public class spaceOptimiationUsing1DArray {
    static int knapsack(int W, int val[], int wt[]) {
        int[] prev=new int[W+1];


        int n=wt.length;



        for (int i=wt[0];i<=W;i++){
            prev[i]=val[0];
        }

        for (int ind=1;ind<n;ind++){

            for (int w=W;w>=0;w--){

                int notTake=prev[w];
                int take=Integer.MIN_VALUE;
                if (wt[ind]<=w){
                    take=val[ind]+prev[w-wt[ind]];
                }
                prev[w]= Math.max(notTake,take);
            }

        }
        return prev[W];
    }

}
