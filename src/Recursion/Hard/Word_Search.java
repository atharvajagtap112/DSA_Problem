package Recursion.Hard;

public class Word_Search {
    public static boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        if (m*n<word.length()) return false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)&&find(word,0,i,j,board)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean find(String word,int ind,int i,int j,char [][] board){
        int n=board.length;
        int m=board[0].length;
        if (i<0||j<0||i>=n||j>=m||board[i][j]=='$') return false;
        if (ind==word.length()) return true;
        if (board[i][j]!=word.charAt(ind)) return false;

        char prev=board[i][j];
        board[i][j]='$';
         boolean right =find(word,ind+1,i,j+1,board);
         if (right) return true;

         boolean left=find(word,ind+1,i,j-1,board);
         if(left) return true;
         boolean up= find(word,ind+1,i-1,j,board);
         if(up) return true;
         boolean down=find(word,ind+1,i+1,j,board);
         if (down) return true;
        board[i][j]=prev;
         return false;
    }

    public static void main(String[] args) {
        char [][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board,"ABCB"));
    }
}
