package Graph.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {

       class Pair{
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[n][m];
        int fresh=0;

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=2;
                    q.add(new Pair(i,j,0));
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int [] dRow={-1,0,1,0};
        int [] dCol={0,1,0,-1};
        int maxTime=0;
        int count=0;
        while (!q.isEmpty()){

            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int currTime=p.time;

            for (int i=0;i<4;i++){
                int adjRow=row+dRow[i];
                int adjCol=col+dCol[i];

                if (adjRow>=0&& adjRow<n  && adjCol>=0 && adjCol<m && grid[adjRow][adjCol]==1&& visited[adjRow][adjCol]!=2){
                    q.add(new Pair(adjRow,adjCol,currTime+1));
                    count++;
                    maxTime++;
                }
            }
        }

        if(fresh!=count) return -1;
        return maxTime;
    }

}
