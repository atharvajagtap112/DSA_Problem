package DP.Pattern_Dp.Minimum_Cost_to_Cut_a_Stick;

import java.util.ArrayList;
import java.util.Arrays;

public class tabulation {
    public int fun(int i, int j, ArrayList<Integer> list, int[][] dp){
        if(i>j)return 0;

        if (dp[i][j]!=-1)return dp[i][j];

        int min=(int) 1e9;
        for (int ind=i;ind<=j;ind++){
            int step=list.get(j+1)-list.get(i-1)+fun(i,ind-1,list,dp)+fun(ind+1,j,list,dp);
            min=Math.min(min,step);
        }

        return dp[i][j]= min;
    }

    public int minCost(int n, int[] cuts) {

        int c= cuts.length;
        Arrays.sort(cuts);
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        Arrays.stream(cuts).forEach(list::add);
        list.add(n);

        int[][] dp=new int[c+2][c+2];

        for (int i=n;i>=1;i--){
            for (int j=1;j<=n;j++ ){

                int min=(int) 1e9;
                for (int ind=i;ind<=j;ind++){
                    int step=list.get(j+1)-list.get(i-1)+dp[i][ind-1]+dp[ind+1][j];
                    min=Math.min(min,step);
                }

                 dp[i][j]= min;

            }
        }


        return dp[1][c];
    }
}
