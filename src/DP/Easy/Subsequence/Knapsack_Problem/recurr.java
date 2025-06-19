package DP.Easy.Subsequence.Knapsack_Problem;

public class recurr {
    static int fun(int ind,int W,int[] wt,int[] val){

        if (ind==0){
            if (wt[0]<=W) return val[ind];
            else return 0;
        }


        int notTake=fun(ind-1,W,wt,val);
        int take=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            take=val[ind]+fun(ind-1,W-wt[ind],wt,val);
        }
        return Math.max(notTake,take);
    }
    static int knapsack(int W, int val[], int wt[]) {
        return fun(wt.length-1,W,wt,val );

    }
}
