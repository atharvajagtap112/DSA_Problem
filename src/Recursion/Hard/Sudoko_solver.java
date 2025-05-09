package Recursion.Hard;

public class Sudoko_solver {
    public void solveSudoku(char[][] board) {
        solve(board);

    }

    private boolean solve(char[][] board) {
        for (int i=0;i<board.length;i++){
            for (int j=0;i<board[0].length;i++){
                if (board[i][j]=='.'){
                    for (char d='1';d<='9';d++){
                        if (isvalid(i,j,d,board)){
                          board[i][j]=d;
                          if(solve(board)) return true;
                          board[i][j]='.';

                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    private boolean isvalid(int row, int col, char digit, char[][] board) {
           for (int i=0;i<9;i++){
               if (board[row][i]==digit) return false;
               if (board[i][col]==digit) return false;
               if (board[3*(row/3)+i/3][3*(col/3)+i%3]==digit) return false;
           }
           return true;
    }
}
