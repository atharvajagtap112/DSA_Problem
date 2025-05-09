package Arrays.medium;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
 int col=1;
 //row-->row[][0]
        //col-->co[0][]
   for (int i=0;i<matrix.length;i++){
       for (int j=0;j< matrix[0].length;j++){
           if (matrix[i][j]==0){
               matrix[i][0]=0;
               if(j!=0){
                   matrix[0][j]=0;
               }
             else {
                 col=0;}
           }
       }

   }
   for (int i=1;i<matrix.length;i++){
       for (int j=1;j<matrix[0].length;j++){
           if (matrix[i][j]!=0){
           if (matrix[0][j]==0||matrix[i][0]==0){
               matrix[i][j]=0;
           }}
       }}
       if (matrix[0][0]==0){
           for (int j=1;j<matrix[0].length;j++){
               matrix[0][j]=0;
           }
       }
       if (col==0){
           for (int j=0;j<matrix.length;j++){
               matrix[j][0]=0;
           }
       }

   }



    public static void main(String[] args) {
        int [][]ans={{1},
                {0},

        };
        setZeroes(ans);

        for (int []a:ans){
            System.out.println(Arrays.toString(a));
        }

}}
