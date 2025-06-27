package DP.Easy.String.Wildcard_Matching;

import java.util.Arrays;

public class memoiation {
    public boolean fun(int i,int j,String s,String p,int[][] dp){
        if (i<0&&j<0)return true;
        if (j<0&&i>=0)return false;
        if (i<0&&j>=0){
            for (int jj=0;jj<=j;jj++){
                if (p.charAt(jj)!='*') return false;
            }
            return true;
        }

        if (dp[i][j]!=-1)return dp[i][j] == 1;

        if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?' ) {
             boolean match=fun(i-1,j-1,s,p,dp);
             dp[i][j] =match?1:0;
             return match;
        }
        else if (p.charAt(j)=='*'){
             boolean notTake=fun(i,j-1,s,p,dp);
             boolean take=fun(i-1,j,s,p,dp);
             dp[i][j]= (notTake || take) ?1:0;
            return  notTake||take;
        }

        return false;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n][m];

        for (int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

         fun(n-1,m-1,s,p,dp);
         return dp[n-1][m-1]==1;

    }
}
