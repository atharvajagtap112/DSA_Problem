package DP.Easy.String.Edit_Distance;

import java.util.Arrays;

public class memoiation {
    public int fun1(int i,int j,String s,String t,int[][] dp){
        if (j<0){
            return i+1;
        }
        if (i<0){
            return j+1;
        }


        if (dp[i][j]!=-1)return dp[i][j];
        if (s.charAt(i)==t.charAt(j)){
            return dp[i][j]=fun(i-1,j-1,s,t,dp);
        }
        int insert=1+fun(i,j-1,s,t,dp);
        int delete=1+fun(i-1,j,s,t,dp);
        int replace=1+fun(i-1,j-1,s,t,dp);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance1(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int dp[][]=new int[n][m];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return fun(n-1,m-1,word1,word2,dp);
    }

    public int fun(int i,int j,String s,String t,int[][] dp){
        if (j==0){
            return i;
        }
        if (i==0){
            return j;
        }


        if (dp[i][j]!=-1)return dp[i][j];
        if (s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=fun(i-1,j-1,s,t,dp);
        }
        int insert=1+fun(i,j-1,s,t,dp);
        int delete=1+fun(i-1,j,s,t,dp);
        int replace=1+fun(i-1,j-1,s,t,dp);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int dp[][]=new int[n+1][m+1];

        for (int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return fun(n,m,word1,word2,dp);
    }
}
