package Binary_Search.Hard;

public class Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high=(m*n)-1;
        while (low<=high){
            int mid=(low+high)/2;
            int col=mid%m;
            int row=mid/m;;
            if (matrix[row][col]==target){
                return true;
            }
            if (matrix[row][col]>target){
                high=mid-1;
            }
            else low=mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]matrix={
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(searchMatrix(matrix,3));
    }
}
