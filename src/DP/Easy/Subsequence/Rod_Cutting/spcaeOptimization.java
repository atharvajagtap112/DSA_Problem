package DP.Easy.Subsequence.Rod_Cutting;

public class spcaeOptimization {
    public int cutRod(int[] price) {

        int n= price.length;
        int[] prev=new int[n+1];
        for (int rodlength=0;rodlength<=n;rodlength++){
            prev[rodlength]=rodlength*price[0];
        }


        for (int ind=1;ind<n;ind++){
            int []cur=new int[n+1];
            for (int rodLength=0;rodLength<=n;rodLength++){
                int notTake=0+prev[rodLength];
                int take=Integer.MIN_VALUE;
                int wt=ind+1;
                if (wt<=rodLength){
                    take=price[ind]+cur[rodLength-wt];
                }
                cur[rodLength]= Math.max(notTake,take);
            }
        }
        return prev[n];
    }
}
