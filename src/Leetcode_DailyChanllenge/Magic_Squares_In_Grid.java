package Leetcode_DailyChanllenge;

public class Magic_Squares_In_Grid {
    public static int numMagicSquaresInside(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int cnt=0;
        for (int row=2;row<n;row++){
            for (int col=2;col<m;col++){

                int[] rowSum=new int[3];
                int[] colSum=new int[3];
                int[] dia=new int[2];
                int[] arr=new int[10];

                boolean isTrue=false;
                for (int i=0;i<=2;i++){
                    if (grid[row-i][col-2]>9||grid[row-i][col-1]>9||grid[row-i][col]>9) {
                        isTrue=true;
                        break;
                    }
                    if(  (arr[grid[row-i][col-2]]!=0) ||(arr[grid[row-i][col-1]]!=0)|| (arr[grid[row-i][col]]!=0)) {
                        isTrue=true;
                        break;
                    }

                    arr[grid[row-i][col-2]]=1 ;
                    arr[grid[row-i][col-1]]=1;
                    arr[grid[row-i][col]]=1;

                }
                if (arr[0]==1||isTrue) continue;
                for (int i=0;i<=2;i++){

                    rowSum[i%3]=grid[row-i][col-2]+grid[row-i][col-1]+grid[row-i][col];
                    colSum[i%3]=grid[row-2][col-i]+grid[row-1][col-i]+grid[row][col-i];
                }



                dia[0]=grid[row][col]+grid[row-1][col-1]+grid[row-2][col-2];
                dia[1]=grid[row][col-2]+grid[row-1][col-1]+grid[row-2][col];

                if (rowSum[1]==rowSum[0]&&rowSum[2]==rowSum[0]&&colSum[0]==rowSum[0]&&colSum[1]==rowSum[0]&&colSum[2]==rowSum[0]&&
                        dia[0]==rowSum[0]&&dia[1]==rowSum[0]
                )cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        System.out.println(numMagicSquaresInside(new int[][]
                {  {3,2,9,2,7},
                {6,1,8,4,2},
                {7,5,3,2,7},
                        {2,9,4,9,6},
                        {4,3,8,2,5}
                }
                ));
    }
}
