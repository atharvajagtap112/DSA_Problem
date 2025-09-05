package DP.String.Print_LCS;

public class Print_Longest_Common_Subsequence {
    public String longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int[][] dp=new int[n+1][m+1];

        for (int i=0;i<n;i++) dp[i][0]=0;

        for (int j=0;j<m;j++) dp[0][j]=0;

        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){

                if (s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]= 1+dp[i-1][j-1];

                else dp[i][j]= Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        StringBuilder string=new StringBuilder();
        int i=n; int j=m;
        while (i>0&&j>0){
              if (s1.charAt(i-1)==s2.charAt(j-1)){
                  string.append(s1.charAt(i));
                  i--; j--;
              }
              else if (dp[i][j - 1] >dp[i - 1][j]) {
                  j--;
              }
              else i--;

        }


       return string.reverse().toString();


    }
}
