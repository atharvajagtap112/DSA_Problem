package Graph.Easy;

public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         int n=image.length;
         int m= image[0].length;
         int[][] result=new int[n][m];

         for (int i=0;i<n;i++){
             for (int j=0;j<m;j++){
                 result[i][j]=image[i][j];
             }
         }

         dfs(result, sr,sc,color,image[sr][sc]);
         return result;
    }

    private void dfs(int[][] image , int row, int col, int color, int initColor) {
        if(image[row][col]==color) return;

        image[row][col]=color;

        int [] dRow={-1,0,1,0};
        int [] dCol={0,1,0,-1};

        for (int i=0;i<4;i++){
            int curRow=dRow[i]+row;
            int curCol=dCol[i]+col;

            if(curRow>=0 && curRow<image.length&& curCol>=0&&curCol<image[0].length && image[curRow][curCol]==initColor){
                dfs(image,curRow,curCol,color,initColor);
            }

        }


    }
}
