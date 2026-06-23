package Leetcode_DailyChanllenge;

import java.util.ArrayList;
import java.util.List;

public class Sudoku_Solver {

    public void solveSudoku(char[][] board) {

        List< int[]> list=new ArrayList<>();

        for (int i=0;i<9;i++ ){
            for (int j=0;j<9;j++){
                if(board[i][j]=='.') list.add(new int[]{i,j});
            }
        }

    }

    public boolean solve(int i,ArrayList<int[]> list,char[][] board){
        if(i==list.size()) return true;

        for (char d='1';d<='9';d++){
            int row=list.get(i)[0];
            int col=list.get(i)[1];
            if(canPlaced(row, col,board,d) ){
                board[row][col]=d;

                if(solve(i+1,list,board)) return true;

                board[row][col]='.';
            }
        }

        return false;
    }

    private boolean canPlaced(int row, int col, char[][] board, char d) {

        for (int r=0;r<=9;r++){
            if(board[r][col]==d) return false;
        }

        for (int c=0;c<=9;c++){
            if (board[row][c]==d) return false;
        }

        int cubeRow=row/3;
        int cubeCol=col/3;

        for (int r=cubeRow;r<cubeRow+3;r++){
            for (int c=cubeCol;c<cubeCol+3;c++){
                if(board[r][c]==d)return false;
            }
        }
        return true;
    }


}
