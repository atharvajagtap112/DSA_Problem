package DP.Easy.Ninjas_And_his_Friens____Cherry_Pickup_II;

public class Tabulation {

    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int [][][] dp=new int[n][m][m];

        //Base Case
        for (int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if (j1==j2) dp[n-1][j1][j2]= grid[n-1][j1];
                else dp[n-1][j1][j2]= grid[n-1][j1]+grid[n-1][j2];
            }
        }

        for (int i=n-2;i>=0;i--){
            for (int j1=0;j1<m;j1++){
                for (int j2=0;j2<m;j2++){


                    int[] dj={-1,0,1};
                    int max=0;
                    for (int dj1:dj){
                        for (int dj2:dj){
                            int value=0;
                            if(j1==j2){
                                value=grid[i][j1];
                            }
                            else value=grid[i][j1]+grid[i][j2];

                            if(j1+dj1>=0 && j1+dj1<m && j2+dj2>=0 && j2+dj2<m){
                                value+=dp[i+1][j1+dj1][j2+dj2];
                            }
                            else
                            value+= -1e8;
                            max=Math.max(max,value);
                        }
                    }

                    dp[i][j1][j2]=max;

                }
            }
        }

        return dp[0][0][m - 1];
    }

}
