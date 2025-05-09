package Recursion.Hard;

import java.util.ArrayList;

public class Rat_in_a_Maze_Problem {
//    public ArrayList<String> findPath(int[][] mat) {
//         ArrayList<String> ans=new ArrayList<>();
//
//          findPathHelper(mat,0,0,"",mat.length,ans);
//         return ans;
//    }
//
//    private void findPathHelper(int[][] mat, int row, int col, String s,int n,ArrayList<String> ans) {
//        if (row==n&&col==n){
//            ans.add(s);
//            return;
//    }
//       if (col<0||col>=n||row<0||row>=n||mat[row][col]==0) return;
//
//        mat[row][col]=0;
//
//        findPathHelper(mat,row,col-1,s+'L',n,ans);
//        findPathHelper(mat,row,col+1,s+'R',n,ans);
//        findPathHelper(mat,row+1,col,s+'D',n,ans);
//        findPathHelper(mat,row-1,col,s+'U',n,ans);
//
//        mat[row][col]=1;
//}

    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans=new ArrayList<>();
        int []Di={1,0,0,-1};
        int[] Dj={0,-1,1,0};
        findPathHelper(mat,0,0,"",mat.length,ans,Di,Dj);
        return ans;
    }

    private static void findPathHelper(int[][] mat, int row, int col, String s,int n,ArrayList<String> ans,int[] Di,int[] Dj) {
        if (row == n - 1 && col == n - 1) {
            ans.add(s);
            return;
        }

        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int nexti = row + Di[ind];
            int nextj = col + Dj[ind];
            if (col >= 0 && col < n && row >= 0 && row < n && mat[row][col] == 1) {
                mat[row][col] = 0;
                findPathHelper(mat, row, col - 1, s + dir.charAt(ind), n, ans, Di, Dj);
                mat[row][col] = 1;
            }
        }


    }
 
    public static void main(String[] args) {
        int[][] mat={
            {1,0,0,0},
            {1,1,0,0},
                {0,1,0,0},
                {0,1,1,1}
        };
        findPath(mat);
    }
}
