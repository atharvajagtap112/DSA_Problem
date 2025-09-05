package DP.Pattern_Dp.Burst_Balloons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class tabulation {
   
    public int maxCoins(int[] nums) {
        ArrayList<Integer> list=  new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        list.add(0,1);

        list.add(list.size(),1);
        int n=list.size();
        int [][] dp=new int[n][n];

        for (int i=n-2;i>=1;i--){
            for (int j=i;j<=n-2;j++){

                int max=Integer.MIN_VALUE;
                for (int ind=i;ind<=j;ind++){
                    int cost=list.get(i-1)*list.get(ind)*list.get(j+1)+dp[i][ind-1]+dp[ind+1][j];
                    max=Math.max(max,cost);
                }
                 dp[i][j]= max;

            }
        }



        return dp[1][n-2];
    }
}
