package DP.Easy.Ninjas_And_his_Friens____Cherry_Pickup_II;

public class Memoiation {

    public int fun(int i,int j1,int j2,int[][] grid, int [][][] dp){
        int n= grid.length;
        int m= grid[0].length;
        if(j1<0||j1>=m||j2<0||j2>=m) return (int) -1e8;

        if(i==n-1){
            if (j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }

        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];

        int[] dj={-1,0,1};
        int max=0;
        for (int dj1:dj){
            for (int dj2:dj){
                int value=0;
                if(j1==j2){
                    value=grid[i][j1];
                }
                else value=grid[i][j1]+grid[i][j2];
                value+=fun(i+1,j1+dj1,j2+dj2,grid, dp);
                max=Math.max(max,value);
            }
        }

        return dp[i][j1][j2]=max;
    }
    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int [][][] dp=new int[n][m][m];

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                for (int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return fun(0,0,grid[0].length-1,grid,dp);
    }
}
