package DP.Pattern_Dp.Different_Ways_to_Evaluate_a_Boolean_Expression;

import java.util.Arrays;

public class tabulation {
    public int fun(int i,int j,String s,int isTrue,int[][][]dp){
        if(i>j)return 0;

        if (i==j){
            if (isTrue==1) return s.charAt(i)=='T'?1:0;
            else return s.charAt(i)=='F'?1:0;
        }

        if (dp[i][j][isTrue]!=-1)return dp[i][j][isTrue];

        int way=0;
        for (int k=i+1;k<=j-1;k+=2){
            int lt=fun(i,k-1,s,1,dp);
            int lf=fun(i,k-1,s,0,dp);
            int rt=fun(k+1,j,s,1,dp);
            int rf=fun(k+1,j,s,0,dp);

            if (s.charAt(k)=='&'){
                if (isTrue==1){
                    way+= lt*rt;
                }
                else way+= lt*rf+lf*rt+lf*rf;
            }

            else if (s.charAt(k)=='|'){
                if (isTrue==1){
                    way+= lt*rf+lf*rt+lt*rt;
                }
                else way+= lf*rf;
            }

            else {
                if (isTrue==1) way+= lt*rf+lf*rt;
                else way+= lt*rt+rf*lf;
            }
        }
        return dp[i][j][isTrue]= way;
    }
    public int countTrue(String s) {
        int n=s.length();
        int [][][]dp=new int[n+1][n+1][2];
        for (int i=0;i<n;i+=2){
            for (int isTrue=0;isTrue<=1;isTrue++){
                if (isTrue==1)dp[i][i][isTrue]=s.charAt(i)=='T'?1:0;
                else dp[i][i][isTrue]=s.charAt(i)=='F'?1:0;
            }
        }


        for (int i = n - 1; i >= 0; i -= 2) {
            for (int j = i + 2; j < n; j += 2) {

                  for (int isTrue=0;isTrue<=1;isTrue++) {
                      int way = 0;
                      for (int k = i + 1; k <= j - 1; k += 2) {
                          int lt = dp[i][ k - 1][1];
                          int lf = dp[i][k - 1][0];
                          int rt = dp[k + 1][ j][1];
                          int rf = dp[k + 1][ j][0];

                          if (s.charAt(k) == '&') {
                              if (isTrue == 1) {
                                  way += lt * rt;
                              } else way += lt * rf + lf * rt + lf * rf;
                          } else if (s.charAt(k) == '|') {
                              if (isTrue == 1) {
                                  way += lt * rf + lf * rt + lt * rt;
                              } else way += lf * rf;
                          } else {
                              if (isTrue == 1) way += lt * rf + lf * rt;
                              else way += lt * rt + rf * lf;
                          }
                      }

                       dp[i][j][isTrue] = way;
                  }
            }
        }


        return dp[0][n-1][1];
    }
}
