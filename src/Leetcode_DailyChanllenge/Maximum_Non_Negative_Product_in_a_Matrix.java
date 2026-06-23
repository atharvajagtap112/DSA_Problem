package Leetcode_DailyChanllenge;

import java.util.Arrays;

public class Maximum_Non_Negative_Product_in_a_Matrix {

    int MOD=(int) 1e9+7;
    long IM=Long.MIN_VALUE;

    public long[] fun(int i,int j, int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        if(i==n-1&&j==m-1) return new long[]{ grid[i][j]};


        long maxVal= IM;
        long minVal=Long.MAX_VALUE;
        int val=grid[i][j];

        if(i+1<n){
            long[] down=fun(i+1,j,grid);
            maxVal=Math.max(maxVal,Math.max(   (down[0]*val) %MOD, (down[1]*val)%MOD  ));
            minVal=Math.min(minVal,Math.max(   (down[0]*val) %MOD, (down[1]*val)%MOD  ) );
        }

        if (j+1<m){
            long[] right=fun(i,j+1,grid);
            maxVal=Math.max(maxVal,Math.max(   (right[0]*val) %MOD, (right[1]*val)%MOD  ));
            minVal=Math.min(minVal,Math.max(   (right[0]*val) %MOD, (right[1]*val)%MOD  ) );
        }

        return new long[]{maxVal,minVal};


    }

    public int maxProductPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][][] dp=new int[n][m][n+m+1];
        for(int[][] arr1:dp){
            for(int[] arr:arr1){
                Arrays.fill(arr,-1);
            }

        }


        long[] result=fun(0,0,grid);

        return result[0]<0?-1:(int)  result[0]%MOD;
    }
}
