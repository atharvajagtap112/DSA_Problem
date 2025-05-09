package Graph.Minimum_Spanning_Tree_And_Disjoint_Set_Problem;

import java.util.PriorityQueue;

public class Swim_in_Rising_Water {

    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int [][] visi=new int[n][n];
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->grid[a[0]][a[1]]-grid[b[0]][b[1]]);

        pq.add(new int []{0,0, grid[0][0]});
        visi[0][0]=1;
        while (!pq.isEmpty()){
            int [] node=pq.poll();
            int row=node[0];
            int col=node[1];
            int val=node[2];

            if(row==n-1&&col==n-1)return val;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int i=0;i<4;i++){
                int dRow=dr[i]+row;
                int dCol=dc[i]+col;
                if(dRow>=0&&dRow<n&&dCol>=0&&dCol<n&&visi[dRow][dCol]==0){
                    visi[dRow][dCol]=1;
                    pq.add(new int[]{dRow,dCol, Math.max(val, grid[dRow][dCol])});
                }
            }
        }
        return -1;
    }
}
