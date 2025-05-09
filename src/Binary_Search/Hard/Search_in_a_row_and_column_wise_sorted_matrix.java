package Binary_Search.Hard;

public class Search_in_a_row_and_column_wise_sorted_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
     int row=0;
     int col=matrix[0].length-1;
     while (row<matrix.length&&col>=0){
         int ele=matrix[row][col];
         if (ele==target){
             return true;
         }
         if (ele<target){
             row++;
         }
         else col--;
     }
     return true;
    }
}
