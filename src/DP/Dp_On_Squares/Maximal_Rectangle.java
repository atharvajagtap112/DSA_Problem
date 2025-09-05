package DP.Dp_On_Squares;

import java.util.Arrays;
import java.util.Stack;

public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {


      int n=matrix.length;
      int m=matrix[0].length;

        int []dp=new int[m];

      int max=0;
      for (int row=0;row<n;row++){
          for (int col=0;col<m;col++){
              int value=matrix[row][col]-'0';
              dp[col]= value==0?0:dp[col]+value;
          }

          max=Math.max(max,largestHistogram(dp,m));


      }
      return max;
    }

    private int largestHistogram(int[] dp, int n) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for (int i=0;i<=n;i++){
            if(!stack.isEmpty()&&(i==n||dp[stack.peek()]>=dp[i] )){
                int height=dp[stack.pop()];
                int width=0;
                if (stack.isEmpty())width=i;
                else width=i-stack.peek()-1;

                max=Math.max(max,width);
            }
            stack.push(i);
        }
        return max;
    }
}
