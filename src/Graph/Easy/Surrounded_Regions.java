package Graph.Easy;

public class Surrounded_Regions {
    public void solve(char[][] board) {

        int n=board.length;
        int m= board[0].length;
        int [][]visi=new int[n][m];

        for (int i=0;i<m;i++){
            if(board[0][i]=='0'&&visi[0][i]==0) dfs(0,i,visi, board);
            if(board[n-1][i]=='0'&& visi[n-1][i]==0) dfs(n-1,i,visi, board);
        }

        for (int i=0;i<n;i++) {
            if (board[i][0] == '0' && visi[i][0] == 0) dfs(i, 0, visi,board);
            if (board[i][m - 1] == '0' && visi[i][m - 1] == 0) dfs(i, m - 1, visi, board);
        }

        for (int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(board[i][j]=='0'&& visi[i][j]==0) board[i][j]='X';


    }

    private void dfs(int row, int col, int[][] visi, char [][]board ) {
        visi[row][col]=1;

        int [] dRow={-1,0,1,0};
        int [] dCol={0,1,0,-1};

        for (int i=0;i<4;i++){
         int nRow=dRow[i]+row;
         int nCol=dCol[i]+col;

         if(nRow>=0&& nRow<board.length && nCol>=0 && nCol<board[0].length && board[nRow][nCol]=='0'&& visi[nRow][nCol]==0) {
             dfs(nRow,nCol,visi,board);
         }
        }
    }
}
