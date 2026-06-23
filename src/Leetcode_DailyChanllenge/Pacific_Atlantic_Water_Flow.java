package Leetcode_DailyChanllenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Pacific_Atlantic_Water_Flow {

    void dfs(int r,int c,int[][] heights,boolean[][] visi,int prev){
        int n=heights.length;
        int m=heights[0].length;
        if(visi[r][c] || r<0||c<0||r>=n||c>=m|| prev>heights[r][c]) return;

        visi[r][c]=true;
        int [][] dl={ {0,-1}, {-1,0}, {0,1},{1,0}};
        for (int [] d:dl){
            int x=d[0];
            int y=d[1];
            dfs(r+x,c+y,heights,visi,heights[r][c]);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
       List<List<Integer>> ans=new ArrayList<>();

        boolean[][] paci=new boolean[n][m];
        boolean[][] atlan=new boolean[n][m];

        for (int i=0;i<m;i++){
            dfs(0,i,heights,paci,heights[0][i]);
            dfs(n-1,i,heights,atlan,heights[n-1][i]);
        }

        for (int i=0;i<n;i++){
            dfs(i,0,heights,paci,heights[i][0]);
            dfs(i,m-1,heights,paci,heights[i][m-1]);
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (paci[i][j]&&atlan[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }
}
