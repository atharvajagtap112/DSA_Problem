package Recursion.Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
     char[][] board=new char[n][n];
     for (int i=0;i<board.length;i++){
         for (int j=0;j< board.length;j++){
             board[i][j]='.';
         }
     }
     List<List<String>> ans=new ArrayList<>();

     int[] left=new int[n];
     int[] upperDiagonal=new int[2*n-1];
     int[] lowerDiagonal=new int[2 *n-1];
     solve(0,board,ans,left,upperDiagonal,lowerDiagonal,n);

     return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> res,int[] left, int[] upperDiagonal, int[] lowerDiagonal,int n) {
        if (col==board.length){
         res.add(construct(board));
        }

        for (int row=0;row<board.length;row++){
            if (left[row]==0&&lowerDiagonal[row+col]==0&&upperDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                left[row]=1;
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                solve(col+1,board,res,left,upperDiagonal,lowerDiagonal,n);
                board[row][col]='.';
                left[row]=0;
                lowerDiagonal[row+col]=0;
                upperDiagonal[n-1+col-row]=0;

            }
        }
    }
    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList< String >();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
