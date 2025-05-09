package Graph.Easy;

public class Number_of_Enclaves {
    public int numEnclaves(int[][] grid) {

         int n=grid.length;
         int m= grid[0].length;
        int [][] visi=new int[n][m];

        for (int j=0;j<m;j++){
            if(grid[0][j]==1&&visi[0][j]==0){
                dfs(0,j,visi,grid);
            }

            if(grid[n-1][j]==1&&visi[n-1][j]==0){
                dfs(n-1,j,visi,grid);
            }
        }

        for (int i=0;i<n;i++){
            if(grid[0][i]==1&&visi[0][i]==0){
                dfs(0,i,visi,grid);
            }
            if(grid[m-1][i]==1&&visi[m-1][i]==0){
                dfs(m-1,i,visi,grid);
            }
        }


        int count=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(grid[i][j]==1&& visi[i][j]==0) count++;
            }
        }
        return count;
    }

    private void dfs(int row, int col, int[][] visi, int[][] grid) {
       visi[row][col]=1;

        int [] dRow={-1,0,1,0};
        int [] dCol={0,1,0,-1};
       for (int i=0;i<4;i++){
           int nRow=dRow[i]+row;
           int nCol=dCol[i]+col;

           if(nRow>=0&& nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]==1&& visi[nRow][nCol]==0) {
               dfs(nRow,nCol,visi,grid);
           }
       }
    }
}
