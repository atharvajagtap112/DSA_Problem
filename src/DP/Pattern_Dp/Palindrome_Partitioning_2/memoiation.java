package DP.Pattern_Dp.Palindrome_Partitioning_2;

import java.util.Arrays;

public class memoiation {
    public int fun(int i,String s,int[]dp){
        if (i==s.length())return 0;


        if (dp[i]!=-1)return dp[i];
        int min=(int)1e9 ;
        for (int j=i;j<s.length();j++){

            if(isPalindrome(i,j,s)){
                int pt=1+fun(j+1,s,dp);
                min=Math.min(pt,min);
            }
        }
        return dp[i]= min;
    }

    private boolean isPalindrome(int i, int j, String s) {

        while (i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return fun(0,s,dp)-1;
    }
}
