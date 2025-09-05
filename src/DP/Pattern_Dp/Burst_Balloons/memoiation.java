package DP.Pattern_Dp.Burst_Balloons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class memoiation {
    public int fun(int i, int j, ArrayList<Integer> list,int[][] dp){
        if (i>j) return 0;

        if (dp[i][j]!=-1)return dp[i][j];

        int max=Integer.MIN_VALUE;
        for (int ind=i;ind<=j;ind++){
            int cost=list.get(i-1)*list.get(ind)*list.get(j+1)+fun(i,ind-1,list,dp)+fun(ind+1,j,list,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]= max;
    }
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list=  new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        list.add(0,1);

        list.add(list.size(),1); 
        int n=list.size();
        int [][] dp=new int[n][n];
        for (int [] row:dp){
            Arrays.fill(row,-1);
        }
        return fun(1,n-2,list,dp);
    }
}
