package Leetcode_DailyChanllenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings {

    int fun(int i,int j,StringBuilder s1,StringBuilder s2,int[][] dp){


        Integer n= s1.length();
        int m=s2.length();
        if(s1==s2) return 0;
        if(i>=s1.length()&&j>=s2.length()) return (int)1e7;
         if(dp[i][j]!=-1)return dp[i][j];
        //equal
        int notTake=Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)) notTake=fun(i+1,j+1,s1,s2,dp);

        int takeLeft=Integer.MAX_VALUE;
        int takeRight=Integer.MAX_VALUE;
        int takeBoth=Integer.MAX_VALUE;

        if(i<n){
            char ch=s1.charAt(i);
            s1.deleteCharAt(i);
         takeLeft=(int)ch+fun(i+1,j,s1,s2,dp);
         s1.insert(i,ch);
        }

        if (j<m){
            char ch=s2.charAt(j);
            s2.deleteCharAt(j);
            takeRight=(int)ch+fun(i,j+1,s1,s2,dp);
            s2.insert(j,ch);
        }

        if(i<n&&j<m){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(j);
            s1.deleteCharAt(i);
            s2.deleteCharAt(j);
            takeRight=(int)ch1+(int)ch2+fun(i+1,j+1,s1,s2,dp);
            s1.insert(i,ch1);
            s2.insert(j,ch1);
        }

        return dp[i][j]= Math.min(notTake,Math.min(takeLeft,Math.min(takeRight,takeBoth)));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
  int[][] dp=new int[n][m];
  for (int[] arr:dp){
      Arrays.fill(arr,-1);
  }

  int result=fun(0,0,new StringBuilder(s1),new StringBuilder(s2),dp);
  return result>= (int) 1e7?0:result;
    }
}
