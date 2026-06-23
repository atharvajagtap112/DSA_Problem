package Leetcode_DailyChanllenge;

public class CountUnguardedCellsintheGrid {
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] arr=new int[m][n];
        for(int [] pair:guards){
            arr[pair[0]][pair[1]]=1;
        }

        for(int [] pair:walls){
            arr[pair[0]][pair[1]]=1;
        }

        for(int [] guard:guards){

            int col=guard[0];
            int row=guard[1];

            for(int c=col+1;c<n;c++){
                if(arr[row][c]==1)break;
                arr[row][c]=-1;
            }
            for(int c=col-1;c>=0;c--){
                if(arr[row][c]==1) break;
                arr[row][c]=-1;
            }

            for(int r=row-1;r>=0;r--){
                if(arr[r][col]==1)break;
                arr[r][col]=-1;
            }

            for(int r=row+1;r<m;r++){
                if(arr[r][col]==1)break;
                arr[r][col]=-1;
            }
        }

        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        countUnguarded(4,6,new int[][]{ {0,0}, {1,1},{2,3}},new int[][]{{0,1},{2,2},{1,4}});
    }
}
