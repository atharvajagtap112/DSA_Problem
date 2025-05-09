package Graph.Shortest_Path_Algorithm_And_Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> pq=new LinkedList<>();
        if (grid[0][0]==0) pq.add(new int[]{0,0,1});

        int [][]dist=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                dist[i][j]=(int) 1e9;
            }
        }
        dist[0][0]=0;

        int[] dRow={0,0,-1,1,-1,-1,1,1};
        int [] dCol={-1,1,0,0,-1,1,1,-1};
        while (!pq.isEmpty()){
            int row=pq.peek()[0];
            int col=pq.peek()[1];
            int curDist=pq.peek()[2];
            pq.poll();

            if(row==n-1&&col==m-1) return curDist;
            for (int i=0;i<8;i++){
                int adjRow=dRow[i]+row;
                int adjCol=dCol[i]+col;
                int adjDist=curDist+1;


                if(adjRow>=0&&adjRow<n&&adjCol>=0&&adjCol<m&&grid[adjRow][adjCol]==0&&
                        dist[adjRow][adjCol]>adjDist
                ){
                    dist[adjRow][adjCol]=adjDist;
                    pq.add(new int[]{adjRow,adjCol,adjDist});
                }
            }
        }
        return -1;
    }
}
