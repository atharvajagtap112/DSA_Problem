package DP.Easy.Ninjas_And_his_Friens____Cherry_Pickup_II;

public class Recurrsive {

    public int fun(int i,int j1,int j2,int[][] grid){
        int n= grid.length;
        int m= grid[0].length;
        if(j1<0||j1>=m||j2<0||j2>=m) return (int) -1e8;

        if(i==n-1){
            if (j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }

        int[] dj={-1,0,1};
        int max=0;
        for (int dj1:dj){
            for (int dj2:dj){
                int value=0;
                if(j1==j2){
                    value=grid[i][j1];
                }
                else value=grid[i][j1]+grid[i][j2];
                value+=fun(i+1,j1+dj1,j2+dj2,grid);
                max=Math.max(max,value);
            }
        }

        return max;
    }
    public int cherryPickup(int[][] grid) {
       return fun(0,0,grid[0].length-1,grid);
    }
}
