package Leetcode_DailyChanllenge;

public class Greatest_Sum_Divisible_by_Three {

    public int fun(int i,int [] nums,int mod,Integer[][]dp ){
        if(i== nums.length){
            if (mod==0)return 0;
            return Integer.MIN_VALUE;
        }

        if(dp[i][mod]!=null)return dp[i][mod];

        int take=nums[i]+fun(i+1,nums,(mod+nums[i]%3)%3,dp);
        int notTake=fun(i+1,nums,mod,dp);

        return dp[i][mod]=Math.max(take,notTake);
    }
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
     Integer[][] dp=new Integer[n][3];
      int result=
       fun(0,nums,0,dp);
      return result==Integer.MIN_VALUE?0:result;

    }
}
