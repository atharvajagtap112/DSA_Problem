package DP.Ninjas_And_his_Friens____Cherry_Pickup_II;

public class Optimization {

    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        // Create two 2D arrays to store computed results: front and cur
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Initialize the front array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
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
                                value+=front[j1+dj1][j2+dj2];
                            }
                            else
                                value+= -1e8;
                            max=Math.max(max,value);
                        }

                    }
                    cur[j1][j2]=max;



                }

            }
            for (int a = 0; a < m; a++) {
                front[a] = cur[a].clone();
            }

        }

        return front[0][m - 1];
    }

}
