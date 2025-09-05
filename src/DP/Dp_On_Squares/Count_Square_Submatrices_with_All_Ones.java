package DP.Dp_On_Squares;

import java.util.Stack;

public class Count_Square_Submatrices_with_All_Ones {


    public static int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int[][]dp=new int[n][m];
        int cnt=0;
       for (int i=0;i<n;i++){

           for (int j=0;j<m;j++){
               if (i==0||j==0){
                   dp[i][j]=matrix[i][j];
               }
               else if (matrix[i][j]==1){

                   dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
               }
               cnt+=dp[i][j];
           }
       }
       return cnt;
    }

    public static void main(String[] args) {
        int[][] mt={ {0,1,1,1},
                      {1,1,1,1 },
                {0,1,1,1}};

        System.out.println(countSquares(mt));
    }

}
